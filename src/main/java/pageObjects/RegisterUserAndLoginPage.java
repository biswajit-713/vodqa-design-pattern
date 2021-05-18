package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.Base;

public class RegisterUserAndLoginPage extends Base {
    private WebDriver driver;

    public RegisterUserAndLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#spree_user_email")
    private WebElement email;

    @FindBy(css = "#spree_user_password")
    private WebElement password;

    @FindBy(css = "#spree_user_password_confirmation")
    private WebElement confirmPassword;

    @FindBy(name = "commit")
    private WebElement signUp;

    @FindBy(name = "commit")
    private WebElement login;

    public WebElement getEmail(){
        return email;
    }

    public WebElement getPassword(){
        return password;
    }

    public WebElement getConfirmPassword(){
        return confirmPassword;
    }

    public WebElement getSignUp(){
        return signUp;
    }

    public WebElement getLogin() {
        return login;
    }
}
