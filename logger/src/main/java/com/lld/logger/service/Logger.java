package com.lld.logger.service;

import com.lld.logger.model.LogLevel;
import com.lld.logger.handler.LogHandler;
import com.lld.logger.model.LogMessage;

public class Logger {
    private final String loggerName;
    private final LogHandler firstHandler;

    public Logger(String loggerName, LogHandler firstHandler) {
        this.loggerName = loggerName;
        this.firstHandler = firstHandler;
    }


    public void debug(String msg) { log(LogLevel.DEBUG, msg,null); }
    public void info(String msg) { log(LogLevel.INFO, msg,null); }
    public void error(String msg, Throwable t) { log(LogLevel.ERROR, msg, t); }

    private void log(LogLevel level, String msg, Throwable t) {
        firstHandler.handle(new LogMessage(level,loggerName, msg,t));
    }
}
