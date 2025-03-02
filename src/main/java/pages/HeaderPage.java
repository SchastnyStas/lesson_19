package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.waiters.Waiter;

import java.time.Duration;

public class HeaderPage extends BasePage {

    Waiter waiter = new Waiter();

    @FindBy(xpath = "//*[@data-test='shopping-cart-link']")
    WebElement cartClick;

    @FindBy(id = "react-burger-menu-btn")
    WebElement menuIcon;

    @FindBy(xpath = "//*[@data-test='logout-sidebar-link']")
    WebElement logoutButton;

    @FindBy(xpath = "//*[@data-test='shopping-cart-badge']")
    WebElement cartNumber;

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @Step("Go to cart")
    public CartPage goToCart() {
        cartClick.click();
        return new CartPage(driver);
    }

    @Step("Get products count")
    public String getCartProductsCount() {
        waiter.waitForElementToLoad(driver, cartNumber, Duration.ofSeconds(5));
        return cartNumber.getText();
    }

    @Step("Log out")
    public LoginPage logOut() {
        menuIcon.click();
        logoutButton.click();
        return new LoginPage(driver);
    }
}

