package org.example;

import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileHelper {
    public static String readFileAsString(String filePathFromContentRoot){
        String data = "";
        try {
            data = FileUtils.fileRead(filePathFromContentRoot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
    public static List<String> readFileAsListOfRows(String filePathFromContentRoot){
        return getLineArray(readFileAsString(filePathFromContentRoot));
    }

    private static List<String> getLineArray(String input){
        return input.isEmpty() ? Collections.emptyList() : Arrays.stream(input.split("\n"))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static List<List<String>> readFileAsListOfCharListsWithoutEmpty(List<String> input){
        return input.isEmpty() ? Collections.emptyList() : input.stream()
                .map(line -> Arrays.stream(line.split("")).filter(chr -> !chr.isEmpty()).collect(Collectors.toList()))
                .collect(Collectors.toList());
    }


}
