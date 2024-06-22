import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CatalogNavigationPage {
    private static By electronicsLocator = By.cssSelector
            ("[class='catalog-navigation-classifier__item-icon'] [src$='S5w/bmc']");
    private static By mobilePhonesAndAccessoriesLocator = By.cssSelector
            ("[class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']");
    private  static By smartphonesLocator = By.cssSelector("[href$='mobile']>span");

    public static void goElectronicsSection() {
        $(electronicsLocator).click();
    }

    public static void goMobilePhonesAndAccessories() {
        $(mobilePhonesAndAccessoriesLocator).click();
    }

    public static void goSmartphones() {
        $(smartphonesLocator).click();
    }
}
