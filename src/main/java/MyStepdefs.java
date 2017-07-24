import com.hp.lft.verifications.Verify;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import com.hp.lft.report.Reporter;
import com.hp.lft.sdk.web.*;
import org.junit.Assert;

/**
 * Created by HPE on 7/5/2017.
 */
public class MyStepdefs {

    Browser browser;

    @Before
    public void beforeScenario(Scenario scenario) throws Exception {
        Reporter.startTest(scenario.getName());

        browser = BrowserFactory.launch(BrowserType.CHROME);
    }

    @After
    public void afterScenario() throws Exception {
        browser.close();

        Reporter.endTest();
    }

    @Given("^user is logged in$")
    public void userIsLoggedIn() throws Throwable {

        Reporter.startReportingContext("Given: user is logged in");

        //browser.navigate("http://DockerServer:8000/#/");
        browser.navigate("http://www.advantageonlineshopping.com");

        browser.describe(Link.class, new LinkDescription.Builder()
                .tagName("A").innerText("My account My Orders Sign out ").build()).click();

        browser.describe(EditField.class, new EditFieldDescription.Builder()
                .type("text").tagName("INPUT").name("username").build()).setValue("Roman");

        browser.describe(EditField.class, new EditFieldDescription.Builder()
                .type("password").tagName("INPUT").name("password").build()).setValue("Roman7");

        browser.describe(Button.class, new ButtonDescription.Builder()
                .buttonType("button").tagName("BUTTON").name("SIGN IN").build()).click();

        Reporter.endReportingContext();
    }


    @When("^user clicks on an item$")
    public void user_clicks_on_an_item() throws Throwable {
        Reporter.startReportingContext("When: user clicks on an item");

        browser.describe(Link.class, new LinkDescription.Builder()
                .tagName("DIV").innerText("TABLETS Shop Now ").build()).click();

        browser.describe(WebElement.class, new WebElementDescription.Builder()
                .tagName("A").innerText("HP ElitePad 1000 G2 Tablet").build()).click();

        Reporter.endReportingContext();
    }

    @Then("^he can see the item description$")
    public void he_can_see_the_item_description() throws Throwable {
        Reporter.startReportingContext("Then: he can see the item description");

        Button addToCartBtn = browser.describe(Button.class, new ButtonDescription.Builder()
                .buttonType("submit").tagName("BUTTON").name("ADD TO CART").build());

        boolean addToCartBtnExists = addToCartBtn.exists();
        Verify.isTrue(addToCartBtnExists);

        Reporter.endReportingContext();

        Assert.assertTrue(addToCartBtnExists);
    }
}
