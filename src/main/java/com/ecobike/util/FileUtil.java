package com.ecobike.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileUtil {
    public static List<String> read(String path) {
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from: " + path);
        }
    }

    public static void write(String path, List<String> list) {
        try {
            Files.write(Paths.get(path), list);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to: " + path);
        }
    }

    public static void writeAppend(String path, List<String> list) {
        try {
            Files.write(Paths.get(path), list, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to: " + path);
        }
    }
}
