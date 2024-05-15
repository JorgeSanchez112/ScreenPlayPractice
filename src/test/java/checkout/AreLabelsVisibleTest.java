package checkout;

import actors.Users;
import interactions.ClickOn;
import interactions.WaitForVisibility;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import questions.TextsOfElements;
import userInterfaces.HomePage;
import userInterfaces.LogInPage;

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
        String expectedUsernameLabel = "Username:";

        user.attemptsTo(
                ClickOn.the(HomePage.LOGIN_LINK),
                WaitForVisibility.the(LogInPage.USERNAME_LABEL)
        );

        // Use the custom question to retrieve the welcome message
        String actualUsernameLabel = user.asksFor(TextsOfElements.displayed(LogInPage.USERNAME_LABEL));

        Assert.assertEquals(actualUsernameLabel,expectedUsernameLabel);
    }

    @Test
    public void validatePasswordLabelIsVisible(){
        String expectedPasswordLabel = "Password";

        user.attemptsTo(
                ClickOn.the(HomePage.LOGIN_LINK),
                WaitForVisibility.the(LogInPage.PASSWORD_LABEL)
        );

        // Assert the welcome message matches the expected message
        user.should(
                seeThat(TextsOfElements.displayed(LogInPage.PASSWORD_LABEL), equalTo(expectedPasswordLabel))
        );
    }

}
