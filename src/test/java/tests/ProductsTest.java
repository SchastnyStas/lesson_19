package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
    public void addNumberItemsCart() {
        loginPage.login(USERNAME, PASSWORD)
                .addProducts(SAUCE_LABS_BACKPACK, SAUCE_LABS_BIKE_LIGHT, SAUCE_LABS_BOLT_T_SHIRT);
        String expectedProductsSize = "3";
        Assert.assertEquals(productsPage.getCartProductsCount(), expectedProductsSize);
    }

    @Test
    public void removeNumberItemsCart() {
        loginPage.login(USERNAME, PASSWORD)
                .addProducts(SAUCE_LABS_FLEECE_JACKET, SAUCE_LABS_ONESIE, TEST_ALL_THE_THINGS_T_SHIRT_RED, SAUCE_LABS_BOLT_T_SHIRT)
                .goToCart()
                .removeProducts(TEST_ALL_THE_THINGS_T_SHIRT_RED);
        String expectedProductsSize = "3";
        Assert.assertEquals(cartPage.getCartProductsCount(), expectedProductsSize);
    }

    @Test
    public void checkContinueShoppingButton() {
        loginPage.login(USERNAME, PASSWORD)
                .goToCart()
                .clickContinueShoppingButton();
        Assert.assertEquals(driver.getCurrentUrl(), PRODUCTS_PAGE_URL);
    }

    @Test
    public void checkCheckoutButton() {
        loginPage.login(USERNAME, PASSWORD)
                .goToCart()
                .clickCheckoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), CHECKOUT_PAGE_URL);
    }

    @Test
    public void checkLogoutButton() {
        loginPage.login(USERNAME, PASSWORD)
                .goToCart()
                .logOut();
        Assert.assertTrue(loginPage.isLoginButtonDisplayed());
    }
}