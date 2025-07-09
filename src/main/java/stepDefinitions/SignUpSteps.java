package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.UUID;


public class SignUpSteps extends  BaseTest{
    @Before
    public void beforeScenario() {
        setup();
    }
    @Given("User is on owasp Main Login page")
    public void user_is_on_Owasp_login_page() {
        login.verifyUserIsOnMainLoginPage();

    }
     String firstName="test";
    String  lastName = "User_" + UUID.randomUUID().toString().substring(0, 8);
    String accPass=firstName+"_"+lastName+"@";


    @When("I click on the Main Login button")
    public void iClickOnTheMainLoginbutton() {

        login.verifyUserClickOnMainLoginBtn();
    }
    @And("I click on the RegisterNow button")
    public void iClickOnTheRegisterNowButton() {

        signUp.ClickRegisterNowBtn();
    }
    @And("I Enter Email Address")
    public void iEnterEmailAddress() {
        signUp.EnterEmailAddress(lastName+"@gmail.com");
    }

    @And("I click Agree Button")
    public void iClickAgreeButton() {
        signUp.ClickAgreeButton();
    }

    @And("I click on the continue button")
    public void iClickOnTheContinueButton() {
        signUp.ClickContinueButton();
    }

    @Then("I should be successfully registered")
    public void iShouldBeSuccessfullyRegistered() {
    }

    /// /////Scenario 2/////////////////////
    @When("I enter the First Name")
    public void iEnterTheFirstName() {
        signUp.EnterFirstName(firstName);
    }

    @And("I enter Last name")
    public void iEnterLastName() {
        signUp.EnterLastName(lastName);
    }
    @When("I enter the account password")
    public void iEnterTheAccountPassword() {
        signUp.EnterPassword(accPass);
    }
    @When("I click on Captcha")
    public void iClickOnCaptcha() {
signUp.EnterCaptcha();
    }

    @And("I click on the Create Account Button")
    public void iClickOnTheCreateAccountButton() {
        signUp.ClickContinueButton();
    }
    @After
    public void afterScenario() {

        tearDown();
    }



}
