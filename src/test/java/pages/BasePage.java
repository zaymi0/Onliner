package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import pages.components.Head;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;

public class BasePage {

    @FindBy(css = "div.b-top-actions")
    public Head head;
    @FindBy(css = "li.search__result")
    protected ElementsCollection allProductFromSearchBarList;

    public BasePage comparesPrxoductNameWithFirstOneInList(String productName) {
        allProductFromSearchBarList.get(0).shouldHave(text(productName));
        return Selenide.page(CatalogNavigationPage.class);
    }
}
