package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ConfigManager;
import utils.DriverFactory;

import java.sql.Timestamp;
import java.util.Collection;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        Collection<String> tags = scenario.getSourceTagNames();
        if (!tags.contains("@ios") && !tags.contains("@mobile")) {
            DriverFactory.initDriver(ConfigManager.getBrowser());
        }
    }

    @AfterStep
    public void captureExceptionImage(Scenario scenario) {
        if (scenario.isFailed() && DriverFactory.getDriver() != null) {
            String timeMilliseconds = Long.toString(new Timestamp(System.currentTimeMillis()).getTime());
            byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot_" + timeMilliseconds);
        }
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}