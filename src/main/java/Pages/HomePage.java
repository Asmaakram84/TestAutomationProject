package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    By addCart = By.id("add-to-cart-sauce-labs-backpack");

    By RemoveBtn = By.id("remove-sauce-labs-backpack");
    By ShoppingCart = By.id("shopping_cart_container");
    By cartItem = By.className("cart_item");

    public HomePage(WebDriver driver) {
        this.driver =driver;
    }

    public void ClickaddToCart() {
        driver.findElement(addCart).click();
    }


    public String verifyAddCart() {
        String verifyCartProduct = driver.findElement(RemoveBtn).getText();
        return verifyCartProduct;

    }
    public void clickCartoption(){
        driver.findElement(ShoppingCart).click();

    }
    public Boolean verifyCartPageitem() {
       if(driver.findElement(cartItem).isDisplayed())
           return true;
       return false;
    }
}
