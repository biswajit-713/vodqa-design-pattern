package spreetest.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.BootStrap;
import utilities.Utilities;


public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = BootStrap.getInstance().getDriver(Utilities.getProperty("browser"));
        driver.get(Utilities.getProperty("application_url"));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
