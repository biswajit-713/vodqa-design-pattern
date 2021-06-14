package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterUserAndLoginPage extends BootStrap {
    private WebDriver driver;

    By createNewAccount = By.className("create-new-account");
    By loginName = By.name("username");
    By loginPassword = By.name("password");
    By signin = By.id("sign_in_btnundefined");
    By loginModal = By.className("loginPopUpCloseBtn");

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

    @FindBy(name = "first_nameRegisterPage")
    private WebElement firstName;

    @FindBy(name = "last_nameRegisterPage")
    private WebElement lastName;

    @FindBy(name = "phone_numberRegisterPage")
    private WebElement phoneNumber;

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

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getPhoneNumber() {
        return phoneNumber;
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

    public WebElement getLoginName() {
        return driver.findElement(loginName);
    }

    public WebElement getLoginPassword() {
        return driver.findElement(loginPassword);
    }

    public WebElement getSignin() {
        return driver.findElement(signin);
    }

    public WebElement getLoginModal() {
        return driver.findElement(loginModal);
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
