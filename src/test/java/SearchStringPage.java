import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchStringPage {
    private static By searchStringLocator = By.cssSelector("[class='fast-search__input']");
    private static By firstProductFromSearchBarListLocator = By.cssSelector("[class='search__result']:first-child");

    public static void enterProductName(String productName) {
        $(searchStringLocator).sendKeys(productName);
    }

    public static void comparesProductNameWithFirstOneInList(String productName) {
        $(firstProductFromSearchBarListLocator).shouldHave(text(productName));
    }
}
