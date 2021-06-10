package page.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage {
    private final WebDriver driver;

    private final By saveAndContinue = By.className("checkout-content-save-continue-button");
    private final By check = By.xpath("//input[@id='order_payments_attributes__payment_method_id_2']/following-sibling::span");
    private final By creditCard = By.xpath("//input[@id='order_payments_attributes__payment_method_id_4']/following-sibling::span");
    private final By addNewCard = By.xpath("//input[@id='use_existing_card_no']/following-sibling::span");

    private final By name = By.id("name_on_card_4");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement saveAndContinue() {
        return driver.findElement(saveAndContinue);
    }

    public WebElement getCheck() {
        return driver.findElement(check);
    }

    public WebElement getCreditCard() {
        return driver.findElement(creditCard);
    }

    public WebElement addNewCard() {
        return driver.findElement(addNewCard);
    }

    public WebElement name() {
        return driver.findElement(name);
    }
}
