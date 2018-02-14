package util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by equalexperts on 04/02/18.
 */
public class WaitUtility {

    AppiumDriver driver;
    WebDriverWait webDriverWait;

    public WaitUtility(AppiumDriver driver){
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver,10);
    }

    public void waitForElement(MobileElement element) {
//        webDriverWait.until(ExpectedConditions.visibilityOf(usePasswordInsteadLink));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
