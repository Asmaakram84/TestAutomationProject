package stepDefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AddtoCartSteps  extends BaseTest {

    /*loginPage login = new loginPage();
    HomePage home = new HomePage();*/
    @Before
    public void beforeScenario() {
        setup();
    }

    @After
    public void afterScenario() {

        tearDown();
    }


}
