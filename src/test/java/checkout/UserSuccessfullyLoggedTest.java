package checkout;

import actors.Users;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import questions.WelcomeLinkMessage;
import tasks.LoginUser;

import static com.google.common.base.Predicates.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

@RunWith(SerenityRunner.class)
public class UserSuccessfullyLoggedTest {
    private final Users user = new Users("John");

    @Before
    public void initializeBrowser() {
        user.can(BrowseTheWeb.with(WebDriverManager.chromedriver().getWebDriver()));
        user.attemptsTo(Open.url("https://www.demoblaze.com/index.html"));
    }

    @Test
    public void userHasBeenLoggingToHisAccount() {
        String username = "admin";
        String expectedWelcomeMessage = "Welcome " + username;

        // Perform login action
        user.attemptsTo(LoginUser.withCredentials(username, "admin"));

        // Retrieve the actual welcome message from the UI
        String actualWelcomeMessage = user.asksFor(WelcomeLinkMessage.displayed());

        // Assert the welcome message matches the expected message
        user.should(seeThat(WelcomeLinkMessage.displayed(), equalTo(expectedWelcomeMessage)));
    }
}