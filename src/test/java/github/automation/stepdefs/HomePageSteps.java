package github.automation.stepdefs;

import github.automation.pages.GitHubHomePage;
import io.cucumber.java.en.When;

/**
 * Defines home page step definitions.
 */
public class HomePageSteps {

    private final GitHubHomePage homePage;

    /**
     * Initializes an instance of HomePageSteps class.
     *
     * @param homePage pico-container class instance.
     */
    public HomePageSteps(final GitHubHomePage homePage) {
        this.homePage = homePage;
    }

    /**
     * Searches a term from navigation bar search input.
     *
     * @param term search term.
     */
    @When("the user searches {string}")
    public void searchTerm(final String term) {
        homePage.getTopNavigationBar().searchInGitHub(term);
    }
}
