package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.waiters.Waiter;

import java.time.Duration;

public class LoginPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    Waiter waiter = new Waiter();

    @FindBy(xpath = "//*[@data-test='username']")
    WebElement usernameInput;

    @FindBy(xpath = "//*[@data-test='password']")
    WebElement passwordInput;

    @FindBy(id = "login-button")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Login user")
    public ProductsPage login(String username, String password) {
        log.info("Logging in with username: {}, password: {}", username, password);
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new ProductsPage(driver);
    }

    @Step("Wait for login page to open")
    public LoginPage waitForPageToOpen() {
        waiter.waitForElementToLoad(driver, loginButton, Duration.ofSeconds(3));
        return this;
    }

    @Step("Check if login button is displayed")
    public Boolean isLoginButtonDisplayed() {
        waiter.waitForElementToLoad(driver, loginButton, Duration.ofSeconds(10));
        return loginButton.isDisplayed();
    }
}
