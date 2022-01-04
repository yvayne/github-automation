package github.automation.pages;

import github.automation.pages.base.GitHubBasePage;
import github.automation.utils.WebElementActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Defines GitHub home page object.
 */
public class GitHubHomePage extends GitHubBasePage {

    @FindBy(css = ".home-hero h1")
    private WebElement mainTitleText;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void waitToLoad() {
        WebElementActions.waitUntilIsDisplayed(mainTitleText);
    }
}
