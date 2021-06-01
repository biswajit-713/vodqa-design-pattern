package page.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentMethodComponent {
    WebDriver driver;

    By safePay = By.name("safepay");
    By masterCredit = By.name("masterCredit");

    By safePayUserName = By.name("safepay_username");
    By safePayPassword = By.name("safepay_password");

    By cardNumber = By.name("creditCard");
    By cvvNumber = By.name("cvv_number");
    By cardHolderName = By.name("cardholder_name");

    By paynow = By.id("pay_now_btn_SAFEPAY");

    public PaymentMethodComponent(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSafePay() {
        return driver.findElement(safePay);
    }

    public WebElement getMasterCredit() {
        return driver.findElement(masterCredit);
    }

    public WebElement getSafePayUserName() {
        return driver.findElement(safePayUserName);
    }

    public WebElement getSafePayPassword() {
        return driver.findElement(safePayPassword);
    }

    public WebElement getCardNumber() {
        return driver.findElement(cardNumber);
    }

    public WebElement getCvvNumber() {
        return driver.findElement(cvvNumber);
    }

    public WebElement getCardHolderName() {
        return driver.findElement(cardHolderName);
    }

    public WebElement getPaynow() {
        return driver.findElement(paynow);
    }
}
