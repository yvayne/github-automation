package github.automation.pages;

import github.automation.pages.base.GitHubBasePage;
import github.automation.pages.fields.SearchFields;
import github.automation.utils.Actionable;
import github.automation.utils.WebElementActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines Advanced Search page object.
 */
public class AdvancedSearchPage extends GitHubBasePage {

    @FindBy(css = "#search_form .pagehead button")
    private WebElement searchButton;

    @FindBy(css = "#search_language")
    private WebElement languageSelect;

    @FindBy(css = "#search_state")
    private WebElement stateSelect;

    @FindBy(css = "#search_stars")
    private WebElement manyStarsInput;

    @FindBy(css = "#search_followers")
    private WebElement manyFollowersInput;

    @FindBy(css = "#search_license")
    private WebElement licenseSelect;

    /**
     * Clicks on search button.
     */
    public void clickOnSearch() {
        WebElementActions.click(searchButton);
    }

    /**
     * Sets language in select component.
     *
     * @param text element to select by text.
     */
    public void setLanguageSelect(final String text) {
        WebElementActions.setSelectByText(languageSelect, text);
    }

    /**
     * Sets state in select component.
     *
     * @param text element to select by text.
     */
    public void setStateSelect(final String text) {
        WebElementActions.setSelectByText(stateSelect, text);
    }

    /**
     * Sets many stars input.
     *
     * @param text text to be set.
     */
    public void setManyStarsInput(final String text) {
        WebElementActions.setText(manyStarsInput, text);
    }

    /**
     * Sets many followers input.
     *
     * @param text text to be set.
     */
    public void setManyFollowersInput(final String text) {
        WebElementActions.setText(manyFollowersInput, text);
    }

    /**
     * Sets license in select component.
     *
     * @param text element to select by text.
     */
    public void setLicenseSelect(final String text) {
        WebElementActions.setSelectByText(licenseSelect, text);
    }

    /**
     * Fills advanced search options.
     *
     * @param data data to be filled.
     */
    public void fillSearchOptions(final Map<String, String> data) {
        Map<String, Actionable> strategy = buildStrategyMap(data);
        data.keySet().forEach(field -> strategy.get(field).execute());
    }

    /**
     * Builds strategy map to fill data.
     *
     * @param data data to be filled.
     * @return strategy map.
     */
    private Map<String, Actionable> buildStrategyMap(final Map<String, String> data) {
        Map<String, Actionable> strategy = new HashMap<>();
        strategy.put(SearchFields.LANGUAGE.getDisplayText(),
                () -> setLanguageSelect(data.get(SearchFields.LANGUAGE.getDisplayText())));
        strategy.put(SearchFields.STATE.getDisplayText(),
                () -> setStateSelect(data.get(SearchFields.STATE.getDisplayText())));
        strategy.put(SearchFields.STARS.getDisplayText(),
                () -> setManyStarsInput(data.get(SearchFields.STARS.getDisplayText())));
        strategy.put(SearchFields.FOLLOWERS.getDisplayText(),
                () -> setManyFollowersInput(data.get(SearchFields.FOLLOWERS.getDisplayText())));
        strategy.put(SearchFields.LICENSE.getDisplayText(),
                () -> setLicenseSelect(data.get(SearchFields.LICENSE.getDisplayText())));
        return strategy;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void waitToLoad() {
        WebElementActions.waitUntilIsDisplayed(searchButton);
    }
}
