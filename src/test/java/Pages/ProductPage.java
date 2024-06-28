package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends Head {
    @FindBy(css = ".product-aside__offers-item.product-aside__offers-item_primary [class*='button_cart']")
    private SelenideElement addItemToCartButtonLocator;
    @FindBy(css = "div.b-top-actions")
    private Head head;

    public void addItemToCart() {
        addItemToCartButtonLocator.click();
    }
}
