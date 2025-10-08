package com.lld.logger.service;

import com.lld.logger.model.LogMessage;

public interface Formatter {
    String format(LogMessage r);
}
