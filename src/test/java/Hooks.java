import functionLibrary.CommonFunctions;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends CommonFunctions {

    @Before
    public void beforeTest(){
        openBrowser();
    }
    @After
    public void afterTest(){
        closeBrowser();
    }

}
