
/**
 * Game Model Class for generating the magic number and evaluating guess.
 * 
 */

package com.example;

import java.util.ArrayList;

public class GameModel {

    private int n;
    private int[] magicNumber = new int[n];
    private ArrayList<Integer> digits = new ArrayList<>(9);

    /**
     * Generates a random number of length n with no repetition of digits.
     */
    public void generateMagicNumber() {
        resetDigits();
        for (int i = 0; i < n; i++) {
            int randomIndex = (int) (Math.random() * digits.size());
            int randomDigit = digits.get(randomIndex);
            magicNumber[i] = randomDigit;
            digits.remove(randomIndex);
        }
    }

    /**
     * @param guessNumber - the guess of the player
     * @return - an array of length two, first element gives numQelluar, the second
     *         one numFiksuar
     */
    public int[] evaluateGuess(Guess userGuess) {
        int[] guessNumber = userGuess.extractDigits();
        int numFiksuar = 0;
        int numQelluar = 0;
        for (int i = 0; i < guessNumber.length; i++) {
            for (int j = 0; j < magicNumber.length; j++) {
                if (guessNumber[i] == magicNumber[j]) {
                    if (i == j) {
                        numFiksuar += 1;
                    } else {
                        numQelluar += 1;
                    }
                }
            }
        }
        return new int[] { numQelluar, numFiksuar };
    }

    /**
     * Fills the digits array with numbers from 1 to 10.
     */
    private void resetDigits() {
        digits.clear();
        for (int i = 1; i <= 9; i++) {
            digits.add(i);
        }
    }

    /**
     * Set the length of the magic number.
     * 
     * @param n - length of magic number
     */
    public void setLength(int n) {
        this.n = n;
        magicNumber = new int[n];
    }

    /**
     * @return the length of the magic number.
     */
    public int getLength() {
        return n;
    }

    /**
     * @return the magic number as a string.
     */
    public String getMagicNumber() {
        String num = "";
        for (int i = 0; i < magicNumber.length; i++) {
            num = num + magicNumber[i];
        }
        return num;
    }

    /**
     * Prints the magic number.
     */
    public void printNumber() {
        String num = "";
        for (int i = 0; i < magicNumber.length; i++) {
            num = num + magicNumber[i];
        }
        System.out.println(num);
    }

}