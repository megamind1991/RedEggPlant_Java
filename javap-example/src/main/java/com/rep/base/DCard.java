package com.rep.base;

import java.security.SecureRandom;

public class DCard {
    // execute application
    public static void main(String[] args) {// w w w. j a v a 2 s . c o m
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle(); // place Cards in random order

        // print all 52 Cards in the order in which they are dealt
        for (int i = 1; i <= 52; i++) {
            // deal and display a Card
            System.out.printf("%-19s", myDeckOfCards.dealCard());

            if (i % 4 == 0) // output a newline after every fourth card
                System.out.println();
        }
    }
}

class Card {
    private final String face; // face of card ("Ace", "Deuce", ...)

    private final String suit; // suit of card ("Hearts", "Diamonds", ...)

    // two-argument constructor initializes card's face and suit
    public Card(String face, String suit) {
        this.face = face;
        this.suit = suit;
    }

    // return String representation of Card
    public String toString() {
        return face + " of " + suit;
    }
}

class DeckOfCards {
    private Card[] deck; // array of Card objects

    private int currentCard; // index of next Card to be dealt (0-51)

    private static final int NUMBER_OF_CARDS = 52; // constant # of Cards
    // random number generator

    private static final SecureRandom randomNumbers = new SecureRandom();

    // constructor fills deck of Cards
    public DeckOfCards() {
        String[] faces = {
            "Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"
        };
        String[] suits = {
            "Hearts", "Diamonds", "Clubs", "Spades"
        };

        deck = new Card[NUMBER_OF_CARDS]; // create array of Card objects
        currentCard = 0; // first Card dealt will be deck[0]

        // populate deck with Card objects
        for (int count = 0; count < deck.length; count++)
            deck[count] = new Card(faces[count % 13], suits[count / 13]);
    }

    public void shuffle() {
        currentCard = 0;
        for (int first = 0; first < deck.length; first++) {
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        }
    }

    public Card dealCard() {
        if (currentCard < deck.length)
            return deck[currentCard++]; // return current Card in array
        else
            return null;
    }
}