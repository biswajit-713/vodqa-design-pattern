package behaviour;

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

        registerUserAndLoginPage.getUsername().sendKeys(newShopper.getName());
        registerUserAndLoginPage.getEmail().sendKeys(newShopper.getEmail());
        registerUserAndLoginPage.getPassword().sendKeys(newShopper.getPassword());
        registerUserAndLoginPage.getConfirmPassword().sendKeys(newShopper.getPassword());
        registerUserAndLoginPage.getPrivacyNotice().click();
        registerUserAndLoginPage.getSignUp().click();

    }
}
