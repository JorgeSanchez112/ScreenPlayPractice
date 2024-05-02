package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class TextOfElement implements Question<String> {
    private Target target;

    public TextOfElement(Target target) {
        this.target = target;
    }

    public static TextOfElement the(Target target) {
        return new TextOfElement(target);
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(target).answeredBy(actor);
    }
}
