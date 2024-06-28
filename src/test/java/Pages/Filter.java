package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Container;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class Filter extends Head implements Container{
    @FindBy(css = "[placeholder='до']")
    private SelenideElement priceUpto;
    @FindBy(css = ".catalog-interaction__state.catalog-interaction__state_initial" +
            ".catalog-interaction__state_disabled.catalog-interaction__state_control")
    private SelenideElement numberGoods;
    @FindBy(css = "div.b-top-actions")
    private Head head;

    public void enterPriceUpTo(String price) {
        priceUpto.sendKeys(price);
    }

    public void waitForProductDisplay() {
        numberGoods.shouldBe(Condition.visible);
    }
}
