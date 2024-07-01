package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CatalogPage extends BasePage {
    @FindBy(css = "div.catalog-form__description>[href$='prices']" )
    private ElementsCollection allPrices;
    @FindBy(css = "div.catalog-form__offers-list>[class$='primary'] [class$='image']")
    private ElementsCollection productInCatalog;
    @FindBy(css = "div.catalog-form__filter-part.catalog-form__filter-part_1.js-container")
    private Filter filter;

    public Filter getFilter() {
        return filter;
    }

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
        productInCatalog.get(0).click();
    }
}