package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Container;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class Filter implements Container{
    @FindBy(css = "[placeholder='до']")
    private SelenideElement priceUpto;
    @FindBy(css = ".catalog-interaction__state.catalog-interaction__state_initial" +
            ".catalog-interaction__state_disabled.catalog-interaction__state_control")
    private SelenideElement numberGoods;
    @FindBy(css = "div.b-top-actions")
    private Head head;

    public void enterPriceUpTo(String price) {
        priceUpto.setValue(price);
    }

    public void waitForFilterToApply() {
        numberGoods.shouldBe(Condition.visible);
        Selenide.sleep(400);
    }
}
