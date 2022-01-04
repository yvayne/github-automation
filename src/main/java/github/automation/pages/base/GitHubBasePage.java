package github.automation.pages.base;

import github.automation.pages.components.TopNavigationBar;

/**
 * Defines GitHub base page, with all common components.
 */
public abstract class GitHubBasePage extends BaseComponent {

    private final TopNavigationBar topNavigationBar;

    /**
     * Initializes an instance of GitHubBasePage class.
     */
    public GitHubBasePage() {
        topNavigationBar = new TopNavigationBar();
    }

    /**
     * Gets top navigation bar component.
     *
     * @return top navigation bar component.
     */
    public TopNavigationBar getTopNavigationBar() {
        return topNavigationBar;
    }

    /**
     * {@inheritDoc}
     */
    protected abstract void waitToLoad();
}
