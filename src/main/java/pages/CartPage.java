package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends HeaderPage {
    public static final By SAUCE_LABS_BOLT_T_SHIRT_REMOVE_BUTTON = By.xpath("//*[@data-test='remove-sauce-labs-bolt-t-shirt']");
    public static final By CONTINUE_SHOPPING_BUTTON = By.xpath("//*[@data-test='continue-shopping']");
    public static final By CHECKOUT_BUTTON = By.xpath("//*[@data-test='checkout']");
    public static final By CART_NUMBER = By.xpath("//*[@data-test='shopping-cart-badge']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getCartNumber() {
        return driver.findElement(CART_NUMBER).getText();
    }

    public void removeProducts(By... productLocators) {
        for (By locator : productLocators) {
            driver.findElement(locator).click();
        }
    }

    public void clickContinueShoppingButton() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    public void clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}