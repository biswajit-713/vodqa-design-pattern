package behaviour.usermanagement;

import com.google.common.util.concurrent.Uninterruptibles;
import entity.Shopper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.*;

import java.util.concurrent.TimeUnit;

public class ShopperManagement {

    LoginPage loginPage;
    RegistrationPage registrationPage;
    LandingPage landingPage;
    MyAccountPage myAccountPage;
    ShippingAddressPage shippingAddressPage;

    public ShopperManagement(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
        this.registrationPage = new RegistrationPage(driver);
        this.landingPage = new LandingPage(driver);
        this.myAccountPage = new MyAccountPage(driver);
        this.shippingAddressPage = new ShippingAddressPage(driver);
    }

    public void loginAs(Shopper existingShopper) {

        landingPage.navbar().getAccountIcon().click();
        landingPage.navbar().getLogin().click();

        loginPage.waitUntilLoaded();
        loginPage.getEmail().sendKeys(existingShopper.getEmail());
        loginPage.getPassword().sendKeys(existingShopper.getPassword());
        loginPage.getLogin().click();
    }

    public void  createNewAccountFor(Shopper newShopper) {

        landingPage.navbar().getAccountIcon().click();
        landingPage.navbar().getSignUp().click();

        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        registrationPage.getEmail().sendKeys(newShopper.getEmail());
        registrationPage.getPassword().sendKeys(newShopper.getPassword());
        registrationPage.getConfirmPassword().sendKeys(newShopper.getPassword());
        registrationPage.getSignUp().click();

        myAccountPage.getAddNewAddress().click();

        shippingAddressPage.getFirstName().sendKeys(newShopper.getFirstName());
        shippingAddressPage.getLastName().sendKeys(newShopper.getLastName());
        shippingAddressPage.getAddress().sendKeys(newShopper.getAddress());
        shippingAddressPage.getCity().sendKeys(newShopper.getCity());
        shippingAddressPage.getZipCode().sendKeys(newShopper.getZipCode());
        shippingAddressPage.getPhoneNumber().sendKeys(newShopper.getPhoneNumber());

        if (newShopper.getAddress2() != null) {
            shippingAddressPage.getAddress2().sendKeys(newShopper.getAddress2());
        }

        if (newShopper.getState() != null) {
            shippingAddressPage.getState().selectByVisibleText(newShopper.getState());
        }

        shippingAddressPage.save().click();

    }
}
