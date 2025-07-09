package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import java.time.Duration;


public class SignUpPage {

private WebDriver driver;

    By loginPagebtn = By.cssSelector("div.login.right > a");
    //Locator for username field
    By firstName = By.cssSelector("input[name='firstName']");
    By lastName = By.cssSelector("input[name='lastName']");
    //Locator for password field
    By accPswd = By.cssSelector("input[name='password']");

    //Locator for login button
    By registerNowBtn = By.partialLinkText("Register Now");
    By emailAddress = By.cssSelector("input[name='email']");
    By agreeBtn = By.xpath("//*[@id=\"registerAccountStandardForm\"]/form/fieldset/div[3]/div/label/input");
    By continueBtn = By.cssSelector("button[type='submit']");
    By cIframe = By.cssSelector("iframe[id^='cf-chl-widget-']");
    By reCaptchaCheckbox = By.id("NMOK7 ");
    String iframeIdPrefix = "cf-chl-widget-";

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
    }

    WebDriverWait wait;

    public void ClickRegisterNowBtn(){
        //driver.navigate().to("https://owasp.glueup.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(registerNowBtn));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

    }

    public void EnterEmailAddress(String email){
        //driver.navigate().to("https://owasp.glueup.com/");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddress));
        element.sendKeys(email);
    }
    public void ClickAgreeButton(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name=\"hasAgreedWithTerms\"]")));
            JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

    }

    public void ClickContinueButton(){
        driver.findElement(continueBtn).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public void EnterFirstName(String fName) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(firstName));

        element.sendKeys(fName);
    }
        public void EnterLastName(String lName) {
            driver.findElement(lastName).sendKeys(lName);
        }
            public void EnterPassword(String accountPass){
                driver.findElement(accPswd).sendKeys(accountPass);
    }
    public void EnterCaptcha(){
        String iframeIdPrefix = "cf-chl-widget-";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                    By.cssSelector("iframe[id^='" + iframeIdPrefix + "']")
            ));
            System.out.println("Switched to Cloudflare Turnstile iframe.");

            WebElement challengeElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("input[type='checkbox']")

            ));
            challengeElement.click();
            System.out.println("Clicked on Cloudflare Turnstile challenge.");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            driver.switchTo().defaultContent();
            System.out.println("Switched back to default content after Turnstile.");

        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchFrameException e) {
            System.out.println("Cloudflare Turnstile iframe not found or did not appear. Cloudflare may have passed the check automatically.");
            driver.switchTo().defaultContent(); // Ensure we're back on main page
        }

    }
//        // Wait for the reCAPTCHA iframe to be available and switch to it
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
//        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt((By.xpath("//iframe[starts-with(@id, 'cf-chl-widget-')]"))));
//
//        try {
//            WebElement elementInsideIframe = driver.findElement(reCaptchaCheckbox);
//
//            System.out.println("Found element inside iframe: " + elementInsideIframe.getText());
//            elementInsideIframe.click(); // Example action
//        } catch (org.openqa.selenium.NoSuchElementException e) {
//            System.out.println("Element 'elementInsideIframe' not found inside the iframe.");
//        }

    }





