package CommonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonWaitsClass {

        WebDriver driver;
        WebDriverWait webdriverwait;
        public CommonWaitsClass(WebDriver driver) {
            this.driver = driver;
            webdriverwait = new WebDriverWait(driver, Duration.ofSeconds(30));}


        public WebElement waitForElementTobeClickable(WebElement element) {
            return webdriverwait.until(ExpectedConditions.elementToBeClickable(element));
        }
    }


