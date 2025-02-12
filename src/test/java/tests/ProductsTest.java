package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ProductsTest extends BaseTest {

    @Test
    public void addNumberItemsCart() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProducts(SAUCE_LABS_BACKPACK, SAUCE_LABS_BIKE_LIGHT, SAUCE_LABS_BOLT_T_SHIRT);
        String expectedProductsSize = "3";
        Assert.assertEquals(cartPage.getCartNumber(), expectedProductsSize);
    }

    @Test
    public void removeNumberItemsCart() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProducts(SAUCE_LABS_FLEECE_JACKET, SAUCE_LABS_ONESIE, TEST_ALL_THE_THINGS_T_SHIRT_RED, SAUCE_LABS_BOLT_T_SHIRT);
        productsPage.goToCart();
        cartPage.removeProducts(TEST_ALL_THE_THINGS_T_SHIRT_RED);
        String expectedProductsSize = "3";
        Assert.assertEquals(cartPage.getCartNumber(), expectedProductsSize);
    }

    @Test
    public void checkContinueShoppingButton() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.goToCart();
        cartPage.clickContinueShoppingButton();
        Assert.assertEquals(driver.getCurrentUrl(), PRODUCTS_PAGE_URL);
    }

    @Test
    public void checkCheckoutButton() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.goToCart();
        cartPage.clickCheckoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), CHECKOUT_PAGE_URL);
    }

    @Test
    public void checkLogoutButton() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.goToCart();
        cartPage.logOut();
        Assert.assertTrue(loginPage.isLoginButtonDisplayed());
    }
}