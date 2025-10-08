package com.lld.logger.handler;

import com.lld.logger.model.LogLevel;
import com.lld.logger.model.LogMessage;
import com.lld.logger.service.Formatter;

public class ConsoleLogHandler extends LogHandler{
    public ConsoleLogHandler(LogLevel level, Formatter formatter) {
       super(level,formatter);
    }

    @Override
    protected void write(LogMessage log) {
        System.out.println(formatter.format(log));
        //System.out.println("Console: [" + log.getLogLevel().getLevel() + "] " + log.getMessage());
    }
}
