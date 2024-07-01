package pages;

import com.codeborne.selenide.Container;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;

public class Head implements Container {
    @FindBy(css = ".auth-bar__counter")
    private SelenideElement numberItemsInCart;
    @FindBy(css = ".fast-search__input")
    private SelenideElement searchString;

    public void enterProductName(String productName) {
        searchString.setValue(productName);
    }

    public void checkNumberItemsInCart(String expectedQuantityOfGoods) {
        numberItemsInCart.shouldHave(text(expectedQuantityOfGoods));
    }
}
