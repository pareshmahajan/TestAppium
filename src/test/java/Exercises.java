import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * Created by equalexperts on 03/02/18.
 */
public class Exercises {

    public static final String PASSWORD = "org.wordpress.android:id/nux_password";
    public static final String SIGN_IN_BUTTON = "org.wordpress.android:id/nux_sign_in_button";
    public static final String BLOG_POSTS_TEXT_VIEW = "org.wordpress.android:id/my_site_blog_posts_text_view";
    public static final String ORG_WORDPRESS_TEXT = "org.wordpress.android:id/text_excerpt";
    public AppiumDriver<MobileElement> driver;


    @Test
    public void testDragNDrop() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"7.1.1");

        capabilities.setCapability(MobileCapabilityType.APP,"/Users/equalexperts/work/VodQA.apk");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

        Thread.sleep(4000L);

        driver.findElementByAccessibilityId("login").click();//
        Thread.sleep(4000L);

        driver.findElementByAccessibilityId("dragAndDrop").click();//CONTENT DESC is accesibilty id in ui automator
        Thread.sleep(2000);

        MobileElement dragElement = driver.findElementByAccessibilityId("dragMe");
        MobileElement dropZoneRect = driver.findElementByAccessibilityId("dropzone");


        TouchAction action = new TouchAction(driver);
        Dimension dragElementDimension = dragElement.getSize();
        Dimension dropZoneElementDimension = dragElement.getSize();

        action.press(ElementOption.element(dragElement)). //Press
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).     // Wait for few seconds since Appium has bug for iOS devices
                moveTo(ElementOption.element(dropZoneRect)) // move it
                .release().perform()   ;//release it

        driver.quit();

    }

}
