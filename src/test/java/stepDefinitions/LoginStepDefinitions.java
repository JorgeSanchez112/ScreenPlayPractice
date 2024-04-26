package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import tasks.LoginTask;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;


public class LoginStepDefinitions {
    Actor user = Actor.named("John");

    @Given("User is on the login page")
    public void userIsOnLoginPage() {
        // Assign the ability to browse the web
        user.can(BrowseTheWeb.with(WebDriverManager.chromedriver().getWebDriver()));

        // Navigate to the login page (for example, using Open)
        user.attemptsTo(Open.url("https://www.demoblaze.com/index.html"));
    }

    @When("User enters valid username {string} and password {string} and click on login button")
    public void userEntersUsernameAndPassword(String username, String password) {
        // Perform the login task
        user.attemptsTo(LoginTask.withCredentials(username, password));
    }

    @Then("User should be redirected to the home page")
    public void userIsRedirectedToHomePage() {
        // Assert the outcome using Screenplay questions
        // For example, verify if the user is redirected to the home page
        Target homePageWelcomeMessage = Target.the("message of welcome to username").located(By.id("nameofuser"));
        user.should(
                seeThat(Text.of(homePageWelcomeMessage), containsString("Welcome admin"))
        );
    }
}
