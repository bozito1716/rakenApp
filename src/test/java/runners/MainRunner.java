package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import listeners.AIFailureListener;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;


@Listeners(AIFailureListener.class)
@CucumberOptions(features = {"classpath:features"},
        glue = {"stepsDefinitions.web", "stepsDefinitions.mobile", "hooks"},
        tags = "@mobile-free-trial",
        monochrome = true,
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"})
public class MainRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();

    }

}
