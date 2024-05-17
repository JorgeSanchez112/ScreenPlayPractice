package tasks;

import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;

public class ValidateVisibility implements Task {
    final private Target target;

    public  ValidateVisibility(Target target){
        this.target = target;
    }

    public static ValidateVisibility ofElements(Target targetLocator) {
        return new ValidateVisibility(targetLocator);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(target.resolveAllFor(actor).stream().allMatch(WebElementState::isVisible))
        );
    }
}
