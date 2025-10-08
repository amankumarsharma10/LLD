package com.lld.logger.model;

import java.time.LocalDateTime;

public class LogMessage {
    final LogLevel logLevel;
    final String loggerName;
    final String message;
    final Throwable throwable;
    final LocalDateTime timestamp;

    public LogMessage(LogLevel logLevel, String loggerName, String message, Throwable throwable) {
        this.logLevel = logLevel;
        this.loggerName = loggerName;
        this.message = message;
        this.throwable = throwable;
        this.timestamp = LocalDateTime.now();
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public String getLoggerName() {
        return loggerName;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
