package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
	// write your code here
        System.out.println("Welcome to Pest Pusoy!");
        initializeDeck();
        //Card c = new Card(Type.COCKROACH);
//        //making an array of Card objects as a deck. Con: can't shuffle
//        Card[] deck = new Card[64];
//        deck[0] = new Card(Type.COCKROACH);
//        int n = 0;
//        System.out.println(deck.length);
//        for(Type t: Type.values()) {
//            for(int i=0; i<8 ; i++) {
//                deck[n] = new Card(t);
//                System.out.println(deck[n].getType());
//                n++;
//            }
//        }
//        for(int i=0;i<deck.length;i++) {
//            System.out.println(i + " " + deck[i].getType());
//        }

    }
    private static void initializeDeck() {
        ArrayList<Card> deck = new ArrayList<>();
        for(Type t:Type.values()) {
            for(int i=0; i<8 ; i++) {
                deck.add(new Card(t));
            }
        }
        for(Card c:deck) {
            System.out.println(c.getType());
        }
        Collections.shuffle(deck);
    }
}
