package github.automation.config;

import github.automation.webdriver.DriverTypes;

import java.util.Objects;

/**
 * Defines methods to read environment config variables.
 */
public final class Environment {

    private static final String PROP_FILE = "gradle.properties";
    private static final String BROWSER = "browser";
    private static final String DRIVER_VERSION = "driverVersion";
    private static final String IMPLICIT_TIME_WAIT = "implicitTimeWait";
    private static final String EXPLICIT_TIME_WAIT = "explicitTimeWait";
    private static final String HOME_URL = "homeUrl";
    private static final String RAW_CONTENT_URL_FORMAT = "rawContentUrlFormat";
    private static Environment instance;

    private final PropReader propReader;

    /**
     * Private constructor for {@link Environment} utility class.
     */
    private Environment() {
        propReader = new PropReader(PROP_FILE);
    }

    /**
     * Initializes singleton instance of {@link Environment}.
     *
     * @return singleton instance.
     */
    public static synchronized Environment config() {
        if (Objects.isNull(instance)) {
            instance = new Environment();
        }
        return instance;
    }

    /**
     * Gets browser configuration value.
     *
     * @return browser configuration value.
     */
    public DriverTypes getBrowser() {
        return DriverTypes.valueOf(propReader.getEnv(BROWSER).toUpperCase());
    }

    /**
     * Gets driver version value.
     *
     * @return driver version.
     */
    public String getDriverVersion() {
        return propReader.getEnv(DRIVER_VERSION);
    }

    /**
     * Gets home url for portal.
     *
     * @return home url.
     */
    public String getHomeUrl() {
        return propReader.getEnv(HOME_URL);
    }

    /**
     * Gets raw content url format.
     *
     * @return raw content url format.
     */
    public String getRawContentUrlFormat() {
        return propReader.getEnv(RAW_CONTENT_URL_FORMAT);
    }

    /**
     * Gets implicit time wait configuration value.
     *
     * @return implicit time wait value.
     */
    public int getImplicitTimeWait() {
        return Integer.parseInt(propReader.getEnv(IMPLICIT_TIME_WAIT));
    }

    /**
     * Gets explicit  time wait configuration value.
     *
     * @return explicit time wait.
     */
    public int getExplicitTimeWait() {
        return Integer.parseInt(propReader.getEnv(EXPLICIT_TIME_WAIT));
    }
}
