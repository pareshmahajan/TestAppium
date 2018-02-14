package pagefactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by equalexperts on 04/02/18.
 */
public class LoginPageObjects {
    @AndroidFindBy(id = "org.wordpress.android:id/nux_password")
    public MobileElement passwordTextBox;

    @AndroidFindBy(id = "org.wordpress.android:id/nux_sign_in_button")
    public MobileElement nextButton;

}
