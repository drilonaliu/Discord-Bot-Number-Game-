package com.example;

public class Guess {

    private int guessNumber;
    private int magicNumberLength;

    Guess(int guessNumber, int magicNumberLength) {
        this.guessNumber = guessNumber;
        this.magicNumberLength = magicNumberLength;
    }

    public boolean hasCorrectLength() {
        String numStr = guessNumber + "";
        return (magicNumberLength == numStr.length());
    }

    public boolean hasRepeatedDigits() {
        int[] digits = extractDigits();
        boolean flag = false;
        for (int i = 0; i < digits.length - 1; i++) {
            for (int j = i + 1; j < digits.length; j++) {
                if (digits[i] == digits[j]) {
                    i = digits.length;
                    j = digits.length;
                    flag = true;
                }
            }
        }
        return flag;
    }

    public int[] extractDigits() {
        int[] digits = new int[magicNumberLength];
        String[] digits_string = String.valueOf(guessNumber).split("");
        for (int i = 0; i < digits_string.length; i++) {
            digits[i] = Integer.valueOf(digits_string[i]);
        }
        return digits;
    }

}
