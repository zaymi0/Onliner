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
    public void searchByProductName() {
        SearchStringPage.enterProductName("iphone 15");
        SearchStringPage.comparesProductNameWithFirstOneInList("Смартфон Apple iPhone 15 128GB (черный)");
    }

    @Test
    public void filteringProductsByPrice() {
        CatalogNavigationPage.goElectronicsSection();
        CatalogNavigationPage.goMobilePhonesAndAccessories();
        CatalogNavigationPage.goSmartphones();
        FilterPage.enterPriceUpTo("45");
        FilterPage.waitForProductDisplay();
        Assertions.assertTrue(CatalogPage.priceCheck(45));
    }

    @Test
    public void addingItemToCart() {
        CatalogNavigationPage.goElectronicsSection();
        CatalogNavigationPage.goMobilePhonesAndAccessories();
        CatalogNavigationPage.goSmartphones();
        CatalogPage.goToFirstProductPage();
        ProductPage.addItemToCart();
        PageHead.checkNumberItemsInCart("1");
    }
}
