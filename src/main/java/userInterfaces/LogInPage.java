package userInterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LogInPage extends PageObject {
    public static Target USERNAME_FIELD = Target.the("Username field").located(By.id("loginusername"));
    public static Target PASSWORD_FIELD = Target.the("Password field").located(By.id("loginpassword"));
    public static Target LOG_IN_BUTTON = Target.the("Login button").locatedBy("#logInModal >* .btn-primary");
    public static Target LABELS = Target.the("labels").locatedBy("#logInModal > .modal-dialog >* .form-control-label");
}
