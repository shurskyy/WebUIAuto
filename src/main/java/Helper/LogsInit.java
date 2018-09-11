package Helper;

import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Level;

public class LogsInit {
    private LoggingPreferences loggingPreferences;

    public LogsInit() {
        loggingPreferences = new LoggingPreferences();
    }

    public LoggingPreferences getLoggingPreferences() {
        return loggingPreferences;
    }

    public DesiredCapabilities initializeCapabilities(LoggingPreferences loggingPreferences) {
        loggingPreferences.enable(LogType.BROWSER, Level.OFF);
        loggingPreferences.enable(LogType.CLIENT, Level.OFF);
        loggingPreferences.enable(LogType.DRIVER, Level.OFF);
        loggingPreferences.enable(LogType.PERFORMANCE, Level.OFF);
        loggingPreferences.enable(LogType.PROFILER, Level.OFF);
        loggingPreferences.enable(LogType.SERVER, Level.OFF);
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
        desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);
        return desiredCapabilities;
    }
}
