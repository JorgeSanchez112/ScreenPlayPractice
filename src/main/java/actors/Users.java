package actors;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

public class Users {
    private Actor john;

    public Users(WebDriver driver) {
        this.john = Actor.named("John");
        this.john.can(BrowseTheWeb.with(driver));
    }

    public Actor getJohn() {
        return john;
    }
}
