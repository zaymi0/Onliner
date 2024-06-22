import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PageHead {
    private static By numberItemsInCartLocator = By.cssSelector("[class='auth-bar__counter']");

    public static void checkNumberItemsInCart(String expectedQuantityOfGoods) {
        $(numberItemsInCartLocator).shouldHave(text(expectedQuantityOfGoods));
    }
}
