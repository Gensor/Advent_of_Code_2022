package org.example;

import java.util.Arrays;
import java.util.List;

/*  Day 3. Part 1.
    Find the item type that appears in both compartments of each rucksack. What is the sum of the priorities of those item types?
 */
public class AdventOfCode3 {
    private static String compartment2 = "";

    public static int rucksackReorganization(){
        List<String> rucksacks = FileHelper.readFileAsListOfRows("src/main/java/org/example/rucksack.txt");
        int result = 0;
        for (String rucksack : rucksacks) {
            String compartment1 = rucksack.substring(0,rucksack.length()/2);
            compartment2 = rucksack.substring(rucksack.length()/2);

            result += Arrays.stream(compartment1.split(""))
                    .mapToInt(type -> containsPair(type, compartment2))
                    .sum();
        }
        return result;
    }

    private static int containsPair(String type, String comp){
        if(comp.contains(type)){
            compartment2 = comp.replace(type,"");
            char c = type.charAt(0);
            return (c < 96) ? c - 38 : c - 96;
        }
        return 0;
    }
}
