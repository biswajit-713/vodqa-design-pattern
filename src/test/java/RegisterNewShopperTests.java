import behaviour.ShopperRegistration;
import com.google.common.util.concurrent.Uninterruptibles;
import entity.Shopper;
import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.LandingPage;
import page.Base;
import utilities.Utilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RegisterNewShopperTests extends Base {
    public WebDriver driver;

    private ShopperRegistration shopperRegistration;
    private LandingPage landingPage;

    @BeforeTest
    public void setDriver() throws IOException {
        this.driver = initialiseDriver();
//        this.driver = DriverFactory.getInstance().getDriver();
//        TODO - move url fetching to common utilities
        this.driver.get("http://advantageonlineshopping.com/#/");
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        landingPage = new LandingPage(this.driver);
        shopperRegistration = new ShopperRegistration(this.driver);
    }

    @Test
    public void registerUserTest() {
        landingPage.isLoaded();
        landingPage.navbar().getAccountIcon().click();

        String name = "john_doe_" + Utilities.getRandomNumber(1000);
        String email = name + "@shopper.com";
        String password = "Passw0rd";
        Shopper shopper = new Shopper(name, email, password);
        shopperRegistration.registerNewShopper(shopper);

        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        Assert.assertEquals(landingPage.navbar().getAccountIcon().getText(), shopper.getName(), "the user name does not match");

    }

    @AfterTest
    public void tearDown() throws IOException {
        this.driver.quit();
    }
}
