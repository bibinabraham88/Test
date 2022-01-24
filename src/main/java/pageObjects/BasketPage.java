package pageObjects;

import functionLibrary.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage extends CommonFunctions {
    public BasketPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    static String subTotal;
    @FindBy(xpath = "//div[6]//form[1]//button[1]//span[1]//span[1]")
    WebElement proceedToCheckOutBtn;

    @FindBy(xpath = "/html/body/main/div/div/div[2]/div[5]/p/span")
    WebElement subTotalInBasket;

    public void proceedToCheckOut(){
        subTotal = subTotalInBasket.getText();
        proceedToCheckOutBtn.click();

    }
}
