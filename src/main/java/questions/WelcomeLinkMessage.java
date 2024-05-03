package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import userInterfaces.HomePage;

public class WelcomeLinkMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(HomePage.WELCOME_USERNAME_LINK).asString().answeredBy(actor);
    }

    public static WelcomeLinkMessage displayed() {
        return new WelcomeLinkMessage();
    }
}
