import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CatalogPage {
    private static By priceLocator = By.cssSelector("[class^='catalog-form__description']>[href$='prices']");

    private static By firstProductInCatalogLocator = By.cssSelector
            ("[class='catalog-form__offers-list']>[class$='primary']:first-child [class$='image']");

    public static boolean priceCheck(int maxPrice) {
        ElementsCollection allPrices = $$(priceLocator);
        boolean priceCorrespondsParameters = true;
        System.out.println(allPrices.get(1).getText().substring(0, allPrices.get(1).getText().length() - 6));
        List<String> prices = new ArrayList<>();
        for (int i = 0; i < allPrices.size(); i++) {
            if (allPrices.get(i).getText().charAt(0) == 'о') {
                String[] str = (allPrices.get(i).getText().split(" ", 2));
                str = str[1].split(",", 2);
                prices.add(str[0]);
            } else {
                String[] str = (allPrices.get(i).getText().split(",", 2));
                prices.add(str[0]);
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

    public static void goToFirstProductPage() {
        $(firstProductInCatalogLocator).click();
    }
}