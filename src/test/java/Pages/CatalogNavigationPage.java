package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CatalogNavigationPage extends Head {
    @FindBy(css = "li[class='catalog-navigation-classifier__item']")
    private ElementsCollection firstCatalogSections;
    @FindBy(css = "div.catalog-navigation-list__aside-item")
    private ElementsCollection secondCatalogSections;
    @FindBy(css = "a.catalog-navigation-list__dropdown-item")
    private ElementsCollection thirdCatalogSections;
    @FindBy(css = "div.catalog-navigation-list.catalog-navigation-list_active.catalog-navigation-list_opened")
    private SelenideElement secondCatalog;
    @FindBy(css = "div.b-top-actions")
    private Head head;


    public void openCatalog(String catalogName) {
            firstCatalogSections.filter(text(catalogName)).forEach(SelenideElement::click);
    }

    public void openSecondCatalog(String secondCatalogName) {
        secondCatalogSections.findBy(Condition.text(secondCatalogName)).click();
    }

    public void openItem(String thirdCatalogName) {
        thirdCatalogSections.findBy(Condition.text(thirdCatalogName)).click();
    }

    public void waitForCatalogOpen() {
        secondCatalog.shouldBe(clickable);
    }
}
