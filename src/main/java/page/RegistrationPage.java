package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    private final WebDriver driver;

    By email = By.id("spree_user_email");
    By password = By.id("spree_user_password");
    By confirmPassword = By.id("spree_user_password_confirmation");
    By signUp = By.name("commit");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getEmail() {
        return driver.findElement(email);
    }

    public WebElement getPassword() {
        return driver.findElement(password);
    }

    public WebElement getConfirmPassword() {
        return driver.findElement(confirmPassword);
    }

    public WebElement getSignUp() {
        return driver.findElement(signUp);
    }

    public boolean waitUntilLoaded() {
        return new WebDriverWait(this.driver, 10).until(d -> d.findElement(email).isDisplayed());
    }
}
