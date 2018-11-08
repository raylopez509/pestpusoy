package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private final int COPY_OF_CARDS = 1; //change to 8 for final game
    public static void main(String[] args) {
	// write your code here
        System.out.println("Welcome to Pest Pusoy!");
        ArrayList<Card> deck = initializeDeck();

        ////testing out print
        int n = 0;
        for(Card c: deck) {
            System.out.println(n + " " + c.getType());
            n++;
        }
        ////

        ArrayList<ArrayList<Card>> playerHands = new ArrayList<>();
        ArrayList<ArrayList<Card>> playerBoards = new ArrayList<>();
        int playerCount = 3;
        for(int i = 0; i < playerCount; i++) {
            playerHands.add(new ArrayList<>());
            playerBoards.add(new ArrayList<>());
        }
        while(!deck.isEmpty()) {
            for(int i = 0; i < playerCount; i++) {
                if(deck.isEmpty()) {
                    break;
                }
                else {
                    playerHands.get(i).add(deck.remove(0));
                }
            }
        }
        Scanner scan = new Scanner(System.in);
        int playerTurn = 0;
        int cardIndex = 0;
        for(Card c: playerHands.get(0)) {
            System.out.println(cardIndex + " " + c.getType());
            cardIndex++;
        }
        System.out.println("Size: " + playerHands.get(0).size());

        /*
        decisions that have to be made when in Cockroach Poker:
        -which card to choose
        -which type to declare as
        -who to give the card to
        --when receiving--
        -if to accept or decline
        --if accepted, true or false
        --if declined, what type to declare as
        --who to give the card to
         */

        int chosenCard = -1;
        while(chosenCard < 0 || chosenCard > playerHands.get(0).size() - 1) {
            System.out.println("Select card to pass");
            chosenCard = scan.nextInt();
        }
        System.out.println("I have chosen " + playerHands.get(0).get(chosenCard).getType());
        Type declaration = chooseType(false);
        System.out.println(declaration);

        System.out.println("Choose who to give the card");



        //testing for 2 player game. Not sure how to actually
        //ArrayList<Card> p1Hand = new ArrayList<Card>();
        //ArrayList<Card> p2Hand = new ArrayList<Card>();


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
    private static ArrayList<Card> initializeDeck() {
        ArrayList<Card> deck = new ArrayList<>();
        for (Type t : Type.values()) {
            for (int i = 0; i < 1; i++) {
                deck.add(new Card(t));
            }
        }
        Collections.shuffle(deck);
        return deck;
    }

    private static Type chooseType(boolean isHuman) {
        System.out.println("Choose which type to declare:");
        System.out.println("1: COCKROACH");
        System.out.println("2: TOAD");
        System.out.println("3: STINKBUG");
        System.out.println("4: SPIDER");
        System.out.println("5: BAT");
        System.out.println("6: RAT");
        System.out.println("7: FLY");
        System.out.println("8: SCORPION");
        int chosenType;
        if(isHuman) {
            Scanner scan = new Scanner(System.in);
            chosenType = scan.nextInt();
            if (chosenType < 1 || chosenType > 8) {
                System.out.println("Invalid selection, try again:");
                chosenType = scan.nextInt();
            }
        }
        else {
            Random random = new Random();
            chosenType = random.nextInt(7) + 1;
        }
        switch(chosenType){
            case 1: return Type.COCKROACH;
            case 2: return Type.TOAD;
            case 3: return Type.STINKBUG;
            case 4: return Type.SPIDER;
            case 5: return Type.BAT;
            case 6: return Type.RAT;
            case 7: return Type.FLY;
            case 8: return Type.SCORPION;
        }
        return null;//should never go here
    }
}
