import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = ".", tags = "@basket")
public class Run extends AbstractTestNGCucumberTests {
}
