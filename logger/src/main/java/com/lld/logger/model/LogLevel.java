package com.lld.logger.model;

public enum LogLevel {
    ERROR(1), INFO(2), DEBUG(3);
    private final int level;
    LogLevel(int level) { this.level = level; }
    public int getLevel() { return level; }
}
