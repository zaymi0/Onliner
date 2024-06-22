import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    private static By addItemToCartButtonLocator = By.cssSelector
            ("[class='product-aside__offers-item product-aside__offers-item_primary'] [class*='button_cart']");

    public static void addItemToCart() {
        $(addItemToCartButtonLocator).click();
    }
}
