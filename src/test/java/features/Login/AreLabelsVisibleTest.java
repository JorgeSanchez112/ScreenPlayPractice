package features.Login;

import actors.Users;
import interactions.ClickOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import questions.LabelsLoginText;
import userInterfaces.HomePage;

import static com.google.common.base.Predicates.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

@RunWith(SerenityRunner.class)
public class AreLabelsVisibleTest {
    private final Users user = new Users("John");
    @Before
    public void initializeBrowser(){
        user.can(BrowseTheWeb.with(WebDriverManager.chromedriver().getWebDriver()));
        user.attemptsTo(
                Open.url("https://www.demoblaze.com/index.html")
        );
    }

    @Test
    public void validateUsernameLabelIsVisible(){
        String ExpectedUsernameLabel = "Username:";

        user.attemptsTo(
                ClickOn.the(HomePage.LOGIN_LINK)
        );

        // Use the custom question to retrieve the welcome message
        String actualWelcomeMessage = user.asksFor(LabelsLoginText.displayed());

        // Assert the welcome message matches the expected message
        user.should(seeThat(LabelsLoginText.displayed(), equalTo(ExpectedUsernameLabel)));
    }

    @Test
    public void validatePasswordLabelIsVisible(){
        String ExpectedPasswordLabel = "Password:";

        // Use the custom question to retrieve the welcome message
        String actualWelcomeMessage = user.asksFor(LabelsLoginText.displayed());

        // Assert the welcome message matches the expected message
        user.should(seeThat(LabelsLoginText.displayed(), equalTo(ExpectedPasswordLabel)));
    }
}
