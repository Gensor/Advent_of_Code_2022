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

    public static String[][] readFileAsListOf3Rows(String path){
        List <String> allRows = readFileAsListOfRows(path);
        String [][] listOf3 = new String[allRows.size()/3][3];

        int y = 0;
        for(int i =0; i < allRows.size(); i++){
            if(i%3 == 2){
                listOf3[y][2] = allRows.get(i);
                y++;
                continue;
            }
            listOf3[y][i%3] = allRows.get(i);
        }

        return listOf3;
    }

}
