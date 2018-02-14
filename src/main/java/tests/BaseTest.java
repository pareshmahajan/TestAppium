package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by equalexperts on 04/02/18.
 */
public class BaseTest {

    public AppiumDriver driver;

    public BaseTest() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //capabilities.setPlatform(Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"7.1.1");

        capabilities.setCapability(MobileCapabilityType.APP,"/Users/equalexperts/work/wordpress.apk");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"org.wordpress.android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"org.wordpress.android.ui.WPLaunchActivity");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

        try {
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        }catch (MalformedURLException e){
            e.fillInStackTrace();
        }


    }


}
