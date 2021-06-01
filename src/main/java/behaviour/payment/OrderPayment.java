package behaviour.payment;

import org.openqa.selenium.WebDriver;
import page.component.ShippingDetailsPageComponent;

public abstract class OrderPayment {

    private final ShippingDetailsPageComponent shippingDetailsPageComponent;

    public OrderPayment(WebDriver driver) {
        this.shippingDetailsPageComponent = new ShippingDetailsPageComponent(driver);
    }

    private void editShippingDetails() {
        shippingDetailsPageComponent.editShippingDetails().click();
        shippingDetailsPageComponent.city().sendKeys("kansas");
        shippingDetailsPageComponent.next().click();
    }

    protected abstract void pay();

    public void placeOrder() {
        editShippingDetails();
        pay();
    }
}
