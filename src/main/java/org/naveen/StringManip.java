package org.naveen;

import java.util.Arrays;

public class StringManip {
    public static void main(String[] args) {
        int[] input = {1, 1, 2, 1, 2, 4, 2, 3, 7, 8, 9, 1, 2,};
        int[] res = new int[]{};
        int currStart = 0, currLen = 1, bestStart = 0, bestLen = 1;
        for (int i = 1; i < input.length; i++) {
            if (input[i] > input[i - 1]) {
                currLen++;
            } else {
                if (currLen > bestLen) {
                    bestLen = currLen;
                    bestStart = currStart;
                }
                currStart = i;
                currLen = 1;
            }
        }
        if (currLen > bestLen) {
            bestLen = currLen;
            bestStart = currStart;
        }
        int[] longest = Arrays.copyOfRange(input, bestStart, bestStart + bestLen);

        for (int i : longest) {
            System.out.print(i + "\t");
        }


    }

}
