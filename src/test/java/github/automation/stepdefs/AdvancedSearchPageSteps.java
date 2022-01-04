package github.automation.stepdefs;

import github.automation.pages.AdvancedSearchPage;
import io.cucumber.java.en.When;

import java.util.Map;

/**
 * Defines advanced search page step definitions.
 */
public class AdvancedSearchPageSteps {

    private final AdvancedSearchPage searchPage;

    /**
     * Initializes an instance of AdvancedSearchPageSteps class.
     *
     * @param searchPage pico-container class instance.
     */
    public AdvancedSearchPageSteps(final AdvancedSearchPage searchPage) {
        this.searchPage = searchPage;
    }

    /**
     * Sets parameters for advanced search.
     *
     * @param data parameters data.
     */
    @When("the user sets the following Advanced Search parameters")
    public void setParameters(final Map<String, String> data) {
        searchPage.fillSearchOptions(data);
    }

    /**
     * Clicks on search button.
     */
    @When("the user clicks on Search button")
    public void clickOnSearchButton() {
        searchPage.clickOnSearch();
    }
}
