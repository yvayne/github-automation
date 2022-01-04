package github.automation.stepdefs;

import github.automation.config.Environment;
import github.automation.utils.RequestUtils;
import github.automation.utils.StringUtils;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Defines request step definitions.
 */
public class RequestSteps {

    private static final Logger LOGGER = LogManager.getLogger(RequestSteps.class);
    private static final String RAW_CONTENT_URL_FORMAT = Environment.config().getRawContentUrlFormat();

    /**
     * Retrieves data from GitHub repository file and logs content in standart output.
     *
     * @param chars    chars limitation.
     * @param repoFile repository file.
     * @param repoName repository name.
     */
    @When("retrieves the {int} characters of the {string} file in {string} repository")
    public void retrievesContentFromFile(final int chars, final String repoFile, final String repoName) {
        String url = String.format(RAW_CONTENT_URL_FORMAT, repoName, repoFile);
        String content = RequestUtils.getBody(url);
        String contentLimited = StringUtils.limitString(content, chars);
        LOGGER.info(String.format("Content of %s first chars of %s file:", chars, repoFile));
        LOGGER.info(contentLimited);
    }
}
