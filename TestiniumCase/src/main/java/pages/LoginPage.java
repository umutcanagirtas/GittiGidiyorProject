package pages;

import helpers.CustomElementWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='L-UserNameField']")
    private WebElement userName;
    @FindBy(xpath = "//input[@id='L-PasswordField']")
    private WebElement userPassword;
    @FindBy(xpath = "//input[@id='gg-login-enter']")
    private WebElement loginButton;

    public WebElement getUserName() {
        CustomElementWaits.waitUntilElementToClickable(driver, userName);
        return userName;
    }

    public void setUserName(WebElement userName) {
        this.userName = userName;
    }

    public WebElement getUserPassword() {
        CustomElementWaits.waitUntilElementToClickable(driver, userPassword);
        return userPassword;
    }

    public void setUserPassword(WebElement userPassword) {
        this.userPassword = userPassword;
    }

    public WebElement getLoginButton() {
        CustomElementWaits.waitUntilElementToClickable(driver, loginButton);
        return loginButton;
    }

    public void setLoginButton(WebElement loginButton) {
        this.loginButton = loginButton;
    }

    public void userNameField(String name) {
        getUserName().sendKeys(name);
    }

    public void userPasswordField(String password) {
        getUserPassword().sendKeys(password);
    }

    public void login() {
        getLoginButton().click();
    }


}
