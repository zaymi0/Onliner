package tests;

import pages.CatalogNavigationPage;
import pages.CatalogPage;
import pages.ProductPage;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.SearchBarList;

public class OnlinerTest {
    @BeforeEach
    public void setup() {
        BaseTest baseTest = new BaseTest();
        baseTest.setupBrowser("chrome");
    }

    @Test
    public void testSearchByProductName() {
        CatalogPage catalogPage = Selenide.page(CatalogPage.class);
        SearchBarList searchBarList = Selenide.page(SearchBarList.class);
        catalogPage.getHead().enterProductName("iphone 15");
        searchBarList.comparesProductNameWithFirstOneInList("Смартфон Apple iPhone 15 128GB (черный)");
    }

    @Test
    public void testFilteringProductsByPrice() {
        CatalogNavigationPage catalogNavigationPage = Selenide.page(CatalogNavigationPage.class);
        CatalogPage catalogPage = Selenide.page(CatalogPage.class);
        catalogNavigationPage.openCatalog("Электроника");
        catalogNavigationPage.openSecondCatalog("Мобильные телефоны и аксессуары");
        catalogNavigationPage.openItem("Смартфоны");
        catalogPage.getFilter().enterPriceUpTo("45");
        catalogPage.getFilter().waitForFilterToApply();
        Selenide.sleep(400);
        Assertions.assertTrue(catalogPage.priceCheck(45));
    }

    @Test
    public void testAddingItemToCart() {
        CatalogNavigationPage catalogNavigationPage = Selenide.page(CatalogNavigationPage.class);
        CatalogPage catalogPage = Selenide.page(CatalogPage.class);
        ProductPage productPage = Selenide.page(ProductPage.class);
        catalogNavigationPage.openCatalog("Электроника");
        catalogNavigationPage.openSecondCatalog("Мобильные телефоны и аксессуары");
        catalogNavigationPage.openItem("Смартфоны");
        catalogPage.goToFirstProductPage();
        productPage.addItemToCart();
        productPage.getHead().checkNumberItemsInCart("1");
    }
}
