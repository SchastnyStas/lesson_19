package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class CartPage extends HeaderPage {

    public static final String PRODUCT_ITEM_IN_CART = "//*[text()='%s']/ancestor::*[@class='cart_item_label']";
    public static final String REMOVE_PRODUCT_FROM_CART_BUTTON = PRODUCT_ITEM_IN_CART + "//button[contains(text(),'Remove')]";

    @FindBy(xpath = "//*[@data-test='continue-shopping']")
    WebElement continueShoppingButton;

    @FindBy(xpath = "//*[@data-test='checkout']")
    WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage waitForPageToOpen() {
        waiter.waitForElementToLoad(driver, checkoutButton, Duration.ofSeconds(3));
        return this;
    }

    @Step("Remove products from cart")
    public CartPage removeProducts(String... productNames) {
        for (String productName : productNames) {
            driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName))).click();
        }
        return this;
    }

    @Step("Click continue shopping and go to products page")
    public ProductsPage clickContinueShoppingButton() {
        continueShoppingButton.click();
        return new ProductsPage(driver);
    }

    @Step("Click checkout button")
    public void clickCheckoutButton() {
        checkoutButton.click();
    }
}
