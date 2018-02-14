package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pagefactory.WelcomePageObjects;

import java.util.concurrent.TimeUnit;

/**
 * Created by equalexperts on 04/02/18.
 */
public class WelcomePage {
    WelcomePageObjects welcomePageObjects;
    AppiumDriver driver;
    public WelcomePage(AppiumDriver driver){
        this.driver = driver;
        welcomePageObjects = new WelcomePageObjects();
        PageFactory.initElements(new
                AppiumFieldDecorator(driver,15, TimeUnit.SECONDS),
                welcomePageObjects);
    }

    public ImmediateScreen enterUserNameAndContinue(String userName) {
        welcomePageObjects.userName.sendKeys(userName);
        welcomePageObjects.nextButton.click();
        return new ImmediateScreen(driver);
    }

}
