package github.automation.utils;

import io.restassured.RestAssured;

/**
 * Defines utility methods for http requests.
 */
public final class RequestUtils {

    /**
     * Private constructor for RequestUtils utility class.
     */
    private RequestUtils() {
        // Default constructor.
    }

    /**
     * Executes GET request to get body content.
     *
     * @param url url to request.
     * @return body content.
     */
    public static String getBody(final String url) {
        return RestAssured.given()
                .get(url)
                .getBody()
                .asString();
    }
}
