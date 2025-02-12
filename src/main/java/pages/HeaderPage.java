package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {
    public static final By CART_CLICK = By.xpath("//*[@data-test='shopping-cart-link']");
    public static final By MENU_ICON = By.id("react-burger-menu-btn");
    public static final By LOGOUT_BUTTON = By.xpath("//*[@data-test='logout-sidebar-link']");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public void goToCart() {
        driver.findElement(CART_CLICK).click();
    }

    public void logOut() {
        driver.findElement(MENU_ICON).click();
        driver.findElement(LOGOUT_BUTTON).click();
    }
}

