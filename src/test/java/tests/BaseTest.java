package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.impl.SelenidePageFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.CatalogNavigationPage;
import settings.ConfigurationProperties;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    protected CatalogNavigationPage catalogNavigationPage;
    @BeforeAll
    static void setupConfiguration() {
        Configuration.baseUrl = ConfigurationProperties.getBaseUrl();
        Configuration.browser = ConfigurationProperties.getBrowser();
    }

    @BeforeEach
    void openPage() {
       catalogNavigationPage = Selenide.open("/", CatalogNavigationPage.class);
    }

    @AfterEach
    void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }
}
