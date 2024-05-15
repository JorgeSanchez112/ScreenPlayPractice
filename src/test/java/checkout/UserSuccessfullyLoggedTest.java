package checkout;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.WelcomeLinkMessage;
import tasks.LoginUser;


import static com.google.common.base.Predicates.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


public class UserSuccessfullyLoggedTest {

    @Given("{string} is on the login page")
    public void isOnTheLoginPage(String actorName) {
        OnStage.setTheStage(new OnlineCast());
        Actor user = OnStage.theActorCalled(actorName);

        user.can(BrowseTheWeb.with(WebDriverManager.chromedriver().getWebDriver()));
        user.attemptsTo(Open.url("https://www.demoblaze.com/index.html"));

        throw new io.cucumber.java.PendingException();
    }
    @When("{string} logs in with valid credentials")
    public void logsInWithValidCredentials(String actorName) {
        OnStage.setTheStage(new OnlineCast());
        Actor user = OnStage.theActorCalled(actorName);

        String username = "admin";

        // Perform login action
        user.attemptsTo(
                LoginUser.withCredentials(username, "admin")
        );

        throw new io.cucumber.java.PendingException();
    }
    @Then("{string} should be presented on the home page with his name {string} in a message")
    public void shouldBePresentedOnTheHomePageWithHisNameInAMessage(String actorName, String username) {
        OnStage.setTheStage(new OnlineCast());
        Actor user = OnStage.theActorCalled(actorName);

        String expectedWelcomeMessage = "Welcome " + username;

        // Assert the welcome message matches the expected message
        user.should(seeThat(WelcomeLinkMessage.displayed(), equalTo(expectedWelcomeMessage)));

        throw new io.cucumber.java.PendingException();
    }
}