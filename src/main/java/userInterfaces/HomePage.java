package userInterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage extends PageObject {
    public static Target LOGIN_LINK = Target.the("Login link").located(By.ByLinkText.linkText("Log in"));
    public static Target WELCOME_USERNAME_LINK = Target.the("Welcome username").locatedBy("#narvbarx > #navbarExample >* li:nth-child(7) > a");
}
