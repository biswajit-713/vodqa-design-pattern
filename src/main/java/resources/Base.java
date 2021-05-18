package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;
    public static Properties properties;

    public static WebDriver initialiseDriver() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/application_test.properties"));
        switch (properties.getProperty("browser")){
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/resources/chromedriver");
                driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
                break;
            case "chrome_local":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/resources/chromedriver");
                driver = new ChromeDriver();
                break;
            case "firefox":
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
