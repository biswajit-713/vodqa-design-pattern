import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.Navbar;
import pageObjects.RegisterUserAndLoginPage;
import resources.Base;
import resources.DockerOperation;
import resources.Utilities;

import java.io.IOException;

public class LoginTests extends Base {
    public WebDriver driver;
    private Navbar navbar;
    private RegisterUserAndLoginPage registerUserAndLoginPage;

    @BeforeTest
    public void setDriver() throws IOException {
        this.driver = initialiseDriver();
        this.driver.get(properties.getProperty("base_url"));
        navbar = new Navbar(driver);
        registerUserAndLoginPage = new RegisterUserAndLoginPage(driver);
    }

    @Test (dataProvider = "getValidUserData")
    public void validUserLoginTest(String username, String password){
        navbar.getAccountIcon().click();
        navbar.getLogin().click();

        registerUserAndLoginPage.getEmail().sendKeys(username);
        registerUserAndLoginPage.getPassword().sendKeys(password);
        registerUserAndLoginPage.getLogin().click();

        Assert.assertTrue(Utilities.getSuccessAlert().getText().contains("Logged in successfully"));
        navbar.getAccountIcon().click();
        Assert.assertTrue(navbar.getLogout().isDisplayed());
    }

    @Test (dataProvider = "getInvalidUserData")
    public void invalidUserLoginTest(String username, String password){
        navbar.getAccountIcon().click();
        navbar.getLogin().click();

        registerUserAndLoginPage.getEmail().sendKeys(username);
        registerUserAndLoginPage.getPassword().sendKeys(password);
        registerUserAndLoginPage.getLogin().click();

        Assert.assertTrue(Utilities.getErrorAlert().getText().contains("Invalid email or password."));
    }

    @AfterTest
    public void tearDown() {
        this.driver.close();
    }

    @DataProvider
    public Object[][] getValidUserData(){
        Object[][] data = new Object[1][2];
        data[0][0] = System.getenv("USERNAME");
        data[0][1] = System.getenv("PASSWORD");
        return data;
    }

    @DataProvider
    public Object[][] getInvalidUserData(){
        Object[][] data = new Object[1][2];
        data[0][0] = "test@invalid.com";
        data[0][1] = "<some_text>";
        return data;
    }
}
