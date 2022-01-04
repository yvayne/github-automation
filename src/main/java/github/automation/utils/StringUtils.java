package github.automation.utils;

/**
 * Defines string utility methods.
 */
public final class StringUtils {

    private static final int BEGIN_INDEX = 0;

    /**
     * Defines private constructor for StringUtils utility class.
     */
    private StringUtils() {
        // Default constructor.
    }

    /**
     * Limits an input string.
     *
     * @param input    input string.
     * @param maxChars max characters to limit result.
     * @return string limited.
     */
    public static String limitString(final String input, final int maxChars) {
        return input.substring(BEGIN_INDEX, maxChars);
    }
}
