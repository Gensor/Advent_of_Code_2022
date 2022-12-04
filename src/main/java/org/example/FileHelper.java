package org.example;

import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileHelper {
    public static String readFileAsString(String path){
        String data;
        try {
            data = FileUtils.fileRead(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }


    public static List<String> readFileAsListOfRows(String path){
        String fileContent = readFileAsString(path);
        return fileContent.isEmpty() ? Collections.emptyList() : Arrays.stream(fileContent.split("\n"))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static List<List<String>> readFileAsListOfCharListsWithoutEmpty(List<String> path){
        return path.isEmpty() ? Collections.emptyList() : path.stream()
                .map(line -> Arrays.stream(line.split("")).filter(chr -> !chr.isEmpty()).collect(Collectors.toList()))
                .collect(Collectors.toList());
    }


}
