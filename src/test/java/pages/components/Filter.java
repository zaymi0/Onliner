package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Container;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import pages.CatalogPage;

public class Filter implements Container{
    @FindBy(css = "[placeholder='до']")
    private SelenideElement priceUpTo;
    @FindBy(css = ".catalog-interaction__state.catalog-interaction__state_initial" +
            ".catalog-interaction__state_disabled.catalog-interaction__state_control")
    private SelenideElement numberGoods;
    public CatalogPage enterPriceUpTo(String price) {
        priceUpTo.setValue(price);
        numberGoods.shouldBe(Condition.visible);
        Selenide.sleep(1000);
        return Selenide.page(CatalogPage.class);
    }
}
