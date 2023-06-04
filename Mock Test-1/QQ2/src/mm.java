//package com.java2s;

public class mm {
    public static void main(String[] argv) {
        String inputString = "loveleetcode";
        System.out.println(getFirstNonRepeatingCharacter(inputString));
    }

    public static char getFirstNonRepeatingCharacter(
            final String inputString) {
        int count[] = new int[256];
        char inputChar[] = inputString.toCharArray();
        for (char c : inputChar) {
            count[(int) c]++;
        }

        for (char c : inputChar) {
            if (count[(int) c] == 1) {
                return c;
            }
        }
        return ' ';
    }
}