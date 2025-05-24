package LoggingSystem;

import LoggingSystem.LogAppender.ConsoleAppender;
import LoggingSystem.LogAppender.LogAppender;

public class Logger {
    private static final Logger instance = new Logger(); // singleton
    private LogAppender logAppender;

    private Logger() {
        // Private constructor to enforce singleton pattern
    }

    public static Logger getInstance() {
        return instance;
    }

    public void setAppender(LogAppender appender) {
        this.logAppender = appender;
    }

    public void log(LogLevel level, String message) {
        LogMessage logMessage = new LogMessage(level, message);
        this.logAppender.append(logMessage);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warning(String message) {
        log(LogLevel.WARN, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void fatal(String message) {
        log(LogLevel.FATAL, message);
    }
}