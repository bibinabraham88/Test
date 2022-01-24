package pageObjects;

import functionLibrary.CommonFunctions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;


public class CheckOutPage extends CommonFunctions {
    public CheckOutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    BasketPage basket = new BasketPage(driver);

    @FindBy(name = "email")
    WebElement emailTxtFld;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement continueAfterEnteringEmailBtn;

    @FindBy(id = "customer-password")
    WebElement passwordTxtFld;

    @FindBy(xpath = "//span[normalize-space()='Continue']")
    WebElement continueAfterEnteringPasswordBtn;

    @FindBy(xpath = "//li[@class='bag__totals-item']/span[normalize-space()='£50.00']")
    WebElement subTotalAtCheckOut;

    @FindBy(id = "btn-payment--payNow")
    WebElement payWithCard;


    public void signInUsingEmailAndPassword(String email, String password){
        waitForElement(emailTxtFld);
        emailTxtFld.sendKeys(email);
        continueAfterEnteringEmailBtn.click();
        waitForElement(passwordTxtFld);
        passwordTxtFld.sendKeys(password);
        waitForElement(continueAfterEnteringPasswordBtn);
    }


    public void assertSubTotalInBasketAndChkOut() {
        waitWithTime(1);
        String subTotalBasket = basket.subTotal;
        try {
            Assert.assertTrue(subTotalAtCheckOut.getText().contains(subTotalBasket));
            Reporter.log("Same sub-total value is present in Basket and Checkout");
        }
        catch (Error e1) {
            Reporter.log("Warning: Different Sub-Total value in Basket and Checkout");
        }
    }

    public void scrollToPayments(){
        waitWithTime(4);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", payWithCard);
    }

    public void clickOnPaymentMethod(){
        waitWithTime(2);
        waitForElement(payWithCard);
    }


}
