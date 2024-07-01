package pages;

import com.codeborne.selenide.Container;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;

public class BasePage {

    @FindBy(css = "div.b-top-actions")
    private Head head;

    public Head getHead() {
        return head;
    }
}
