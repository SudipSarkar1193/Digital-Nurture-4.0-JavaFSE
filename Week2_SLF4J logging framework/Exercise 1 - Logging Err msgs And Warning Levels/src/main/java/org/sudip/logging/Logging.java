package org.sudip.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Logging {
    private static final Logger logger = LoggerFactory.getLogger(Logging.class);
    public static void main(String[] args) {
        logger.error("This is an error message");
        logger.warn("This is a warning message");
    }
} 