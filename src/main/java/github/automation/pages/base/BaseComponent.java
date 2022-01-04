package github.automation.pages.base;

import github.automation.webdriver.DriverManager;
import org.openqa.selenium.support.PageFactory;

/**
 * Defines the page object model and components base abstraction.
 */
public abstract class BaseComponent {

    /**
     * Initializes an instance of {@link BaseComponent}.
     */
    public BaseComponent() {
        PageFactory.initElements(DriverManager.getInstance().getWebDriver(), this);
        waitToLoad();
    }

    /**
     * Gets page title.
     *
     * @return page title.
     */
    public String getTitle() {
        return DriverManager.getInstance().getWebDriver().getTitle();
    }

    /**
     * Defines method to wait until load is complete.
     */
    protected abstract void waitToLoad();
}
