package pageObjects;

import functionLibrary.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonFunctions {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "/html/body/main/div/div/div[1]/div/div[1]/div/div[1]/a")
    WebElement cookiesAcceptAllBtn;

    @FindBy(id = "shopping-bag-text")
    WebElement basketIconBtn;

    public void openHomePage(String homepage){
        driver.get(homepage);
        driver.manage().window().maximize();
        waitWithTime(1);
        cookiesAcceptAllBtn.click();
    }

    public void clickOnWinterMenuCategory(String category){
        waitWithTime(2);
        driver.findElement(By.id(category)).click();
    }

    public void clickOnProduct(String product){
        driver.findElement(By.xpath("//h2[normalize-space()='"+product+"']")).click();
    }

    public void clickOnBasket(){basketIconBtn.click();}

}
