package page.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class CreditCardComponent {
    private final WebDriver driver;

    private final By cardNumber = By.name("cardnumber");
    private final By expiry = By.name("exp-date");
    private final By cvc = By.name("cvc");
    private final By frame = By.xpath("//iframe[@title='Secure card payment input frame']");

    public CreditCardComponent(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCreditCardDetails(Map<String, String> cardDetails) {
        driver.switchTo().frame(driver.findElement(frame));

        driver.findElement(cardNumber).click();
        driver.findElement(cardNumber).sendKeys(cardDetails.get("CARD_NUMBER"));

        driver.findElement(expiry).click();
        driver.findElement(expiry).sendKeys(cardDetails.get("EXPIRY_MONTH") + "/" +
                cardDetails.get("EXPIRY_YEAR"));

        driver.findElement(cvc).click();
        driver.findElement(cvc).sendKeys(cardDetails.get("CVC"));

        driver.switchTo().defaultContent();
    }

}
