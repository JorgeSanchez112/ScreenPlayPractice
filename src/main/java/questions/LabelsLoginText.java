package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import userInterfaces.HomePage;
import userInterfaces.LogInPage;


public class LabelsLoginText implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(LogInPage.LABELS).asString().answeredBy(actor);
    }

    public static LabelsLoginText displayed() {
        return new LabelsLoginText();
    }

}
