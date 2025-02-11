package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends HeaderPage {
    public static final By SAUCE_LABS_BACKPACK_ADD_BUTTON = By.xpath("//*[@data-test='add-to-cart-sauce-labs-backpack']");
    public static final By SAUCE_LABS_BIKE_LIGHT_ADD_BUTTON = By.xpath("//*[@data-test='add-to-cart-sauce-labs-bike-light']");
    public static final By SAUCE_LABS_BOLT_T_SHIRT_ADD_BUTTON = By.xpath("//*[@data-test='add-to-cart-sauce-labs-bolt-t-shirt']");
    public static final By SAUCE_LABS_FLEECE_JACKET_ADD_BUTTON = By.xpath("//*[@data-test='add-to-cart-sauce-labs-fleece-jacket']");
    public static final By SAUCE_LABS_ONESIE_ADD_BUTTON = By.xpath("//*[@data-test='add-to-cart-sauce-labs-onesie']");
    public static final By TEST_ALL_THE_THINGS_T_SHIRT_RED_ADD_BUTTON = By.xpath("//*[@data-test='add-to-cart-test.allthethings()-t-shirt-(red)']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addProducts(By... productLocators) {
        for (By locator : productLocators) {
            driver.findElement(locator).click();
        }
    }
}
