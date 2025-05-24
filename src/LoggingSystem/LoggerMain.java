package LoggingSystem;

import LoggingSystem.LogAppender.ConsoleAppender;
import LoggingSystem.LogAppender.FileAppender;

public class LoggerMain {
    public static void main(String[] args) {
        //use chain of resp pattern
        Logger logger = Logger.getInstance();
        logger.setAppender(new ConsoleAppender(new DefaultFormatter()));

        // Logging with default configuration
        logger.info("This is an information message");
        logger.warning("This is a warning message");
        logger.error("This is an error message");
        logger.fatal("This is an fatal message");
        logger.debug("This is an debug message");

        // Changing appender
        logger.setAppender(new FileAppender("app.log", new DefaultFormatter()));

        logger.debug("This is a debug message");
        logger.info("This is an information message");
    }
}
