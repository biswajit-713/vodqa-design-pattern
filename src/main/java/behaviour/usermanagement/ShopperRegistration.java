package behaviour.usermanagement;

import entity.Shopper;
import org.openqa.selenium.WebDriver;
import page.RegisterUserAndLoginPage;

public class ShopperRegistration {

    private RegisterUserAndLoginPage registerUserAndLoginPage;

    public ShopperRegistration(WebDriver driver) {
        registerUserAndLoginPage = new RegisterUserAndLoginPage(driver);
    }

    public void registerNewShopper(Shopper newShopper) {
        registerUserAndLoginPage.waitUntilPageLoads().getCreateAccount().click();

        registerUserAndLoginPage.getEmail().sendKeys(newShopper.getEmail());
        registerUserAndLoginPage.getPassword().sendKeys(newShopper.getPassword());
        registerUserAndLoginPage.getConfirmPassword().sendKeys(newShopper.getPassword());

        if (newShopper.getFirstName() != null) {
            registerUserAndLoginPage.getFirstName().sendKeys(newShopper.getFirstName());
        }

        if (newShopper.getLastName() != null) {
            registerUserAndLoginPage.getLastName().sendKeys(newShopper.getLastName());
        }

        if (newShopper.getPhoneNumber() != null) {
            registerUserAndLoginPage.getPhoneNumber().sendKeys(newShopper.getPhoneNumber());
        }

        registerUserAndLoginPage.getPrivacyNotice().click();
        registerUserAndLoginPage.getSignUp().click();

    }

    public boolean loginAs(Shopper existingShopper) {
        registerUserAndLoginPage.getLoginName().sendKeys(existingShopper.getEmail());
        registerUserAndLoginPage.getLoginPassword().sendKeys(existingShopper.getPassword());
        registerUserAndLoginPage.getSignin().click();
        return registerUserAndLoginPage.getLoginModal().isDisplayed();
    }
}
