package com.rep.base;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class RandomTest {

    public static void main(String[] args) {
        // Create a new instance of the Random class
        Random random = new Random();
        System.out.println("Random: " + random);

        // Generates a random Integer
        int myInt = random.nextInt();
        System.out.println("Random int: " + myInt);

        // Generates a random Double value
        double myDouble = random.nextDouble();
        System.out.println("Random double: " + myDouble);

        // Generates a random float
        float myFloat = random.nextFloat();
        System.out.println("Random float: " + myFloat);

        // Generates a random Gaussian double
        // mean 0.0 and standard deviation 1.0
        double gausDouble = random.nextGaussian();
        System.out.println("Random Gaussian double: " + gausDouble);

        // Generates a random Long
        long myLong = random.nextLong();
        System.out.println("Random long: " + myLong);

        // Generates a random boolean
        boolean myBoolean = random.nextBoolean();
        System.out.println("Random boolean: " + myBoolean);

        double rand = Math.random();
        System.out.println("Random double via Math: " + rand);

        // randomNumbers object will produce secure random numbers
        SecureRandom randomNumbers = new SecureRandom();

        // loop 20 times
        for (int counter = 1; counter <= 20; counter++) {
            // pick random integer from 1 to 6
            int face = 1 + randomNumbers.nextInt(6);

            System.out.printf("%d  ", face); // display generated value

            // if counter is divisible by 5, start a new line of output
            if (counter % 5 == 0)
                System.out.println();
        }


        // randomNumbers object will produce secure random numbers
        randomNumbers = new SecureRandom();

        int frequency1 = 0; // count of 1s rolled
        int frequency2 = 0; // count of 2s rolled
        int frequency3 = 0; // count of 3s rolled
        int frequency4 = 0; // count of 4s rolled
        int frequency5 = 0; // count of 5s rolled
        int frequency6 = 0; // count of 6s rolled

        // tally counts for 6,000,000 rolls of a die
        for (int roll = 1; roll <= 6000000; roll++) {
            int face = 1 + randomNumbers.nextInt(6); // number from 1 to 6

            // use face value 1-6 to determine which counter to increment
            switch (face) {
                case 1:
                    ++frequency1; // increment the 1s counter
                    break;
                case 2:
                    ++frequency2; // increment the 2s counter
                    break;
                case 3:
                    ++frequency3; // increment the 3s counter
                    break;
                case 4:
                    ++frequency4; // increment the 4s counter
                    break;
                case 5:
                    ++frequency5; // increment the 5s counter
                    break;
                case 6:
                    ++frequency6; // increment the 6s counter
                    break;
            }
        }

        System.out.println("Face\tFrequency"); // output headers
        System.out.printf("1\t%d%n2\t%d%n3\t%d%n4\t%d%n5\t%d%n6\t%d%n",
                frequency1, frequency2, frequency3, frequency4,
                frequency5, frequency6);

        // w ww  .j a v a  2 s. c o  m
        /*
         * This method returns a positive double value greater than 0.0
         * and less than 1.0
         */

        System.out.println("Random numbers between 0.0 and 1.0 are,");
        for (int i = 0; i < 5; i++)
            System.out.println("Random Number [" + (i + 1) + "] : " + Math.random());

        /*
         * To generate random number between 1 to 100 use following code
         */

        System.out.println("Random numbers between 1 and 100 are,");
        for (int i = 0; i < 5; i++)
            System.out.println("Random Number [" + (i + 1) + "] : " + (int) (Math.random() * 100));

        try {/*  www  .j av  a  2 s . c  o  m*/
            // Create a secure random number generator
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");

            // Get 1024 random bits
            byte[] bytes = new byte[1024 / 8];
            sr.nextBytes(bytes);

            // Create two secure number generators with the same seed
            int seedByteCount = 10;
            byte[] seed = sr.generateSeed(seedByteCount);

            sr = SecureRandom.getInstance("SHA1PRNG");
            sr.setSeed(seed);
            SecureRandom sr2 = SecureRandom.getInstance("SHA1PRNG");
            sr2.setSeed(seed);
        } catch (NoSuchAlgorithmException e) {
        }

        int roll;
        String msg = "Here are 100 random rolls of the dice:";
        System.out.println(msg);
        for (int i = 0; i < 100; i++) {
            roll = randomInt(1, 6);
            System.out.print(roll + " ");
        }
        System.out.println();
    }//from  w  w  w . j  a  v  a 2s .  co m


    public static int randomInt(int low, int high) {
        int result = (int) (Math.random()
                * (high - low + 1)) + low;
        return result;
    }

}