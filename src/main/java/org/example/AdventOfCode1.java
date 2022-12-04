package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class AdventOfCode1 {
    public static void main(String[] args) {
        //System.out.println(calorieCounting());
        System.out.println(AdventOfCode3.rucksackReorganization());
    }

    /*  Day 1. Part 2.
        Find the top three Elves carrying the most Calories. How many Calories are those Elves carrying in total?
     */
    private static int calorieCounting(){
        String data = FileHelper.readFileAsString("src/main/java/org/example/calories.txt");

        return Arrays.stream(data.trim().split("\\n\\s"))
                .mapToInt(column -> Arrays.stream(column.split("\n"))
                        .filter(line -> !line.isEmpty())
                        .mapToInt(number -> Integer.parseInt(number.trim()))
                        .sum())
                .boxed()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .mapToInt(Integer::intValue)
                .sum();
    }

}