package org.example;

import java.util.Arrays;

/*
    Part 1.
    How many characters need to be processed before the first start-of-packet marker is detected?
    Part 2.
    How many characters need to be processed before the first start-of-message marker is detected?
 */
public class AdventOfCode6 {

    private static final String path = "src/main/resources/packet.txt";

    public static void startOfPacket(){
        String packet = FileHelper.readFileAsString(path);

        int startOfPacket = startOfSequence(packet, 4);
        int startOfMessage = startOfSequence(packet.substring(--startOfPacket), 14) + startOfPacket;

        System.out.println("Start of packet: " + startOfPacket + "\nStart of message: " + startOfMessage);
    }

    private static int startOfSequence(String input, int range){
        if(input.length() < range + 1) return -1;

        for (int i = 0; i < input.length() - range; i++){
            String subString = input.substring(i, i + range);

            boolean isAllUnique = Arrays.stream(subString.split(""))
                    .distinct()
                    .count() == subString.length();

            if(isAllUnique){
                return i + range;
            }
        }
        return -1;
    }
}
