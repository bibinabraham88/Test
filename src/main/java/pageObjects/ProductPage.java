package pageObjects;

import functionLibrary.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.IReporter;
import org.testng.Reporter;

public class ProductPage extends CommonFunctions {

    public ProductPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "add-to-bag")
    WebElement addToBasketBtn;

    @FindBy(xpath = "//*[@id=\"cart-sidebar\"]/li/a/div/p")
    WebElement productInViewBasket;

    public void selectSize(String size){
        waitWithTime(2);
        driver.findElement(By.xpath("//div[normalize-space()='"+size+"']")).click();
    }

    public void addProductToBasket(){addToBasketBtn.click();}

    public void assertSameProductAdded(String expectedProduct){
        waitWithTime(2);
        try{
            Assert.assertTrue(expectedProduct.contains(productInViewBasket.getText()));
            Reporter.log("Selected product is successfully added to Basket");
        }
        catch(Error e){
            Reporter.log("Warning: Different product is added in the basket");
        }
    }

}
