package com.test;

import java.io.File;
import java.util.logging.Logger;

public class FileInspector {
    private static final Logger logger = Logger.getLogger(FileInspector.class.getName());

    public static void inspectDirectory(String path) {
        File dir = new File(path);
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            logger.info("Looking in '%s':".formatted(path));
            if (files != null) {
                for (File file : files) {
                    logger.info("Found: " + file.getAbsolutePath() + " (isDirectory: " + file.isDirectory() + ")");
                }
            } else {
                logger.warning("No files found in directory: " + path);
            }
        } else {
            logger.warning("Directory does not exist: " + path);
        }
    }
}
