package pagefactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by equalexperts on 04/02/18.
 */
public class ImmediatePageObjects {

    @AndroidFindBy(id = "org.wordpress.android:id/password_layout")
    public MobileElement usePasswordInsteadLink;
}
