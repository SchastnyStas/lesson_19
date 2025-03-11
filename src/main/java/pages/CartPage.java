package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

@Slf4j
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

    public CartPage removeProducts(String... productNames) {
        log.info("Remove {} products from cart", productNames);
        for (String productName : productNames) {
            driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName))).click();
        }
        return this;
    }

    public ProductsPage clickContinueShoppingButton() {
        continueShoppingButton.click();
        return new ProductsPage(driver);
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }
}
