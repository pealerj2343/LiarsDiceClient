package com.example.liarsdiceclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<Dice> hand = new ArrayList<>();
    private int handSize;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;

    private boolean game = true;
    private int playerNum;
    private boolean isTurn;
    private int guess;

    private int currentFace;
    private int currentNum;

    private int faceGuess;
    private int numGuess;


    public Game(){
        try{

            Scanner input = new Scanner(System.in);

           socket = new Socket("localhost",8000);
           out = new DataOutputStream(socket.getOutputStream());
           in = new DataInputStream(socket.getInputStream());
           playerNum = in.readInt();
           handSize = in.readInt();
           System.out.println("Welcome Player: " + playerNum );
           System.out.println("Current hand size: " + handSize);
           for(int i =0 ; i <= handSize; i ++){
               hand.add(new Dice(in.readInt()));
               System.out.println(hand.get(i));
           }
           while(game){
                isTurn = in.readBoolean();
                if(isTurn){
                    System.out.println("It's Your turn");
                    currentFace = in.readInt();
                    currentNum = in.readInt();
                    System.out.println("Current face guess: " + currentFace + " Current num guess: " + currentNum);

                    System.out.println("Please enter in -1 to accuse 0 to guess face 1 to guess num");

                    guess = input.nextInt();

                    if(guess == 0){
                        System.out.println("Please enter a face ");
                        faceGuess = input.nextInt();
                        while(faceGuess <= currentFace){
                            System.out.println("Please enter a face ");
                            faceGuess = input.nextInt();
                        }
                    }
                    else if(guess == 1){
                        System.out.println("Please enter a number ");
                        numGuess = input.nextInt();
                        while(numGuess <= currentNum){
                            System.out.println("Please enter a number ");
                            numGuess = input.nextInt();
                        }
                    }
                }
           }
        }catch (IOException e){
            System.out.println("John is a loser");
            System.out.println(e);
        }
    }
}
