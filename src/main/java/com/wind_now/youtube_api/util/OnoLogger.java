/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wind_now.youtube_api.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import lombok.Getter;

public class OnoLogger {

    protected static final String LOGGING_CONFIG_STRING
            = "handlers=java.util.logging.ConsoleHandler, java.util.logging.FileHandler\n"
            + ".level=INFO\n"
            + "java.util.logging.ConsoleHandler.level=INFO\n"
            + "java.util.logging.ConsoleHandler.formatter=java.util.logging.SimpleFormatter\n"
            + "java.util.logging.FileHandler.pattern=ono%u.log\n"
            + "java.util.logging.FileHandler.append=true\n"
            + "java.util.logging.FileHandler.formatter=java.util.logging.SimpleFormatter\n"
            + "java.util.logging.FileHandler.encoding=UTF-8\n";

    @Getter
    private static Logger logger = null;

    static {
        try {
            LogManager.getLogManager().readConfiguration(
                    new ByteArrayInputStream(LOGGING_CONFIG_STRING.getBytes("UTF-8")));
            logger = Logger.getLogger(OnoLogger.class.getName());
        } catch (IOException | SecurityException e) {
            e.printStackTrace();
        }
    }
}
