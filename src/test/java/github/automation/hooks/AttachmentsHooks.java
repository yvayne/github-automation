package github.automation.hooks;

import github.automation.webdriver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import java.io.ByteArrayInputStream;

/**
 * Defines utility methods to attach data to Allure Report.
 */
public class AttachmentsHooks {

    private static final Logger LOGGER = LogManager.getLogger(AttachmentsHooks.class);
    private static final String IMAGE_NAME = "Page screenshot";
    private static final String IMAGE_TYPE = "image/png";
    private static final String IMAGE_EXT = "png";

    /**
     * Adds screenshot to Allure report when the scenario has a failed status.
     *
     * @param scenario {@link Scenario}.
     */
    @After
    public final void addScreenshot(final Scenario scenario) {
        if (scenario.isFailed() && Allure.getLifecycle().getCurrentTestCase().isPresent()) {
            try {
                byte[] screenshot = ((TakesScreenshot) DriverManager.getInstance().getWebDriver())
                        .getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment(IMAGE_NAME, IMAGE_TYPE, new ByteArrayInputStream(screenshot), IMAGE_EXT);
            } catch (WebDriverException e) {
                LOGGER.error("Error when take screenshot for failed test scenario.");
                LOGGER.error(e.getMessage());
            }
        }
    }
}
