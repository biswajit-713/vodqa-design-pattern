package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShippingAddressPage {
    private final WebDriver driver;

    private By firstName = By.id("address_firstname");
    private By lastName = By.id("address_lastname");
    private By address = By.id("address_address1");
    private By address2 = By.id("address_address2");
    private By city = By.id("address_city");
    private By zipCode = By.id("address_zipcode");
    private By phoneNumber = By.id("address_phone");
    private By state = By.id("address_state_id");

    private By save = By.name("commit");

    public ShippingAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFirstName() {
        return driver.findElement(firstName);
    }

    public WebElement getLastName() {
        return driver.findElement(lastName);
    }

    public WebElement getAddress() {
        return driver.findElement(address);
    }

    public WebElement getCity() {
        return driver.findElement(city);
    }

    public WebElement getZipCode() {
        return driver.findElement(zipCode);
    }

    public WebElement getPhoneNumber() {
        return driver.findElement(phoneNumber);
    }

    public WebElement save() {
        return driver.findElement(save);
    }

    public WebElement getAddress2() {
        return driver.findElement(address2);
    }

    public Select getState() {
        return new Select(driver.findElement(state));
    }
}
