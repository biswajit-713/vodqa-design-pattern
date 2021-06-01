package behaviour.payment;

import org.openqa.selenium.WebDriver;
import page.component.PaymentMethodComponent;

public class OrderPaymentWithCreditCard extends OrderPayment{
    private PaymentMethodComponent paymentMethodComponent;

    public OrderPaymentWithCreditCard(WebDriver driver) {
        super(driver);
        paymentMethodComponent = new PaymentMethodComponent(driver);
    }

    @Override
    protected void pay() {
        paymentMethodComponent.getMasterCredit().click();
        paymentMethodComponent.getCardNumber().sendKeys("4111111111111111");
        paymentMethodComponent.getCvvNumber().sendKeys("123");
        paymentMethodComponent.getCardHolderName().sendKeys("democardholder");
        paymentMethodComponent.getPaynow().click();
    }
}
