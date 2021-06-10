package page;

import exception.SpreeTestException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.component.Navbar;
import page.component.OurProducts;

import java.util.Optional;

public class LandingPage {
    private Navbar navbar;
    private OurProducts ourProducts;

    public LandingPage(WebDriver driver) {
        this.navbar = new Navbar(driver);
    }

    public Navbar navbar() {
        return this.navbar;
    }

    public boolean isLoaded() {
         return navbar.isLoaded();
    }

    public void select(String item) {
        Optional<WebElement> match = ourProducts.getOurProducts().stream()
                .filter(ourProduct -> ourProduct.getText().equalsIgnoreCase(item))
                .findFirst();

        if (!match.isPresent()) {
            throw new SpreeTestException(item + " is not found");
        }
        match.get().click();
    }
}
