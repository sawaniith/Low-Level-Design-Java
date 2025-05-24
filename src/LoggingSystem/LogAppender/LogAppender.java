package LoggingSystem.LogAppender;

import LoggingSystem.LogMessage;

public interface LogAppender {
    void append(LogMessage logMessage);
}
