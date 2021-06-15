package behaviour.payment;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import page.checkout.PaymentPage;
import page.component.CreditCardComponent;
import strategy.PaymentMethods;

import java.util.HashMap;
import java.util.Map;

public class OrderCheckoutWithCreditCard extends OrderCheckout implements PaymentMethods {

    private final PaymentPage paymentPage;
    private final CreditCardComponent creditCardComponent;

    public OrderCheckoutWithCreditCard(WebDriver driver) {
        super(driver);
        paymentPage = new PaymentPage(driver);
        creditCardComponent = new CreditCardComponent(driver);
    }

    @Override
    public void pay() {
        paymentPage.getCreditCard().click();

        try {
            paymentPage.addNewCard().click();
        } catch (NoSuchElementException ignored) {

        }

        paymentPage.name().clear();
        paymentPage.name().sendKeys("spree user");

        Map<String, String> creditCard = new HashMap<>();
        creditCard.put("CARD_NUMBER", "4111111111111111");
        creditCard.put("CVC", "999");
        creditCard.put("EXPIRY_MONTH", "12");
        creditCard.put("EXPIRY_YEAR", "30");
        creditCardComponent.enterCreditCardDetails(creditCard);

        paymentPage.saveAndContinue().click();
    }
}
