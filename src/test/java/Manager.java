import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.open;

public class Manager {
    public static void setupBrowser(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome" -> Configuration.browser = "chrome";
            case "firefox" -> Configuration.browser = "firefox";
            case "safari" -> Configuration.browser = "safari";
            case "edge" -> Configuration.browser = "edge";
        }
    }

    public static void openStartPage() {
        Configuration.baseUrl = "https://catalog.onliner.by/";
        Configuration.browserSize = "1920x1080";
        open(Configuration.baseUrl);
    }
}
