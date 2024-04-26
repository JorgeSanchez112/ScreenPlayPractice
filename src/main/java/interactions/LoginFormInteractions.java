package interactions;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class LoginFormInteractions {

    public static final Target LOGIN_LINK = Target.the("login link").located(org.openqa.selenium.By.linkText("Log in"));
    public static final Target USERNAME_FIELD = Target.the("username field").located(By.id("loginusername"));
    public static final Target PASSWORD_FIELD = Target.the("password field").located(By.id("loginpassword"));
    public static final Target LOGIN_BUTTON = Target.the("login button").located(By.cssSelector("#logInModal >* div.modal-footer > button.btn-primary"));

}
