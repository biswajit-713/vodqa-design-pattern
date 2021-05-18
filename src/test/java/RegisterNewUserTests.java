import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.Navbar;
import pageObjects.RegisterUserAndLoginPage;
import resources.Base;
import resources.DockerOperation;
import resources.Utilities;

import java.io.IOException;

public class RegisterNewUserTests extends Base {
    public WebDriver driver;
    private Navbar navbar;
    private RegisterUserAndLoginPage registerUserAndLoginPage;

    @BeforeTest
    public void setDriver() throws IOException {
        this.driver = initialiseDriver();
        driver.get(properties.getProperty("base_url"));
        navbar = new Navbar(driver);
        registerUserAndLoginPage = new RegisterUserAndLoginPage(driver);
    }

    @Test
    public void registerUserTest() {
        navbar.getAccountIcon().click();
        navbar.getSignUp().click();

        registerUserAndLoginPage.getEmail().sendKeys("test_" + Utilities.randomNumber(100) + "@valid.com");
        registerUserAndLoginPage.getPassword().sendKeys("<some_text>");
        registerUserAndLoginPage.getConfirmPassword().sendKeys("<some_text>");
        registerUserAndLoginPage.getSignUp().click();

        Assert.assertTrue(Utilities.getSuccessAlert().getText().contains("Welcome! You have signed up successfully."));
        navbar.getAccountIcon().click();
        Assert.assertTrue(navbar.getLogout().isDisplayed());
    }

    @AfterTest
    public void tearDown() throws IOException {
        this.driver.close();
    }
}
