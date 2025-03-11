package pages;

import constants.IConstants;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public abstract class BasePage implements IConstants {

    WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void openPage(String url) {
        log.info("Open Page URL {}", url);
        driver.get(url);
    }
}
