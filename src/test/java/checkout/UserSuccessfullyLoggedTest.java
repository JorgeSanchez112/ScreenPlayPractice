package checkout;

import actors.Users;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import questions.WelcomeLinkMessage;
import tasks.LoginUser;

import javax.naming.ConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import static com.google.common.base.Predicates.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

@RunWith(SerenityRunner.class)
public class UserSuccessfullyLoggedTest {
    Properties properties = new Properties();

    @Before
    public void initializeBrowser() {
        OnStage.setTheStage(new OnlineCast());
        Actor user = OnStage.theActorCalled("Toby");
        user.can(BrowseTheWeb.with(WebDriverManager.chromedriver().getWebDriver()));
        user.attemptsTo(Open.url("https://www.demoblaze.com/index.html"));
    }

    @Test
    public void crazy() throws ConfigurationException {
        Thread currentThread = Thread.currentThread();
        ClassLoader contextClassLoader = currentThread.getContextClassLoader();
        URL resource = contextClassLoader.getResource("serenity.properties");

        if (resource == null) {
            //Creo mi propia clase de excepciones para este caso
            throw new ConfigurationException("No existe el recurso serenity.properties");
        }

        try (InputStream is = resource.openStream()) {

            properties.load(is);
        } catch (IOException e) {
            throw new ConfigurationException(e.getMessage());
        }
        System.out.println(properties.getProperty("serenity.outputDirectory"));
    }

    @Test
    public void userHasBeenLoggingToHisAccount() {
        OnStage.setTheStage(new OnlineCast());
        Actor user = OnStage.theActorCalled("Toby");

        String username = "admin";
        String expectedWelcomeMessage = "Welcome " + username;

        // Perform login action
        user.attemptsTo(LoginUser.withCredentials(username, "admin"));

        Allure.step("Validating answer");
        // Assert the welcome message matches the expected message
        user.should(seeThat(WelcomeLinkMessage.displayed(), equalTo(expectedWelcomeMessage)));

        io.qameta.allure.Allure.step("Performed action", Status.PASSED);
    }
}