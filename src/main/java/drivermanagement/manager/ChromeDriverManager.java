package drivermanagement.manager;

import exception.SpreeTestException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ChromeDriverManager implements DriverManager{

    private static ChromeDriverService service;
    private WebDriver driver;

    @Override
    public void startService() {
        if (null == service) {
            WebDriverManager.chromedriver().setup();
            service = new ChromeDriverService.Builder().usingDriverExecutable(new File("~/.cache/selenium/chromedriver"))
                    .usingAnyFreePort()
                    .build();
            try {
                service.start();
            } catch (IOException e) {
                throw new SpreeTestException(e.getLocalizedMessage());
            }
        }
    }

    @Override
    public void stopService() {
        if (null != service && service.isRunning()) {
            service.stop();
        }
    }

    @Override
//    TODO - remove the code from here and code it during the session
    public WebDriver getDriver() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    @Override
    public void quit() {
        if (null != driver) {
            driver.quit();
        }
    }
}
