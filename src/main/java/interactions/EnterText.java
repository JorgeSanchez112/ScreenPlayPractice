package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

public class EnterText implements Interaction {
    private Target target;
    private String text;

    public EnterText(Target target,String text) {
        this.target = target;
        this.text = text;
    }

    public static EnterText the(Target target,String text) {
        return new EnterText(target,text);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(text).into(target)
        );
    }

}
