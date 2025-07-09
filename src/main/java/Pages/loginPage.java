package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class loginPage  {

public WebDriver driver;

    By mainLoginBtn = By.cssSelector("a.signin");
    //Locator for username field
    By usrName = By.id("user-name");

    //Locator for password field

    By accPswd = By.cssSelector("input[name='password']");

    //Locator for login button
    By emailAddress = By.cssSelector("input[name='email']");
     By submitBtn = By.cssSelector("button[type='submit']");
     By emailErrormsg = By.cssSelector("div.ToolTip.error.smaller.initialized.active section.content span.explanation");
    //Locator for login button
    By loginBtn = By.id("login-button");
    WebDriverWait wait;
;
    public loginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public void verifyUserIsOnMainLoginPage(){
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,"https://owasp.glueup.com/");
    }
    public void verifyUserClickOnMainLoginBtn(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(mainLoginBtn));
element.click();
        //driver.findElement(mainLoginBtn).click();

    }

    public void enterUserEmail(String myemail){
        driver.findElement(emailAddress).sendKeys(myemail);
    }

    public  void enterPassword(String mypass){
        driver.findElement(accPswd).sendKeys(mypass);
    }

    public void clickLoginBtn(){
        driver.findElement(submitBtn).click();
    }

    public void verifyUserIsOnHomePage(){

        String homePage= driver.getCurrentUrl();
        String myUrl="https://owasp.glueup.com/my/home/";
        Assert.assertEquals(homePage,myUrl);
    }

    public void verifyInValidEmail(){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(emailErrormsg));

        String actualmsg=element.getText();
        String myMsg="Please enter a valid email address\n" + "e.g. john.doe@glueup.com";
        if (actualmsg.contains(myMsg)) {
            System.out.println("TEST PASSED: Email is invalid. Expected error: '" + myMsg + "', Actual error: '" + actualmsg + "'");
        }
    }
}
