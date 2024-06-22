import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FilterPage {
    private static By priceUptoLocator = By.cssSelector("[placeholder='до']");

    private static By numberGoodsLocator = By.cssSelector
            ("[class='catalog-interaction__state catalog-interaction__state_initial" +
                    " catalog-interaction__state_disabled catalog-interaction__state_control']");

    public static void enterPriceUpTo(String price) {
        $(priceUptoLocator).sendKeys(price);
    }

    public static void waitForProductDisplay() {
        $(numberGoodsLocator).shouldBe(Condition.visible);
    }
}
