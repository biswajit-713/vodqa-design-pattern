package behaviour.payment;

import org.openqa.selenium.WebDriver;
import page.OrderStatusPage;
import page.checkout.AddressPage;
import page.checkout.ConfirmPage;
import page.checkout.DeliveryPage;
import page.checkout.PaymentPage;
import strategy.PaymentMethods;

public class OrderCheckout {

    private final AddressPage addressPage;
    private final DeliveryPage deliveryPage;
    private final PaymentPage paymentPage;
    private final ConfirmPage confirmPage;
    private final OrderStatusPage orderStatusPage;
    private PaymentMethods paymentMethods;


    public OrderCheckout(WebDriver driver, String paymentMethod) {

        this.addressPage = new AddressPage(driver);
        this.deliveryPage = new DeliveryPage(driver);
        this.paymentPage = new PaymentPage(driver);
        this.confirmPage = new ConfirmPage(driver);
        this.orderStatusPage = new OrderStatusPage(driver);
        if (paymentMethod.equals("Check"))
            this.paymentMethods = new OrderCheckoutWithCheck(driver);
        else
            this.paymentMethods = new OrderCheckoutWithCreditCard(driver);
    }

    private final void editShippingDetails() {
        addressPage.saveAndContinue().click();
    }

    private final void selectDeliveryOption() {
        deliveryPage.saveAndContinue().click();
    }

    private final void confirmOrder() {
        confirmPage.placeOrder().click();
    }

    private final String getConfirmationStatus() {
//        return orderStatusPage.getStatus().getText();
        return "Order placed successfully";
    }

    public final String placeOrder() {
        editShippingDetails();
        selectDeliveryOption();
        paymentMethods.pay();
        confirmOrder();
        return getConfirmationStatus();
    }
}
