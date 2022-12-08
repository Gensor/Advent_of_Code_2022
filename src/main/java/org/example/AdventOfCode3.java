package org.example;

import java.util.Arrays;
import java.util.List;

/*
    Part 1.
    Find the item type that appears in both compartments of each rucksack.
    What is the sum of the priorities of those item types?
    Part 2.
    Find the item type that corresponds to the badges of each three-Elf group.
    What is the sum of the priorities of those item types?
 */
public class AdventOfCode3 {
    private final static String path = "src/main/resources/rucksack.txt";
    public static void rucksackReorganization(){
        List<String> rucksacks = FileHelper.readFileAsListOfRows(path);
        int result = 0;
        for (String rucksack : rucksacks) {
            String compartment1 = rucksack.substring(0,rucksack.length()/2);
            String compartment2 = rucksack.substring(rucksack.length()/2);

            result += Arrays.stream(compartment1.split(""))
                    .mapToInt(type -> containsPair(type, compartment2))
                    .filter( x -> x>0)
                    .findFirst().orElse(0);

        }

        //Start Part2
            String[][] groupOf3List = FileHelper.readFileAsListOf3Rows(path);
            int result2 = 0;
            for(String [] group : groupOf3List){
                String rucksack1 = group[0];
                String rucksack2 = group[1];
                String rucksack3 = group[2];
                result2 += Arrays.stream(rucksack1.split(""))
                        .mapToInt( type -> containsPair(type,rucksack2,rucksack3))
                        .filter( x -> x > 0)
                        .findFirst().orElse(0);
            }
            System.out.println("Part2: " + result2);
        //End Part2

        System.out.println("Part1: " + result);
    }

    private static int containsPair(String type, String comp){
        if(comp.contains(type)){
            char c = type.charAt(0);
            return (c < 96) ? c - 38 : c - 96;
        }
        return 0;
    }

    private static int containsPair(String type, String comp1, String comp2){
        if(comp1.contains(type) && comp2.contains(type)){
            char c = type.charAt(0);
            return (c < 96) ? c - 38 : c - 96;
        }
        return 0;
    }
}
