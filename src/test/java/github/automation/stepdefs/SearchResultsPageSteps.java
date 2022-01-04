package github.automation.stepdefs;

import github.automation.pages.SearchResultsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

/**
 * Defines search results page step definitions.
 */
public class SearchResultsPageSteps {

    private final SearchResultsPage resultsPage;

    /**
     * Initializes an instance of SearchResultsPageSteps class.
     *
     * @param resultsPage pico-container class instance.
     */
    public SearchResultsPageSteps(final SearchResultsPage resultsPage) {
        this.resultsPage = resultsPage;
    }

    /**
     * Enters to advanced search page.
     */
    @When("the user enters to Advanced Search page")
    public void entersToAdvancedSearchPage() {
        resultsPage.clickOnAdvancedSearchLink();
    }

    /**
     * Verifies repository results number.
     *
     * @param expectedNumber expected results number
     */
    @Then("verifies that there is only {string} repository results")
    public void verifyRepositoryNumberResults(final String expectedNumber) {
        Assert.assertEquals(resultsPage.getResultsNumber(), expectedNumber,
                "Results number does not match");
    }

    /**
     * Verifies result list item.
     *
     * @param repoName repository name.
     */
    @Then("verifies that the result list contains the {string} repository")
    public void verifyResultListContainsRepo(final String repoName) {
        Assert.assertTrue(resultsPage.isResultContained(repoName),
                "Expected result is not contained in results");
    }

    /**
     * Goes to repository page from search results page.
     *
     * @param repoName repository name.
     */
    @When("the user goes to {string} repository page")
    public void theUserGoesToRepositoryPage(final String repoName) {
        resultsPage.enterToResult(repoName);
    }
}
