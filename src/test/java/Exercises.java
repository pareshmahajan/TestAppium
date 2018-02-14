import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

//    @Test
//    public void launchWithAndriodCap() throws MalformedURLException, InterruptedException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//
//        //capabilities.setPlatform(Platform.ANDROID);
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"emulator-5554");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"7.1.1");
//
//        capabilities.setCapability(MobileCapabilityType.APP,"/Users/equalexperts/work/wordpress.apk");
//        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"org.wordpress.android");
//        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"org.wordpress.android.ui.WPLaunchActivity");
//        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
//
//        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
//
//        Thread.sleep(4000L);
//
//        String email = "pm@gmail.com";
//        String userName = "paresh3";
//        String wordpress = userName+"wordpress.com";
//
//        driver.findElement(By.id("org.wordpress.android:id/nux_create_account_button")).click();
//
//        Thread.sleep(4000L);
//
//
//        driver.findElement(By.id()).setValue(email);
//        driver.findElement(By.id("org.wordpress.android:id/username")).setValue(userName);
////        driveriver.findElement(By.id("")).setValue("");
//
//        Assert.assertEquals("paresh3","");
//
//
//        driver.findElement(By.id("org.wordpress.android:id/signup_button")).click();
//
//
//        driver.quit();
//
//    }

    @Test
    public void verifyVodqaBlog() throws MalformedURLException, InterruptedException {
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

        Thread.sleep(4000L);

        String password = "Hello12345678";
        String userName = "vodqa@gmail.com";


//        driver.findElement(By.id("org.wordpress.android:id/nux_username")).setValue(userName);
        driver.findElement(By.id("org.wordpress.android:id/nux_username")).sendKeys(userName);
        driver.findElement(By.id(SIGN_IN_BUTTON)).click();

        String USE_PASSWORD_INSTEAD_LINK = "org.wordpress.android:id/password_layout";
        WebDriverWait wait = new WebDriverWait(driver, 4);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(USE_PASSWORD_INSTEAD_LINK)));

        driver.findElement(By.id(USE_PASSWORD_INSTEAD_LINK)).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(PASSWORD)));
        driver.findElement(By.id(PASSWORD)).setValue(password);
        driver.findElement(By.id(SIGN_IN_BUTTON)).click();


        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(BLOG_POSTS_TEXT_VIEW)));
        driver.findElement(By.id(BLOG_POSTS_TEXT_VIEW)).click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(ORG_WORDPRESS_TEXT)));
        Assert.assertEquals("VodQA Rocks!!",driver.findElement(By.id(ORG_WORDPRESS_TEXT)).getText());

        driver.quit();

    }




    @Test
    public void launchWithiOSCap() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //capabilities.setPlatform(Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"iOS");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone 6");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.2");

        capabilities.setCapability(MobileCapabilityType.APP,"/Users/equalexperts/work/VodQA.apk");
//        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"org.wordpress.android");
//        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"org.wordpress.android.ui.WPLaunchActivity");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

        Thread.sleep(4000L);
        driver.quit();

    }


    @Test
    public void testHorizontalSwipe() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //capabilities.setPlatform(Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"7.1.1");

        capabilities.setCapability(MobileCapabilityType.APP,"/Users/equalexperts/work/VodQA.apk");
//        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.vodqareactnative");
//        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.vodqareactnative.MainActivity");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

        Thread.sleep(4000L);

        driver.findElementByAccessibilityId("login").click();//android.widget.EditText CLASSNAME???
        Thread.sleep(4000L);

        driver.findElementByAccessibilityId("slider1").click();//CONTENT DESC is accesibilty id in ui automator
        Thread.sleep(2000);

        MobileElement slider = driver.findElementByAccessibilityId("slider");



        TouchAction action = new TouchAction(driver);
        Dimension d = slider.getSize();

        action.press(ElementOption.element(slider, 0, d.getHeight()/2)). //Press
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).     // Wit for few secnods since APIIUM has bug for iOS devices
                moveTo(ElementOption.element(slider, d.getWidth()/2, d.getHeight()/2)) // move it
                .release().perform()   ;//release it


        driver.quit();

    }


    @Test
    public void testVeriticalSwipe() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //capabilities.setPlatform(Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"7.1.1");

        capabilities.setCapability(MobileCapabilityType.APP,"/Users/equalexperts/work/VodQA.apk");
//        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.vodqareactnative");
//        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.vodqareactnative.MainActivity");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

        Thread.sleep(4000L);

        driver.findElementByAccessibilityId("login").click();//android.widget.EditText CLASSNAME???
        Thread.sleep(4000L);

        driver.findElementByAccessibilityId("verticalSwipe").click();//CONTENT DESC is accesibilty id in ui automator
        Thread.sleep(2000);

        MobileElement list = driver.findElementByAccessibilityId("listview");



        TouchAction action = new TouchAction(driver);
        Dimension d = list.getSize();

        action.press(ElementOption.element(list, d.getWidth()/2, d.getHeight()/2)). //Press
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).     // Wait for few seconds since APpIUM has bug for iOS devices
                moveTo(ElementOption.element(list, d.getWidth()/2, d.getHeight()/4)) // move it
                .release().perform()   ;//release it


        driver.quit();

    }


    @Test
    public void testDragnDrop() throws MalformedURLException, InterruptedException {
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

//        action.press(ElementOption.element(dragElement, dragElementDimension.getWidth()/2, dragElementDimension.getHeight()/2)). //Press
//                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).     // Wait for few seconds since Appium has bug for iOS devices
//                moveTo(ElementOption.element(dropZoneRect, dropZoneElementDimension.getWidth()/2, dropZoneElementDimension.getHeight()/2)) // move it
//                .release().perform()   ;//release it

        action.press(ElementOption.element(dragElement)). //Press
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).     // Wait for few seconds since Appium has bug for iOS devices
                moveTo(ElementOption.element(dropZoneRect)) // move it
                .release().perform()   ;//release it

        driver.quit();

    }



    @Test
    public void testMoveBothTheSliders() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"7.1.1");

        capabilities.setCapability(MobileCapabilityType.APP,"/Users/equalexperts/work/VodQA.apk");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        Thread.sleep(4000L);

        driver.findElementByAccessibilityId("login").click();//android.widget.EditText CLASSNAME???
        Thread.sleep(4000L);

        driver.findElementByAccessibilityId("slider1").click();//CONTENT DESC is accesibilty id in ui automator
        Thread.sleep(2000);

        MobileElement slider = driver.findElementByAccessibilityId("slider");
        MobileElement slider1 = driver.findElementByAccessibilityId("slider1");

        TouchAction action = new TouchAction(driver);
        TouchAction action1 = new TouchAction(driver);

        Dimension d = slider.getSize();
        Dimension d1 = slider1.getSize();

        action.press(ElementOption.element(slider, 0, d.getHeight()/2)). //Press
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).     // Wait for few secnods since APIIUM has bug for iOS devices
                moveTo(ElementOption.element(slider, d.getWidth(), d.getHeight()/2));

        action1.press(ElementOption.element(slider1, 0, d1.getHeight()/2)). //Press
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).     // Wait for few secnods since APIIUM has bug for iOS devices
                moveTo(ElementOption.element(slider1, d1.getWidth(), d1.getHeight()/2));


        // move it using multi touch action
        new MultiTouchAction(driver).add(action).add(action1).perform();//perform it

        driver.quit();

    }


    @Test
    public void testDoubleTap() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"7.1.1");

        capabilities.setCapability(MobileCapabilityType.APP,"/Users/equalexperts/work/VodQA.apk");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        Thread.sleep(4000L);

        driver.findElementByAccessibilityId("login").click();//android.widget.EditText CLASSNAME???
        Thread.sleep(4000L);

        driver.findElementByAccessibilityId("doubleTap").click();//CONTENT DESC is accesibilty id in ui automator
        Thread.sleep(2000);

        MobileElement doubleTapMe = driver.findElementByAccessibilityId("doubleTapMe");

        TouchAction action = new TouchAction(driver);

        Dimension d = doubleTapMe.getSize();

        action.tap(ElementOption.element(doubleTapMe, d.getWidth()/2,d.getHeight()/2)) //Press
//                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
//                .perform()
                .tap(ElementOption.element(doubleTapMe,d.getWidth()/2,d.getHeight()/2))
//                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .perform();


        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/message")));

        //Assert the pop up message
        Assert.assertEquals("Double tap successful!",driver.findElement(By.id("android:id/message")).getText());
        //CLick Ok button
        driver.findElement(By.id("android:id/button1")).click();

        //Waiting to see pop up vanished
        Thread.sleep(4000L);

        driver.quit();

    }



}
