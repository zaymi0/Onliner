package pages.components;

import com.codeborne.selenide.Container;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.CatalogNavigationPage;
import pages.CatalogPage;

import static com.codeborne.selenide.Condition.text;

public class Head implements Container {
    @FindBy(css = ".auth-bar__counter")
    private SelenideElement numberItemsInCart;
    @FindBy(css = ".fast-search__input")
    private SelenideElement searchString;

    public CatalogNavigationPage enterProductName(String productName) {
        searchString.setValue(productName);
        return Selenide.page(CatalogNavigationPage.class);
    }

    public CatalogPage checkNumberItemsInCart(String expectedQuantityOfGoods) {
        numberItemsInCart.shouldHave(text(expectedQuantityOfGoods));
        return Selenide.page(CatalogPage.class);
    }
}
