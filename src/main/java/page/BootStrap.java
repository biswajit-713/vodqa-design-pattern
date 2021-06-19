package page;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import singleton.FancyClass;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BootStrap extends FancyClass {
    private static WebDriver driver;
    private static BootStrap bootStrap;

    private BootStrap() {

    }

    public static BootStrap getInstance(){
        if(bootStrap==null)
            bootStrap = new BootStrap();
        return bootStrap;
    }

    @SneakyThrows
    public WebDriver getDriver(String browser) {
        fancyMethod();
        switch (browser){
            case "chrome_docker":
                WebDriverManager.chromedriver().setup();
                ChromeOptions remoteOptions = new ChromeOptions();
                driver = new RemoteWebDriver(new URL("http://localhost:4444"), remoteOptions);
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public String getScreenshot(String testName, WebDriver driver) throws IOException {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "/reports/"+testName+".png"));
        return testName+".png";
    }
}
