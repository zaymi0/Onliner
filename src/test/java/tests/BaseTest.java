package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import pages.CatalogNavigationPage;
//import settings.Manager;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    public void setupBrowser(String browserName) {
        Configuration.browser = browserName.toLowerCase();
        open("https://catalog.onliner.by/", CatalogNavigationPage.class);
    }
}
