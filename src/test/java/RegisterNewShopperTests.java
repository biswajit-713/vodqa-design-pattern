import behaviour.usermanagement.MyAccount;
import behaviour.usermanagement.ShopperManagement;
import behaviour.usermanagement.ShopperRegistration;
import com.google.common.util.concurrent.Uninterruptibles;
import entity.Shopper;
import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.Base;
import utilities.Utilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RegisterNewShopperTests extends Base {
    WebDriver driver;

    private ShopperManagement shopperManagement;
    private MyAccount myAccount;

    @BeforeTest
    public void setUp() throws IOException {
//        this.driver = initialiseDriver();
        this.driver = DriverFactory.getInstance().getDriver();

//        TODO - move url fetching to common utilities
        this.driver.get("https://demo.spreecommerce.org/");
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        shopperManagement = new ShopperManagement(this.driver);
        myAccount = new MyAccount(this.driver);
    }

    @Test
    public void registerUserOnlyWithMandatoryAddressFieldsTest() {

        String name = "john_doe_" + Utilities.getRandomNumber(1000);
        String email = name + "@shopper.com";
        String password = "Passw0rd";
        Shopper newShopper = new Shopper.ShopperBuilder(email, password)
                .firstName("john")
                .lastName("doe")
                .phoneNumber("2013520000")
                .address("160 Balfour Road")
                .city("Akiachak")
                .zipCode("99551")
                .build();

        shopperManagement.createNewAccountFor(newShopper);
        Assert.assertEquals(myAccount.getSignupMessage(), "New address has been successfully created",
                "failed to signup");
    }

    @Test
    public void registerUserWithAllAddressFieldsTest() {

        String name = "john_doe_" + Utilities.getRandomNumber(1000);
        String email = name + "@shopper.com";
        String password = "Passw0rd";
        Shopper newShopper = new Shopper.ShopperBuilder(email, password)
                .firstName("john")
                .lastName("doe")
                .phoneNumber("2013520000")
                .address("160 balfour road")
                .address2("montana garden")
                .city("orlando")
                .state("Florida")
                .zipCode("30052")
                .build();
        shopperManagement.createNewAccountFor(newShopper);
        Assert.assertEquals(myAccount.getSignupMessage(), "New address has been successfully created",
                "failed to signup");

    }

    @AfterTest
    public void tearDown() throws IOException {
        this.driver.quit();
    }
}
