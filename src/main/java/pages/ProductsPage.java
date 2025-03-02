package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends HeaderPage {

    public static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class='inventory_item']";
    public static final String ADD_PRODUCT_TO_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(),'Add')]";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Add products to cart")
    public ProductsPage addProducts(String... productNames) {
        for (String productName : productNames) {
            driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
        }
        return this;
    }
}

