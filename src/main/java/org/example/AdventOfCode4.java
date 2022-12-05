package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AdventOfCode4 {
    private static final String path = "src/main/resources/campCleanUp.txt";
    /*
        Part1.
        In how many assignment pairs does one range fully contain the other?
        Part2.
        In how many assignment pairs do the ranges overlap?
     */
    public static void campCleanUp(){
        List<String> listOfPairs = FileHelper.readFileAsListOfRows(path);

        List<String[]> pairs = listOfPairs.stream().map( x -> x.split(",")).collect(Collectors.toList());
        int result = 0;
        int result2 = 0;

        for (String [] pair : pairs){
            int []first = Arrays.stream(pair[0].split("-")).mapToInt(Integer::parseInt).toArray();
            int []second = Arrays.stream(pair[1].split("-")).mapToInt(Integer::parseInt).toArray();
            //Part1
            if((first[0] >= second[0] && first[1] <= second[1]) || (second[0] >= first[0] && second[1] <= first[1]) ){
                result++;
            }
            //Part2
            if(((first[0] >= second[0]) && (first[0] <= second[1])) || ((second[0] >= first[0]) && (second[0] <= first[1]))){
                result2++;
            }
        }
        System.out.println("Part1: " + result + "\nPart2: " + result2);
    }
}
