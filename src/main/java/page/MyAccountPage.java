package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;

public class MyAccountPage {
    final WebDriver driver;

    By signUpConfirmation = By.xpath("//div[contains(@class,'alert-success')]/span");
    By addNewAddress = By.className("account-page-new-address-link");

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSignupConfirmation() {
        return driver.findElement(signUpConfirmation);
    }

    public WebElement getAddNewAddress() {
        return driver.findElement(addNewAddress);
    }
}
