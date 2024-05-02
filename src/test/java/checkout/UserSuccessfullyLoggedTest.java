package checkout;

import actors.Users;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.Text;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import tasks.LoginUser;
import userInterfaces.HomePage;

import java.time.Duration;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.StringContains.containsString;

@RunWith(SerenityRunner.class)
public class UserSuccessfullyLoggedTest {
    private Users user = new Users("John");

    @Before
    public void initializeBrowser(){
        user.can(BrowseTheWeb.with(WebDriverManager.chromedriver().getWebDriver()));
        user.attemptsTo(
                Open.url("https://www.demoblaze.com/index.html")
        );
    }

    @Test
    public void userHasBeenLoggingToHisAccount() {
        String username = "admin";
        String expectedMessage = "Welcome " + username;

        user.attemptsTo(
                LoginUser.withCredentials(username,"admin")
        );
        user.should(
                seeThat(
                        Text.of(HomePage.WELCOME_USERNAME_LINK.waitingForNoMoreThan(Duration.ofSeconds(10))),
                        containsString(expectedMessage)
                )
        );

    }

}
