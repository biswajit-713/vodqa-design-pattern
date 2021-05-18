import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.Navbar;
import pageObjects.RegisterUserAndLoginPage;
import resources.Base;
import resources.DockerOperation;
import resources.Utilities;

import java.io.IOException;

public class FailExampleTest extends Base {
    public WebDriver driver;
    private Navbar navbar;
    private RegisterUserAndLoginPage registerUserAndLoginPage;
    private static Logger log = LogManager.getLogger(FailExampleTest.class.getName());

    @BeforeTest
    public void setDriver() throws IOException, InterruptedException {
        this.driver = initialiseDriver();
        log.info("Driver initialised successfully");
        this.driver.get(properties.getProperty("base_url"));
        log.info("Successfully navigated to "+ properties.getProperty("base_url"));
        navbar = new Navbar(driver);
        registerUserAndLoginPage = new RegisterUserAndLoginPage(driver);
    }

    @Test (groups = {"fail"})
    public void failExampleScreenshotTest(){
        navbar.getAccountIcon().click();
        log.info("Clicked on account icon");
        navbar.getLogin().click();
        log.info("Clicked on Log In link");

        registerUserAndLoginPage.getEmail().sendKeys("test2@valid.com");
        log.info("Email address has been entered");
        registerUserAndLoginPage.getPassword().sendKeys("password");
        log.info("Password has been entered");
        registerUserAndLoginPage.getLogin().click();
        log.info("Log in button has been clicked");

        Assert.assertTrue(Utilities.getSuccessAlert().getText().contains("Logged in successfully"));
        navbar.getAccountIcon().click();
        Assert.assertTrue(navbar.getLogout().isDisplayed());
        log.error("Error is displayed");
    }

    @AfterTest
    public void tearDown() throws IOException, InterruptedException {
        this.driver.close();
        log.info("Driver is closed");
    }
}
