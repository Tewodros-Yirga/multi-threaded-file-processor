
package com.fileprocessor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class FileProcessorApp {
    private static final Logger logger = Logger.getLogger(FileProcessorApp.class.getName());

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a directory or file paths as arguments.");
            return;
        }

        FileProcessor processor = new FileProcessor();
        ExecutorService executorService = Executors.newFixedThreadPool(4);  // 4 threads
        List<String> filesToProcess = new ArrayList<>();

        // Gather files from arguments
        for (String arg : args) {
            File file = new File(arg);
            if (file.isDirectory()) {
                for (File subFile : file.listFiles()) {
                    if (subFile.isFile()) {
                        filesToProcess.add(subFile.getAbsolutePath());
                    }
                }
            } else if (file.isFile()) {
                filesToProcess.add(file.getAbsolutePath());
            }
        }

        // Start file tasks
        for (String filePath : filesToProcess) {
            executorService.execute(new FileTask(filePath, processor));
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            // Wait for all tasks to finish
        }

        // Print the summary once all files are processed
        processor.printSummary();
    }
}
