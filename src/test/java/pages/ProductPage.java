package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.Head;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    @FindBy(css = ".product-aside__offers-item.product-aside__offers-item_primary [class*='button_cart']")
    private SelenideElement addItemToCartButtonLocator;

    public ProductPage addItemToCart() {
        addItemToCartButtonLocator.click();
        return this;
    }
}
