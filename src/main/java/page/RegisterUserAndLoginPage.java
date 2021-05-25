package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterUserAndLoginPage extends Base {
    private WebDriver driver;

    By createNewAccount = By.className("create-new-account");

    public RegisterUserAndLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "create-new-account")
    private WebElement createAccount;

    @FindBy(name = "usernameRegisterPage")
    private WebElement username;

    @FindBy(name = "emailRegisterPage")
    private WebElement email;

    @FindBy(name = "passwordRegisterPage")
    private WebElement password;

    @FindBy(name = "confirm_passwordRegisterPage")
    private WebElement confirmPassword;

    @FindBy(name = "i_agree")
    private WebElement privacyNotice;

    @FindBy(id = "register_btnundefined")
    private WebElement signUp;

    @FindBy(name = "commit")
    private WebElement login;

    public WebElement getCreateAccount() {
        return createAccount;
    }

    public WebElement getUsername() {
        return username;
    }

    public WebElement getEmail(){
        return email;
    }

    public WebElement getPassword(){
        return password;
    }

    public WebElement getConfirmPassword(){
        return confirmPassword;
    }

    public WebElement getPrivacyNotice() {
        Actions action = new Actions(driver);
        action.moveToElement(privacyNotice).perform();
        return privacyNotice;
    }

    public WebElement getSignUp(){
        return signUp;
    }

    public WebElement getLogin() {
        return login;
    }

    public RegisterUserAndLoginPage waitUntilPageLoads() {
        boolean isPageLoaded = new WebDriverWait(driver, 30).until(d -> d.findElement(createNewAccount).isDisplayed());

        if (isPageLoaded) {
            return this;
        } else {
            throw new NoSuchElementException("Login dialog is not loaded");
        }
    }
}
