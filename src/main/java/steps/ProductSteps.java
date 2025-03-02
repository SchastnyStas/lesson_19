package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.ProductsPage;

public class ProductSteps {
    private ProductsPage productsPage;

    public ProductSteps(WebDriver driver) {
        productsPage = new ProductsPage(driver);
    }

    @Step("Add products and go to cart")
    public ProductSteps addProductsAndGoToCart(String... productNames) {
        productsPage.addProducts(productNames)
                .goToCart()
                .waitForPageToOpen();
        return this;
    }
}
