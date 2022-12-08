package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class AdventOfCode1 {
    public static void main(String[] args) {
        //calorieCounting();
        //AdventOfCode3.rucksackReorganization();
        //AdventOfCode4.campCleanUp();
        AdventOfCode6.startOfPacket();
    }

    /*
        Part 2.
        Find the top three Elves carrying the most Calories. How many Calories are those Elves carrying in total?
     */
    private static void calorieCounting(){
        String data = FileHelper.readFileAsString("src/main/resources/calories.txt");

        int result = Arrays.stream(data.trim().split("\\n\\s"))
                .mapToInt(column -> Arrays.stream(column.split("\n"))
                        .filter(line -> !line.isEmpty())
                        .mapToInt(number -> Integer.parseInt(number.trim()))
                        .sum())
                .boxed()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(result);
    }

}