package tests;

import pages.CatalogPage;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OnlinerTest extends BaseTest {

    @Test
    public void testSearchByProductName() {
        catalogNavigationPage.head.enterProductName("iphone 15")
                    .comparesPrxoductNameWithFirstOneInList("Смартфон Apple iPhone 15 Pro Max 256GB (природный титан)");
    }

    @Test
    public void testFilteringProductsByPrice() {
        catalogNavigationPage.openCatalog("Электроника")
                    .openSecondCatalog("Мобильные телефоны и аксессуары")
                    .openItem("Смартфоны")
                    .getFilter().enterPriceUpTo("45");

        Assertions.assertTrue(Selenide.page(CatalogPage.class).priceCheck(45));
    }

    @Test
    public void testAddingItemToCart() {
        catalogNavigationPage.openCatalog("Электроника")
                    .openSecondCatalog("Мобильные телефоны и аксессуары")
                    .openItem("Смартфоны")
                    .goToFirstProductPage()
                    .addItemToCart()
                    .head.checkNumberItemsInCart("1");
    }
}
