package github.automation.pages.components;

import github.automation.pages.base.BaseComponent;
import github.automation.utils.WebElementActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Defines top navigation bar component.
 */
public class TopNavigationBar extends BaseComponent {

    @FindBy(css = "input[name='q']")
    private WebElement searchInput;

    /**
     * Executes the action to search a term.
     * @param searchTerm search term.
     */
    public void searchInGitHub(final String searchTerm) {
        WebElementActions.setText(searchInput, searchTerm);
        WebElementActions.sendKey(searchInput, Keys.ENTER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void waitToLoad() {
        WebElementActions.waitUntilIsDisplayed(searchInput);
    }
}
