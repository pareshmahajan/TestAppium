package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pagefactory.ImmediatePageObjects;
import util.WaitUtility;

import java.util.concurrent.TimeUnit;

/**
 * Created by Paresh on 04/02/18.
 */
public class ImmediateScreen extends WaitUtility {

    AppiumDriver driver;
    ImmediatePageObjects immediatePageObjects;

    public ImmediateScreen(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
        immediatePageObjects = new ImmediatePageObjects();
        PageFactory.initElements(new
                        AppiumFieldDecorator(driver,15, TimeUnit.SECONDS),
                immediatePageObjects);
    }

    public LoginPage clickUsePasswordInsteadLink() {
        waitForElement(immediatePageObjects.usePasswordInsteadLink);
        immediatePageObjects.usePasswordInsteadLink.click();

        return new LoginPage(driver);
    }
}
