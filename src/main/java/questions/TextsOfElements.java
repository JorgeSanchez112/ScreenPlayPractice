package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class TextsOfElements implements Question<String> {

    private Target target;

    public TextsOfElements(Target target) {
        this.target = target;
    }

    public static TextsOfElements displayed(Target target) {
        return new TextsOfElements(target);
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(target).answeredBy(actor);
    }
}
