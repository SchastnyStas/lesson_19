package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pages.ProductsPage.PRODUCT_ITEM;

public class CartPage extends HeaderPage {
    public static final String PRODUCT_ITEM_IN_CART = "//*[text()='%s']/ancestor::*[@class='cart_item_label']";
    public static final String REMOVE_PRODUCT_FROM_CART_BUTTON = PRODUCT_ITEM_IN_CART + "//button[contains(text(),'Remove')]";
    public static final By CONTINUE_SHOPPING_BUTTON = By.xpath("//*[@data-test='continue-shopping']");
    public static final By CHECKOUT_BUTTON = By.xpath("//*[@data-test='checkout']");
    public static final By CART_NUMBER = By.xpath("//*[@data-test='shopping-cart-badge']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getCartNumber() {
        return driver.findElement(CART_NUMBER).getText();
    }

    public void removeProducts(String... productNames) {
        for (String productName : productNames) {
            driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName))).click();
        }
    }

    public void clickContinueShoppingButton() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    public void clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}
