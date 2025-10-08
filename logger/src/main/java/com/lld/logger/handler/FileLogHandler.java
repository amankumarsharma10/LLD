package com.lld.logger.handler;

import com.lld.logger.model.LogLevel;
import com.lld.logger.model.LogMessage;
import com.lld.logger.service.Formatter;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogHandler extends LogHandler{
    private final String filename;

    public FileLogHandler(String filename,LogLevel logLevel, Formatter formatter) throws IOException {
        super(logLevel, formatter);
        this.filename = filename;
    }

    @Override
    protected void write(LogMessage log) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(formatter.format(log) + System.lineSeparator());
            writer.flush();
           // writer.write("File: [" + log.getLogLevel().getLevel() + "] " + log.getMessage() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
