package behaviour.usermanagement;

import org.openqa.selenium.WebDriver;
import page.MyAccountPage;

public class MyAccount {
    private final MyAccountPage myAccountPage;

    public MyAccount(WebDriver driver) {
        myAccountPage = new MyAccountPage(driver);
    }

    public String getSignupMessage() {
        return myAccountPage.getSignupConfirmation().getText();
    }
}
