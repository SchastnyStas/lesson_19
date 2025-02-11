package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.CartPage.SAUCE_LABS_BOLT_T_SHIRT_REMOVE_BUTTON;
import static pages.ProductsPage.*;

public class ProductsTest extends BaseTest {

    @Test
    public void addNumberItemsCart() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProducts(SAUCE_LABS_BACKPACK_ADD_BUTTON, SAUCE_LABS_ONESIE_ADD_BUTTON, TEST_ALL_THE_THINGS_T_SHIRT_RED_ADD_BUTTON);
        String expectedProductsSize = "3";
        Assert.assertEquals(cartPage.getCartNumber(), expectedProductsSize);
    }

    @Test
    public void removeNumberItemsCart() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProducts(SAUCE_LABS_BIKE_LIGHT_ADD_BUTTON, SAUCE_LABS_BOLT_T_SHIRT_ADD_BUTTON, SAUCE_LABS_FLEECE_JACKET_ADD_BUTTON, TEST_ALL_THE_THINGS_T_SHIRT_RED_ADD_BUTTON);
        productsPage.goToCart();
        cartPage.removeProducts(SAUCE_LABS_BOLT_T_SHIRT_REMOVE_BUTTON);
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