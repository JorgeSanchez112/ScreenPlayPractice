package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class ClickOn implements Interaction {

    private Target target;

    public ClickOn(Target target) {
        this.target = target;
    }

    public static ClickOn the(Target target) {
        return new ClickOn(target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(target)
        );
    }

}
