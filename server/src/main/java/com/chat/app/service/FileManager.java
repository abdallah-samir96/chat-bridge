package com.chat.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class FileManager {

    private final static Logger logger = LoggerFactory.getLogger(FileManager.class);
    public static String upload(String basePath, byte[] file, String extension) {
        var fileName = UUID.randomUUID().toString() + "." + extension;
        var path = Path.of(basePath, fileName);
        try {
            var filePath = Files.write(path, file);
            return filePath.toString();
        }catch (IOException e) {
            logger.error("Exception when trying to upload file: {}", e.getMessage() );
            throw new RuntimeException(e);
        }
    }
}
