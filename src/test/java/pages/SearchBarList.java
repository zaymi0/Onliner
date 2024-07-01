package pages;

import com.codeborne.selenide.Container;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;

public class SearchBarList {
    @FindBy(css = "li.search__result")
    private ElementsCollection allProductFromSearchBarList;

    public void comparesProductNameWithFirstOneInList(String productName) {
        allProductFromSearchBarList.get(0).shouldHave(text(productName));
    }
}
