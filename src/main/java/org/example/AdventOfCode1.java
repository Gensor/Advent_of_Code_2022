package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AdventOfCode1 {
    public static void main(String[] args) {
        System.out.println(calorieCounting());

    }

    /*  Day 1.
        Find the top three Elves carrying the most Calories. How many Calories are those Elves carrying in total?
     */
    private static int calorieCounting(){
        String data = FileHelper.readFileAsString("src/main/java/org/example/calories.txt");

        int top3sum = Arrays.stream(data.trim().split("\\n\\s"))
                .mapToInt(column -> Arrays.stream(column.split("\n"))
                        .filter(line -> !line.isEmpty())
                        .mapToInt(number -> Integer.parseInt(number.trim()))
                        .sum())
                .boxed()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .mapToInt(Integer::intValue)
                .sum();

        return top3sum;
    }

    private static void rockPaperScissors(){
        //List<List>
    }

    private static int rockPaperScissors(String a, String b){
        int player1 = switch (a){
            case "A" -> 5;
            case "B" -> 10;
            case "C" -> 15;
            default -> 0;
        };

        int player2 = switch (b){
            case "X" -> 5;
            case "Y" -> 10;
            case "Z" -> 15;
            default -> 0;
        };
        return  player1;
    }



}