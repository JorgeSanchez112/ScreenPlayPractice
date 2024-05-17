package checkout;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Text;
import tasks.ValidateVisibility;
import userInterfaces.HomePage;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.empty;


public class UserSuccessfullySeeProductsTest {

    @Before
    public void set_the_stage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{string} is on the home page")
    public void isAccessingToThePage(String actorName){
        Actor user = OnStage.theActorCalled(actorName);

        user.can(BrowseTheWeb.with(WebDriverManager.chromiumdriver().getWebDriver()));
        user.attemptsTo(Open.url("https://www.demoblaze.com/"));
    }

    @Then("{string} should be able to see all the sale products.")
    public void isOnTheHomePage(String actorName){
        Actor user = OnStage.theActorCalled(actorName);

        user.attemptsTo(
                ValidateVisibility.ofElements(HomePage.HOME_PRODUCTS)
        );

        user.should(
                seeThat("The sale products are visible",
                        Text.ofEach(HomePage.HOME_PRODUCTS).asListOf(String.class),
                        not(empty())
                )
        );

    }
}
