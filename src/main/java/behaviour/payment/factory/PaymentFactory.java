package behaviour.payment.factory;

import behaviour.payment.OrderCheckoutWithCheck;
import behaviour.payment.OrderCheckoutWithCreditCard;
import behaviour.payment.strategy.PaymentMethods;
import org.openqa.selenium.WebDriver;

public class PaymentFactory {
    private WebDriver driver;

    public PaymentFactory(WebDriver driver) {
        this.driver = driver;
    }

    public PaymentMethods getPaymentMethod(String paymentMethod){
        if (paymentMethod.equals("Check"))
            return new OrderCheckoutWithCheck(driver);
        if (paymentMethod.equals("CreditCard"))
            return new OrderCheckoutWithCreditCard(driver);
        return null;
    }
}
