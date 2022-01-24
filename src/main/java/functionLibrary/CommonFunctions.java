package functionLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class CommonFunctions {

    public static WebDriver driver;

    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public void closeBrowser(){driver.quit();}

    public void waitWithTime(int timeInSeconds){
        driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
    }

    public void waitForElement(WebElement element){
        WebDriverWait w = new WebDriverWait(driver,10);
        w.until(ExpectedConditions.visibilityOf(element)).click();
    }
}
