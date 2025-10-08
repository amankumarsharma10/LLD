package com.lld.logger.service;

import com.lld.logger.model.LogLevel;
import com.lld.logger.handler.ConsoleLogHandler;
import com.lld.logger.handler.FileLogHandler;
import com.lld.logger.handler.LogHandler;

import java.io.InputStream;
import java.util.Properties;

public class LoggerFactory {
    private static final String PROPERTIES_FILE = "logging.properties";

    public static Logger getLogger(String loggerName) throws Exception {
        Properties props = new Properties();
        try (InputStream is = LoggerFactory.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (is == null) {
                throw new IllegalStateException("Missing " + PROPERTIES_FILE + " in classpath");
            }
            props.load(is);
        }
        Formatter simpleFormatter = r -> String.format("%s [%s] %s %n%s", r.getTimestamp(), r.getLogLevel(), r.getMessage()
                , formatThrowable(r.getThrowable()));
        LogHandler firstHandler  = null;
        LogHandler lastHandler = null;

        // Console handler
        if (Boolean.parseBoolean(props.getProperty("logger.console.enabled", "true"))) {
            LogLevel consoleLevel = LogLevel.valueOf(props.getProperty("logger.console.level", "INFO"));
            ConsoleLogHandler consoleHandler = new ConsoleLogHandler(consoleLevel, simpleFormatter);
            firstHandler  = consoleHandler;
            lastHandler  = consoleHandler;
        }

        // File handler
        if (Boolean.parseBoolean(props.getProperty("handler.file.enabled", "true"))) {
            LogLevel fileLogLevel = LogLevel.valueOf(props.getProperty("handler.file.level", "INFO"));
            String filePath = props.getProperty("handler.file.path", "app.log");
            FileLogHandler fileHandler = new FileLogHandler(filePath, fileLogLevel, simpleFormatter);

            if (firstHandler  == null) firstHandler  = fileHandler;
            else lastHandler .setNext(fileHandler);

            lastHandler = fileHandler;
        }

        // Default console if no handler enabled
        if (firstHandler == null) firstHandler = new ConsoleLogHandler(LogLevel.DEBUG, simpleFormatter);


        return new Logger(loggerName,firstHandler);
    }

    private static String formatThrowable(Throwable t) {
        if (t == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(t.toString()).append(System.lineSeparator());
        for (StackTraceElement e : t.getStackTrace()) {
            sb.append("\tat ").append(e).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
