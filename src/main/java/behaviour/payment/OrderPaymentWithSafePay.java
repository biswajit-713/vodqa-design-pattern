package behaviour.payment;

import behaviour.payment.OrderPayment;
import org.openqa.selenium.WebDriver;
import page.component.PaymentMethodComponent;

public class OrderPaymentWithSafePay extends OrderPayment {

    private final PaymentMethodComponent paymentMethodComponent;

    public OrderPaymentWithSafePay(WebDriver driver) {
        super(driver);
        paymentMethodComponent = new PaymentMethodComponent(driver);
    }

    @Override
    protected void pay() {
        paymentMethodComponent.getSafePay().click();
        paymentMethodComponent.getSafePayUserName().sendKeys("safepayuser");
        paymentMethodComponent.getSafePayPassword().sendKeys("safepaypassword");
        paymentMethodComponent.getPaynow().click();
    }
}
