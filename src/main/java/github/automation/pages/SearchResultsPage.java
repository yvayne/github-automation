package github.automation.pages;

import github.automation.pages.base.GitHubBasePage;
import github.automation.utils.WebElementActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Defines search results page object.
 */
public class SearchResultsPage extends GitHubBasePage {

    private static final String RESULTS_REGEX = "([0-9,]+).+";
    private static final String RESULTS_NUMBER_GROUP = "$1";
    private static final String SEARCH_RESULT_CSS_BASE_SELECTOR = ".repo-list a[href='/%s']";

    @FindBy(xpath = "//details[contains(@class,'details-reset')]//preceding-sibling::a[contains(@href,'advanced')]")
    private WebElement advancedSearchLink;

    @FindBy(xpath = "//ul[@class='repo-list']//preceding-sibling::div[1]")
    private WebElement resultsText;

    /**
     * Clicks on advanced search link.
     */
    public void clickOnAdvancedSearchLink() {
        WebElementActions.click(advancedSearchLink);
    }

    /**
     * Gets results number from page.
     *
     * @return results number string representation.
     */
    public String getResultsNumber() {
        String text = WebElementActions.getText(resultsText);
        return text.replaceAll(RESULTS_REGEX, RESULTS_NUMBER_GROUP);
    }

    /**
     * Checks if result is contained in search results.
     *
     * @param result result item text.
     * @return true if is contained, false otherwise.
     */
    public boolean isResultContained(final String result) {
        WebElement element = getResultElement(result);
        return WebElementActions.isDisplayed(element);
    }

    /**
     * Enters to result item link.
     *
     * @param result result item text.
     */
    public void enterToResult(final String result) {
        WebElement element = getResultElement(result);
        WebElementActions.click(element);
    }

    /**
     * Gets result element in list.
     *
     * @param result result item text.
     * @return web element.
     */
    private WebElement getResultElement(final String result) {
        String selector = String.format(SEARCH_RESULT_CSS_BASE_SELECTOR, result);
        return WebElementActions.getCSSElement(selector);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void waitToLoad() {
        WebElementActions.waitUntilIsDisplayed(advancedSearchLink);
    }
}
