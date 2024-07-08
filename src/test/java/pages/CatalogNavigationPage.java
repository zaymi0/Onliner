package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CatalogNavigationPage extends BasePage {
    @FindBy(css = "li.catalog-navigation-classifier__item")
    private ElementsCollection firstCatalogSections;
    @FindBy(css = "div.catalog-navigation-list__aside-item")
    private ElementsCollection secondCatalogSections;
    @FindBy(css = "a.catalog-navigation-list__dropdown-item")
    private ElementsCollection thirdCatalogSections;
    @FindBy(css = "div.catalog-navigation-list.catalog-navigation-list_active.catalog-navigation-list_opened")
    private SelenideElement secondCatalog;


    public CatalogNavigationPage openCatalog(String catalogName) {
            firstCatalogSections.filter(text(catalogName)).forEach(SelenideElement::click);
            return this;
    }

    public CatalogNavigationPage openSecondCatalog(String secondCatalogName) {
        secondCatalogSections.findBy(Condition.text(secondCatalogName)).click();
        return this;
    }

    public CatalogPage openItem(String thirdCatalogName) {
        thirdCatalogSections.findBy(Condition.text(thirdCatalogName)).click();
        return Selenide.page(CatalogPage.class);
    }
}
