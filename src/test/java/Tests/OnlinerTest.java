package Tests;

import Pages.CatalogNavigationPage;
import Pages.CatalogPage;
import Pages.ProductPage;
import Settings.Manager;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class OnlinerTest {
    @BeforeEach
    public void setup() {
        String browserName = System.getProperty("browser", "chrome");
        Manager.setupBrowser(browserName);
        Manager.openStartPage();
    }

    @AfterEach
    public void teardown() {
        closeWebDriver();
    }

    @Test
    public void testSearchByProductName() {
        CatalogPage catalogPage = Selenide.page(CatalogPage.class);
        catalogPage.enterProductName("iphone 15");
        catalogPage.comparesProductNameWithFirstOneInList("Смартфон Apple iPhone 15 128GB (черный)");
    }

    @Test
    public void testFilteringProductsByPrice() throws InterruptedException {
        CatalogNavigationPage catalogNavigationPage = Selenide.page(CatalogNavigationPage.class);
        CatalogPage catalogPage = Selenide.page(CatalogPage.class);
        catalogNavigationPage.openCatalog("Электроника");
        catalogNavigationPage.waitForCatalogOpen();
        catalogNavigationPage.openSecondCatalog("Мобильные телефоны и аксессуары");
        catalogNavigationPage.openItem("Смартфоны");
        catalogPage.enterPriceUpTo("45");
        catalogPage.waitForProductDisplay();
        Thread.sleep(400);
        Assertions.assertTrue(catalogPage.priceCheck(45));
    }

    @Test
    public void testAddingItemToCart() {
        CatalogNavigationPage catalogNavigationPage = Selenide.page(CatalogNavigationPage.class);
        CatalogPage catalogPage = Selenide.page(CatalogPage.class);
        ProductPage productPage = Selenide.page(ProductPage.class);
        catalogNavigationPage.openCatalog("Электроника");
        catalogNavigationPage.waitForCatalogOpen();
        catalogNavigationPage.openSecondCatalog("Мобильные телефоны и аксессуары");
        catalogNavigationPage.openItem("Смартфоны");
        catalogPage.goToFirstProductPage();
        productPage.addItemToCart();
        productPage.checkNumberItemsInCart("1");
    }
}
