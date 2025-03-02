package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test(description = "Add products to cart and check count label")
    public void addNumberItemsCart() {
        loginSteps.loginAndWaitForPageOpened(USERNAME, PASSWORD);
        productsPage.addProducts(SAUCE_LABS_BACKPACK, SAUCE_LABS_BIKE_LIGHT,
                SAUCE_LABS_BOLT_T_SHIRT);
        String expectedProductsSize = "3";
        Assert.assertEquals(productsPage.getCartProductsCount(), expectedProductsSize);
    }

    @Test(description = "Remove products to cart and check count label")
    public void removeNumberItemsCart() {
        loginSteps.loginAndWaitForPageOpened(USERNAME, PASSWORD);
        productSteps.addProductsAndGoToCart(SAUCE_LABS_FLEECE_JACKET, SAUCE_LABS_ONESIE,
                TEST_ALL_THE_THINGS_T_SHIRT_RED, SAUCE_LABS_BOLT_T_SHIRT);
        cartPage.removeProducts(TEST_ALL_THE_THINGS_T_SHIRT_RED);
        String expectedProductsSize = "3";
        Assert.assertEquals(cartPage.getCartProductsCount(), expectedProductsSize);
    }

    @Test(description = "Check continue shopping button")
    public void checkContinueShoppingButton() {
        loginSteps.loginAndWaitForPageOpened(USERNAME, PASSWORD);
        productsPage.goToCart()
                .clickContinueShoppingButton();
        Assert.assertEquals(driver.getCurrentUrl(), PRODUCTS_PAGE_URL);
    }

    @Test(description = "Check the checkout button")
    public void checkCheckoutButton() {
        loginSteps.loginAndWaitForPageOpened(USERNAME, PASSWORD);
        productsPage.goToCart()
                .clickCheckoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), CHECKOUT_PAGE_URL);
    }

    @Test(description = "Check the logout button")
    public void checkLogoutButton() {
        loginSteps.loginAndWaitForPageOpened(USERNAME, PASSWORD);
        productsPage.goToCart()
                .logOut();
        Assert.assertTrue(loginPage.isLoginButtonDisplayed());
    }
}