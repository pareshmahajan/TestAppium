package tests;

import org.junit.Test;
import pages.LoginPage;
import pages.WelcomePage;

import java.net.MalformedURLException;

/**
 * Created by equalexperts on 04/02/18.
 */
public class BlogTests extends BaseTest {
//    public static final String PASSWORD = "org.wordpress.android:id/nux_password";
//    public static final String SIGN_IN_BUTTON = "org.wordpress.android:id/nux_sign_in_button";
//    public static final String BLOG_POSTS_TEXT_VIEW = "org.wordpress.android:id/my_site_blog_posts_text_view";
//    public static final String ORG_WORDPRESS_TEXT = "org.wordpress.android:id/text_excerpt";
//    public AppiumDriver<MobileElement> driver;

    @Test
    public void verifyVodqaBlog() throws MalformedURLException, InterruptedException {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.enterUserNameAndContinue("vodqa@gmail.com").clickUsePasswordInsteadLink();
//
//        ImmediateScreen immediateScreen = new ImmediateScreen(driver);
//        immediateScreen.clickUsePasswordInsteadLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPasswordAndContinue("Hello12345678");
//
//        driver.findElement(By.id("org.wordpress.android:id/nux_username")).setValue(userName);
//        driver.findElement(By.id(SIGN_IN_BUTTON)).click();
//
//        String USE_PASSWORD_INSTEAD_LINK = "org.wordpress.android:id/password_layout";
//        WebDriverWait wait = new WebDriverWait(driver, 4);
//
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(USE_PASSWORD_INSTEAD_LINK)));
//
//        driver.findElement(By.id(USE_PASSWORD_INSTEAD_LINK)).click();
//
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(PASSWORD)));
//        driver.findElement(By.id(PASSWORD)).setValue(password);
//        driver.findElement(By.id(SIGN_IN_BUTTON)).click();
//
//
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(BLOG_POSTS_TEXT_VIEW)));
//        driver.findElement(By.id(BLOG_POSTS_TEXT_VIEW)).click();
//        Thread.sleep(2000);
//
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(ORG_WORDPRESS_TEXT)));
//        Assert.assertEquals("VodQA Rocks!!",driver.findElement(By.id(ORG_WORDPRESS_TEXT)).getText());

        driver.quit();

    }
}
