package behaviour.checkout;

import behaviour.payment.factory.PaymentModeFactory;
import behaviour.payment.factory.PaymentModeFactoryImpl;
import behaviour.payment.paymenttype.PaymentType;
import org.openqa.selenium.WebDriver;
import page.OrderStatusPage;
import page.checkout.AddressPage;
import page.checkout.ConfirmPage;
import page.checkout.DeliveryPage;
import page.checkout.PaymentPage;

public class Checkout {

    private final AddressPage addressPage;
    private final DeliveryPage deliveryPage;
    private final PaymentPage paymentPage;
    private final ConfirmPage confirmPage;
    private final OrderStatusPage orderStatusPage;

    public Checkout(WebDriver driver) {
        this.addressPage = new AddressPage(driver);
        this.deliveryPage = new DeliveryPage(driver);
        this.paymentPage = new PaymentPage(driver);
        this.confirmPage = new ConfirmPage(driver);
        this.orderStatusPage = new OrderStatusPage(driver);
    }

    public String placeOrderUsing(String paymentMode) {
//        add shipping and billing address
        addressPage.saveAndContinue().click();

//        select the delivery option
        deliveryPage.saveAndContinue().click();

//        select payment mode
        PaymentModeFactory factory = new PaymentModeFactoryImpl();
        PaymentType paymentType = factory.getPaymentType(paymentMode);
        paymentPage.saveAndContinue().click();

//        confirm the order
        confirmPage.placeOrder().click();

//        return success status
        return orderStatusPage.getStatus().getText();
    }
}
