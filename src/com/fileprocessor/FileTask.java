
package com.fileprocessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.logging.Logger;

public class FileTask implements Runnable {
    private String filePath;
    private FileProcessor processor;
    private static final Logger logger = Logger.getLogger(FileTask.class.getName());

    public FileTask(String filePath, FileProcessor processor) {
        this.filePath = filePath;
        this.processor = processor;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            logger.info("Processing file: " + filePath);
            int lines = 0;
            int words = 0;
            int characters = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                lines++;
                characters += line.length();
                words += line.split("\s+").length;
            }
            processor.addResult(lines, words, characters);
            logger.info("Completed processing: " + filePath);
        } catch (Exception e) {
            logger.severe("Error processing file: " + filePath + " - " + e.getMessage());
        }
    }
