package drivermanagement.manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class FirefoxDriverManager implements DriverManager{
    private WebDriver driver;

    @Override
    public void startService() {

    }

    @Override
    public void stopService() {

    }

    @Override
    public WebDriver getDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    @Override
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
