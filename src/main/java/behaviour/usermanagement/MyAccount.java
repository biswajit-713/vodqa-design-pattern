package behaviour.usermanagement;

import org.openqa.selenium.WebDriver;
import page.MyAccountPage;

public class MyAccount {
    final WebDriver driver;
    final MyAccountPage myAccountPage;

    public MyAccount(WebDriver driver) {
        this.driver = driver;
        myAccountPage = new MyAccountPage(driver);
    }

    public String getSignupMessage() {
        return myAccountPage.getSignupConfirmation().getText();
    }
}
