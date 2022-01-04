package github.automation.pages.fields;

/**
 * Defines search fields enum.
 */
public enum SearchFields {

    LANGUAGE("Written in this language"),
    STATE("In the state"),
    STARS("With this many stars"),
    FOLLOWERS("With this many followers"),
    LICENSE("With this license");

    private final String displayText;

    /**
     * Initializes SearchFields enum constants.
     *
     * @param displayText display text in UI.
     */
    SearchFields(final String displayText) {
        this.displayText = displayText;
    }

    /**
     * Gets corresponding display text for constant.
     *
     * @return display text.
     */
    public String getDisplayText() {
        return displayText;
    }
}
