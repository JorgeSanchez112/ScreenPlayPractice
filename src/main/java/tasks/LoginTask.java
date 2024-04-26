package tasks;

import interactions.LoginFormInteractions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class LoginTask implements Performable {
    private String username;
    private String password;

    public LoginTask(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static LoginTask withCredentials(String username, String password) {
        return new LoginTask(username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LoginFormInteractions.LOGIN_LINK),
                Enter.theValue(username).into(LoginFormInteractions.USERNAME_FIELD),
                Enter.theValue(password).into(LoginFormInteractions.PASSWORD_FIELD),
                Click.on(LoginFormInteractions.LOGIN_BUTTON)
        );
    }

}
