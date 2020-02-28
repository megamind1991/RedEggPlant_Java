package com.rep.interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

interface SortFunction extends Function<Comparator<Card>, Deck> {
    public Deck apply(Comparator<Card> cardComparator);
}

class SortByRankThenSuit implements Comparator<Card> {
    public int compare(Card firstCard, Card secondCard) {
        int compVal = firstCard.getRank().value() - secondCard.getRank().value();
        if (compVal != 0)
            return compVal;
        else/* from w w w . ja v a2 s . c om */
            return firstCard.getSuit().value() - secondCard.getSuit().value();
    }
}

interface Deck {

    List<Card> getCards();

    Deck deckFactory();

    int size();

    void addCard(Card card);

    void addCards(List<Card> cards);

    void addDeck(Deck deck);

    void shuffle();

    void sort();

    void sort(Comparator<Card> c);

    String deckToString();

    Map<Integer, Deck> deal(int players, int numberOfCards) throws IllegalArgumentException;

}

interface Card extends Comparable<Card> {

    public enum Suit {
        DIAMONDS(1, "Diamonds"), CLUBS(2, "Clubs"), HEARTS(3, "Hearts"), SPADES(4, "Spades");

        private final int value;

        private final String text;

        Suit(int value, String text) {
            this.value = value;
            this.text = text;
        }

        public int value() {
            return value;
        }

        public String text() {
            return text;
        }
    }

    public enum Rank {
        DEUCE(2, "Two"), THREE(3, "Three"), FOUR(4, "Four"), FIVE(5, "Five"), SIX(6, "Six"), SEVEN(7, "Seven"), EIGHT(8,
            "Eight"), NINE(9,
                "Nine"), TEN(10, "Ten"), JACK(11, "Jack"), QUEEN(12, "Queen"), KING(13, "King"), ACE(14, "Ace");

        private final int value;

        private final String text;

        Rank(int value, String text) {
            this.value = value;
            this.text = text;
        }

        public int value() {
            return value;
        }

        public String text() {
            return text;
        }
    }

    public Card.Suit getSuit();

    public Card.Rank getRank();
}

class PlayingCard implements Card {

    private Card.Rank rank;

    private Card.Suit suit;

    public PlayingCard(Card.Rank rank, Card.Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Card.Suit getSuit() {
        return suit;
    }

    public Card.Rank getRank() {
        return rank;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Card) {
            if (((Card) obj).getRank() == this.rank && ((Card) obj).getSuit() == this.suit) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    public int hashCode() {
        return ((suit.value() - 1) * 13) + rank.value();
    }

    public int compareTo(Card o) {
        return this.hashCode() - o.hashCode();
    }

    public String toString() {
        return this.rank.text() + " of " + this.suit.text();
    }

    public static void main(String... args) {
        new PlayingCard(Rank.ACE, Suit.DIAMONDS);
        new PlayingCard(Rank.KING, Suit.SPADES);
    }
}

class StandardDeck implements Deck {

    private List<Card> entireDeck;

    public StandardDeck(List<Card> existingList) {
        this.entireDeck = existingList;
    }

    public StandardDeck() {
        this.entireDeck = new ArrayList<>();
        for (Card.Suit s : Card.Suit.values()) {
            for (Card.Rank r : Card.Rank.values()) {
                this.entireDeck.add(new PlayingCard(r, s));
            }
        }
    }

    public Deck deckFactory() {
        return new StandardDeck(new ArrayList<Card>());
    }

    public int size() {
        return entireDeck.size();
    }

    public List<Card> getCards() {
        return entireDeck;
    }

    public void addCard(Card card) {
        entireDeck.add(card);
    }

    public void addCards(List<Card> cards) {
        entireDeck.addAll(cards);
    }

    public void addDeck(Deck deck) {
        List<Card> listToAdd = deck.getCards();
        entireDeck.addAll(listToAdd);
    }

    public void sort() {
        Collections.sort(entireDeck);
    }

    public void sort(Comparator<Card> c) {
        Collections.sort(entireDeck, c);
    }

    public void shuffle() {
        Collections.shuffle(entireDeck);
    }

    public Map<Integer, Deck> deal(int players, int numberOfCards) throws IllegalArgumentException {
        int cardsDealt = players * numberOfCards;
        int sizeOfDeck = entireDeck.size();
        if (cardsDealt > sizeOfDeck) {
            throw new IllegalArgumentException("Number of players (" + players + ") times number of cards to be dealt ("
                + numberOfCards + ") is greater than the number of cards in the deck (" + sizeOfDeck + ").");
        }

        Map<Integer, List<Card>> dealtDeck = entireDeck.stream().collect(Collectors.groupingBy(card -> {
            int cardIndex = entireDeck.indexOf(card);
            if (cardIndex >= cardsDealt)
                return (players + 1);
            else
                return (cardIndex % players) + 1;
        }));

        // Convert Map<Integer, List<Card>> to Map<Integer, Deck>
        Map<Integer, Deck> mapToReturn = new HashMap<>();

        for (int i = 1; i <= (players + 1); i++) {
            Deck currentDeck = deckFactory();
            currentDeck.addCards(dealtDeck.get(i));
            mapToReturn.put(i, currentDeck);
        }
        return mapToReturn;
    }

    public String deckToString() {
        return this.entireDeck.stream().map(Card::toString).collect(Collectors.joining("\n"));
    }

    public static void main(String... args) {
        StandardDeck myDeck = new StandardDeck();
        System.out.println("Creating deck:");
        myDeck.sort();
        System.out.println("Sorted deck");
        System.out.println(myDeck.deckToString());
        myDeck.shuffle();
        myDeck.sort(new SortByRankThenSuit());
        System.out.println("Sorted by rank, then by suit");
        System.out.println(myDeck.deckToString());
        myDeck.shuffle();
        myDeck.sort(Comparator.comparing(Card::getRank).thenComparing(Comparator.comparing(Card::getSuit)));
        System.out.println("Sorted by rank, then by suit " + "with static and default methods");
        System.out.println(myDeck.deckToString());
        myDeck.sort(Comparator.comparing(Card::getRank).reversed().thenComparing(Comparator.comparing(Card::getSuit)));
        System.out.println("Sorted by rank reversed, then by suit " + "with static and default methods");
        System.out.println(myDeck.deckToString());
    }
}