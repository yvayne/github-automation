package github.automation.stepdefs;

import github.automation.config.Environment;
import github.automation.webdriver.DriverManager;
import io.cucumber.java.en.Given;

/**
 * Defines common step definitions.
 */
public class CommonSteps {

    private static final String HOME_URL = Environment.config().getHomeUrl();

    /**
     * Enters to GitHub home page.
     */
    @Given("the user goes to GitHub home page")
    public void gotoHomePage() {
        DriverManager.getInstance().getWebDriver().get(HOME_URL);
    }
}
