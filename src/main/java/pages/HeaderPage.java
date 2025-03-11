package pages;

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

    public CartPage goToCart() {
        cartClick.click();
        return new CartPage(driver);
    }

    public String getCartProductsCount() {
        waiter.waitForElementToLoad(driver, cartNumber, Duration.ofSeconds(5));
        return cartNumber.getText();
    }

    public LoginPage logOut() {
        menuIcon.click();
        logoutButton.click();
        return new LoginPage(driver);
    }
}

