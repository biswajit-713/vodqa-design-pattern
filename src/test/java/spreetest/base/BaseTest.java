package spreetest.base;

import drivermanagement.factory.DriverManagerFactory;
import drivermanagement.factory.DriverManagerFactoryImpl;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.BootStrap;
import utilities.Utilities;

public class BaseTest {
    private DriverManagerFactory factory;
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

//        driver = new BootStrap().getDriver();
        factory = new DriverManagerFactoryImpl();
        driver = factory
                    .getManager(Utilities.getProperty("browser"))
                    .getDriver();
        driver.get(Utilities.getProperty("application_url"));

    }

    @AfterMethod
    public void tearDown() {
//        factory.getManager().quit();
        driver.quit();
    }
}
