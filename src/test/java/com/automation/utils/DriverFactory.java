import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            driver.set(createChromeDriver());
        }
        return driver.get();
    }

    private static WebDriver createChromeDriver() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");

        boolean isCI = "true".equalsIgnoreCase(System.getenv("CI"));
        boolean isHeadless = "true".equalsIgnoreCase(System.getProperty("headless"));

        if (isCI || isHeadless) {
            options.addArguments("--headless=new");
        }

        return new ChromeDriver(options);
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
