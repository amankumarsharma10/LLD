package com.lld.logger;

import com.lld.logger.handler.ConsoleLogHandler;
import com.lld.logger.handler.LogHandler;
import com.lld.logger.service.Logger;
import com.lld.logger.service.LoggerFactory;

/**
 * Hello world!
 *
 */
public class LoggerDemo
{
    public static void main(String[] args) throws Exception {
        Logger logger = LoggerFactory.getLogger("MyApp");

        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.error("This is an error message",new RuntimeException("This is an error exception"));
    }
}
