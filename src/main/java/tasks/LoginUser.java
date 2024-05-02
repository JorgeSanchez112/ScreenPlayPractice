package tasks;

import interactions.ClickOn;
import interactions.EnterText;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.AnonymousTask;
import net.serenitybdd.screenplay.Task;
import userInterfaces.HomePage;
import userInterfaces.LogInPage;

public class LoginUser implements Task {
    private String username;
    private String password;

    public LoginUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static LoginUser withCredentials(String username, String password) {
        return new LoginUser(username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.the(HomePage.LOGIN_LINK),
                EnterText.the(LogInPage.USERNAME_FIELD,username),
                EnterText.the(LogInPage.PASSWORD_FIELD,password),
                ClickOn.the(LogInPage.LOG_IN_BUTTON)
        );
    }
}
