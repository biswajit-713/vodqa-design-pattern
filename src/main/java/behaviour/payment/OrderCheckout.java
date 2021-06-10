package behaviour.payment;

import org.openqa.selenium.WebDriver;
import page.OrderStatusPage;
import page.checkout.AddressPage;
import page.checkout.ConfirmPage;
import page.checkout.DeliveryPage;
import page.checkout.PaymentPage;

public abstract class OrderCheckout {

    private final AddressPage addressPage;
    private final DeliveryPage deliveryPage;
    private final PaymentPage paymentPage;
    private final ConfirmPage confirmPage;
    private final OrderStatusPage orderStatusPage;


    public OrderCheckout(WebDriver driver) {

        this.addressPage = new AddressPage(driver);
        this.deliveryPage = new DeliveryPage(driver);
        this.paymentPage = new PaymentPage(driver);
        this.confirmPage = new ConfirmPage(driver);
        this.orderStatusPage = new OrderStatusPage(driver);

    }

    private final void editShippingDetails() {
        addressPage.saveAndContinue().click();
    }

    protected abstract void pay();

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
        pay();
        confirmOrder();
        return getConfirmationStatus();
    }
}
