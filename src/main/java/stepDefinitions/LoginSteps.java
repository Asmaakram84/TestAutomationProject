package stepDefinitions;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;


public class LoginSteps  extends  BaseTest{

    @Before
    public void beforeScenario() {
        setup();
    }
    @Given("User is on Main Login page")
    public void user_is_on_login_page() {
        login.verifyUserIsOnMainLoginPage();

    }
    String emailAdd="asmaakram84@gmail.com";
    String accountPass="inte1GREAT@";
    @When("I click on the Login button")
    public void iClickOnTheLoginbutton() {

        login.verifyUserClickOnMainLoginBtn();
    }
    @When("I enter the user email")
    public void i_enter_the_user_email()  {

        login.enterUserEmail(emailAdd);

    }
    @And("I enter the user password")
    public void i_enter_the_user_password() {
        login.enterPassword(accountPass);
    }
    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        login.clickLoginBtn();
    }
    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        login.verifyUserIsOnHomePage();

    }

    @And("I enter the Invalid user email")
    public void iEnterTheInvalidUserEmail() {
        login.enterUserEmail("Test123.com");
    }

    @Then("I should not be logged in successfully")
    public void iShouldNotBeLoggedInSuccessfully() {
      login.verifyInValidEmail();
    }
    @After
    public void afterScenario() {

        tearDown();
    }



}
