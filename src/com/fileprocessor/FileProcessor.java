
package com.fileprocessor;

import java.util.concurrent.atomic.AtomicInteger;

public class FileProcessor {
    private AtomicInteger totalLines = new AtomicInteger(0);
    private AtomicInteger totalWords = new AtomicInteger(0);
    private AtomicInteger totalCharacters = new AtomicInteger(0);

    public void addResult(int lines, int words, int characters) {
        totalLines.addAndGet(lines);
        totalWords.addAndGet(words);
        totalCharacters.addAndGet(characters);
    }

    public void printSummary() {
        System.out.println("Processing Summary:");
        System.out.println("Total Lines: " + totalLines);
        System.out.println("Total Words: " + totalWords);
        System.out.println("Total Characters: " + totalCharacters);
    }
}
