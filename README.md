
# Multi-threaded File Processor

This is a Java application that processes multiple files concurrently using multithreading. It reads files, counts the number of lines, words, and characters, and aggregates the results.

## Features:
- Multi-threaded file processing for fast performance.
- Aggregates results (total lines, words, characters).
- Command-line interface for ease of use.
- Built-in logging to monitor file processing.

## Usage:

### Compile
```bash
javac -d bin src/com/fileprocessor/*.java
```

### Run
```bash
java -cp bin com.fileprocessor.FileProcessorApp /path/to/directory
```

You can pass a directory or list of file paths for the program to process.

## Example:
```bash
java -cp bin com.fileprocessor.FileProcessorApp /path/to/file1.txt /path/to/file2.txt
```

## Logs:
Logs are automatically generated for each file processed.
