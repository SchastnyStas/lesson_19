package steps;

import constants.IConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {
    private LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("Login with user credentials")
    public LoginSteps loginAndWaitForPageOpened(String username, String password) {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage
                .waitForPageToOpen()
                .login(username, password);
        return this;
    }
}
