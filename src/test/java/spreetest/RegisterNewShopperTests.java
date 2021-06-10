package spreetest;

import behaviour.usermanagement.MyAccount;
import behaviour.usermanagement.ShopperManagement;
import entity.Shopper;
import org.testng.Assert;
import org.testng.annotations.*;
import spreetest.base.BaseTest;
import utilities.Utilities;

public class RegisterNewShopperTests extends BaseTest {
    private ShopperManagement shopperManagement;
    private MyAccount myAccount;

    @Test
    public void registerUserOnlyWithMandatoryAddressFieldsTest() {

        String name = "john_doe_" + Utilities.getRandomNumber(1000);
        String email = name + "@shopper.com";
        String password = "Passw0rd";
        Shopper newShopper = new Shopper.builder(email, password)
                .firstName("john")
                .lastName("doe")
                .phoneNumber("2013520000")
                .address("160 Balfour Road")
                .city("Akiachak")
                .zipCode("99551")
                .build();

        shopperManagement = new ShopperManagement(driver);
        myAccount = new MyAccount(driver);

        shopperManagement.createNewAccountFor(newShopper);
        Assert.assertEquals(myAccount.getSignupMessage(), "New address has been successfully created",
                "failed to signup");
    }

    @Test
    public void registerUserWithAllAddressFieldsTest() {

        String name = "john_doe_" + Utilities.getRandomNumber(1000);
        String email = name + "@shopper.com";
        String password = "Passw0rd";
        Shopper newShopper = new Shopper.builder(email, password)
                .firstName("john")
                .lastName("doe")
                .phoneNumber("2013520000")
                .address("160 balfour road")
                .address2("montana garden")
                .city("orlando")
                .state("Florida")
                .zipCode("30052")
                .build();

        shopperManagement = new ShopperManagement(driver);
        myAccount = new MyAccount(driver);

        shopperManagement.createNewAccountFor(newShopper);
        Assert.assertEquals(myAccount.getSignupMessage(), "New address has been successfully created",
                "failed to signup");

    }
}
