package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pagefactory.LoginPageObjects;

import java.util.concurrent.TimeUnit;

/**
 * Created by equalexperts on 04/02/18.
 */
public class LoginPage {
    AppiumDriver driver;
    LoginPageObjects loginPageObjects;
    public LoginPage(AppiumDriver driver){
        this.driver = driver;
        loginPageObjects = new LoginPageObjects();
        PageFactory.initElements(new
                        AppiumFieldDecorator(driver,15, TimeUnit.SECONDS),
                loginPageObjects);
    }

    public void enterPasswordAndContinue(String password) {
        loginPageObjects.passwordTextBox.sendKeys(password);
        loginPageObjects.nextButton.click();
    }
}
