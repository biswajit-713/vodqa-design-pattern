package factory;

import exception.FrameworkException;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.function.Supplier;

public class DriverFactory {

    private static DriverFactory driverFactory;
    private Map<String, Supplier<WebDriver>> browserMap = new HashMap<>();

    private Supplier<WebDriver> chromeDriver = () -> {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(options);
    };

    private Supplier<WebDriver> firefoxDriver = () -> {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        return new FirefoxDriver(options);
    };

    private DriverFactory() {
        browserMap.put(BrowserType.CHROME, chromeDriver);
        browserMap.put(BrowserType.FIREFOX, firefoxDriver);
    }

    public static DriverFactory getInstance() {
        if (driverFactory == null) {
            driverFactory = new DriverFactory();
        }
        return driverFactory;
    }

    public WebDriver getDriver() {
         getBrowserForExecution().toLowerCase();
         return browserMap.getOrDefault(getBrowserForExecution().toLowerCase(), chromeDriver).get();
    }

    private String getBrowserForExecution() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/application_test.properties"));
            return properties.getProperty("browser");
        } catch (IOException e) {
            throw new FrameworkException(e.getLocalizedMessage());
        }

    }
}
