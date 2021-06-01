package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    final WebDriver driver;

    By email = By.id("spree_user_email");
    By password = By.id("spree_user_password");
    By login = By.name("commit");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getEmail() {
        return driver.findElement(email);
    }

    public WebElement getPassword() {
        return driver.findElement(password);
    }

    public WebElement getLogin() {
        return driver.findElement(login);
    }

    public boolean waitUntilLoaded() {
        return new WebDriverWait(driver, 10).until(d -> d.findElement(email).isDisplayed());
    }
}
