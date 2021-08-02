package behaviour.factory;

import behaviour.payment.OrderCheckoutWithCheck;
import behaviour.payment.OrderCheckoutWithCreditCard;
import behaviour.strategy.IPayments;
import org.openqa.selenium.WebDriver;

public class PaymentFactory {
    private WebDriver driver;
    public PaymentFactory(WebDriver driver){
        this.driver = driver;
    }

    public IPayments getPaymentMethod( String paymentMethod){
        if(paymentMethod.equals("Check")){
            return (IPayments) new OrderCheckoutWithCheck(driver);
        } else {
            return (IPayments) new OrderCheckoutWithCreditCard(driver);
        }
    }
}
