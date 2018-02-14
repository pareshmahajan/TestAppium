import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by equalexperts on 09/02/18.
 */
public class EETest {

    public AppiumDriver<MobileElement> driver;

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //capabilities.setPlatform(Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.PLATFORM,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"7.1.1");

        capabilities.setCapability(MobileCapabilityType.APP,"/Users/equalexperts/work/wordpress.apk");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"org.wordpress.android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"org.wordpress.android.ui.accounts.SignInActivity");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

//        driver.findElement(By.id("org.wordpress.android:id/nux_username")).sendKeys("vodqa@gmail.com"
        driver.findElement(By.className("android.widget.EditText")).sendKeys("vodqa@gmail.com");
        driver.findElement(By.id("org.wordpress.android:id/nux_sign_in_button")).click();
//        driver.findElement(By.name("Next")).click();


        Thread.sleep(4000);

        driver.quit();
    }
}
