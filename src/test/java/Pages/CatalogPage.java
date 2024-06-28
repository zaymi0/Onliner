package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class CatalogPage extends Filter {
    @FindBy(css = "div.catalog-form__description>[href$='prices']" )
    private ElementsCollection allPrices;
    @FindBy(css = ".catalog-form__offers-list>[class$='primary']:first-child [class$='image']")
    private SelenideElement firstProductInCatalog;
    @FindBy(css = "div.b-top-actions")
    private Head head;
    @FindBy(css = ".catalog-form__filter-part.catalog-form__filter-part_1.js-container")
    private Filter filter;

    public boolean priceCheck(int maxPrice) {
        boolean priceCorrespondsParameters = true;
        List<String> prices = new ArrayList<>();
        for (int i = 0; i < allPrices.size(); i++) {
            if (allPrices.get(i).getText().charAt(0) == 'о') {
                String[] price = (allPrices.get(i).getText().split(" ", 2));
                price = price[1].split(",", 2);
                prices.add(price[0]);
            } else {
                String[] price = (allPrices.get(i).getText().split(",", 2));
                prices.add(price[0]);
            }
            for (String price : prices) {
                if (maxPrice < Integer.parseInt(price)) {
                    priceCorrespondsParameters = false;
                    break;
                }
            }
        }
        return priceCorrespondsParameters;
    }

    public void goToFirstProductPage() {
        firstProductInCatalog.click();
    }
}