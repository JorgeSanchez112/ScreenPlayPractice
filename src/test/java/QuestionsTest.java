import actors.Users;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.*;
import org.junit.Before;
import org.junit.Test;
import userInterfaces.HomePage;


public class QuestionsTest {
    private final Users user = new Users("John");
    @Before
    public void initializeBrowser(){
        user.can(BrowseTheWeb.with(WebDriverManager.chromedriver().getWebDriver()));
        user.attemptsTo(
                Open.url("https://www.demoblaze.com/index.html")
        );

    }

    @Test
    public void attribute(){
       String attribute  = Attribute.of(HomePage.LOGIN_LINK,"class").asString().answeredBy(user);
       System.out.println(attribute);
    }

    @Test
    public void cssValue(){
        String cssValue  = CSSValue.of(HomePage.LOGIN_LINK,"color").asString().answeredBy(user);
        System.out.println(cssValue);
    }

    @Test
    public void currentVisibility(){
        boolean currentVisibility  = CurrentVisibility.of(HomePage.LOGIN_LINK).asBoolean().answeredBy(user);
        System.out.println(currentVisibility);
    }

    @Test
    public void currentlyEnabled(){
        boolean cEnabled  = CurrentlyEnabled.of(HomePage.LOGIN_LINK).asBoolean().answeredBy(user);
        System.out.println(cEnabled);
    }

    @Test
    public void disabled(){
        boolean disabled  = Disabled.of(HomePage.LOGIN_LINK).asBoolean().answeredBy(user);
        System.out.println(disabled);
    }

    @Test
    public void displayed(){
        boolean displayed  = Displayed.of(HomePage.LOGIN_LINK).asBoolean().answeredBy(user);
        System.out.println(displayed);
    }

    @Test
    public void enabled(){
        boolean enabled  = Displayed.of(HomePage.LOGIN_LINK).asBoolean().answeredBy(user);
        System.out.println(enabled);
    }

    @Test
    public void size(){ //This show the size of the element.
        String sizeString  = TheSize.of(HomePage.LOGIN_LINK).asString().answeredBy(user);
        System.out.println(sizeString);
    }

    @Test
    public void textValue(){
        String txtValue  = TextValue.of(HomePage.LOGIN_LINK).asString().answeredBy(user);
        System.out.println(txtValue);
    }


}
