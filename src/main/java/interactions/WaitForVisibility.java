package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class WaitForVisibility implements Interaction {
    private Target target;

    public WaitForVisibility(Target target) {
        this.target = target;
    }

    public static WaitForVisibility the(Target target) {
        return new WaitForVisibility(target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(target, isVisible()).forNoMoreThan(Duration.ofSeconds(10))
        );
    }

}
