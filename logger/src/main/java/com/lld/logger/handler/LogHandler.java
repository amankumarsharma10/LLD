package com.lld.logger.handler;

import com.lld.logger.model.LogLevel;
import com.lld.logger.model.LogMessage;
import com.lld.logger.service.Formatter;

public abstract class LogHandler {

    protected LogLevel logLevel;
    protected Formatter formatter;
    protected LogHandler next;

    public LogHandler(LogLevel logLevel, Formatter formatter) {
        this.logLevel = logLevel;
        this.formatter = formatter;
    }

    public void setNext(LogHandler next) {
        this.next = next;
    }

    public void handle(LogMessage log) {
        if (log.getLogLevel().getLevel() <= logLevel.getLevel()) {
            write(log);
        }
        if (next != null) {
            next.handle(log);  // <-- Chain of Responsibility: forwards log
        }
    }

    protected abstract void write(LogMessage log);
}
