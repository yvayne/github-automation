package github.automation.utils;

import github.automation.webdriver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * It is in charged to manage the common web elements actions.
 */
public final class WebElementActions {

    private static final Logger LOGGER = LogManager.getLogger(WebElementActions.class);
    private static final String WEB_ELEMENT_NOT_FOUND_MSG = "Web element is not found in current page";
    private static final int DISPLAY_WAIT_TIME = 5;

    /**
     * Private constructor for {@link WebElementActions} utility class.
     */
    private WebElementActions() {
        // Default constructor.
    }

    /**
     * Sets input text.
     *
     * @param webElement WebElement to wait and fill.
     * @param text       Text to fill.
     */
    public static void setText(final WebElement webElement, final String text) {
        webElement.sendKeys(text);
    }

    /**
     * Waits and clicks on a web element.
     *
     * @param webElement web element to wait and click.
     */
    public static void click(final WebElement webElement) {
        DriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * Waits and gets the text of an WebElement.
     *
     * @param webElement WebElement to wait and get the text.
     * @return Text of element.
     */
    public static String getText(final WebElement webElement) {
        DriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    /**
     * Verifies if web element is Displayed.
     *
     * @param webElement web element.
     * @return True if the element is Displayed.
     */
    public static boolean isDisplayed(final WebElement webElement) {
        try {
            DriverManager.getInstance().setImplicitTimeWait(DISPLAY_WAIT_TIME);
            DriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
            DriverManager.getInstance().setDefaultTimeWaits();
            return true;
        } catch (TimeoutException e) {
            LOGGER.info(WEB_ELEMENT_NOT_FOUND_MSG);
            return false;
        }
    }

    /**
     * Waits until element is displayed.
     *
     * @param webElement web element.
     */
    public static void waitUntilIsDisplayed(final WebElement webElement) {
        DriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * Selects an item by value in select element.
     *
     * @param webElement select element.
     * @param value      value to be selected.
     */
    public static void setSelectByText(final WebElement webElement, final String value) {
        Select select = new Select(webElement);
        select.selectByVisibleText(value);
    }

    /**
     * Sends single key to web element.
     *
     * @param webElement web element.
     * @param key        key to send.
     */
    public static void sendKey(final WebElement webElement, final Keys key) {
        webElement.sendKeys(key);
    }

    /**
     * Gets web element using css selector.
     *
     * @param cssSelector css selector.
     * @return web element.
     */
    public static WebElement getCSSElement(final String cssSelector) {
        return DriverManager.getInstance().getWebDriver().findElement(By.cssSelector(cssSelector));
    }
}
