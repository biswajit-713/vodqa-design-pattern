package page;

import org.openqa.selenium.WebDriver;

public class LandingPage {
    private Navbar navbar;

    public LandingPage(WebDriver driver) {
        this.navbar = new Navbar(driver);
    }

    public Navbar navbar() {
        return this.navbar;
    }

    public boolean isLoaded() {
         return navbar.isLoaded();
    }
}
