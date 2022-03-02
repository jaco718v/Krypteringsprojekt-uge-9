package com.company;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("This program can encrypt and decrypt messages with the Caesar-Cypher," +
            " as well as the Vigenére-Cypher.");
        System.out.println("It will also be possible to repeatably encrypt a message through multiple " +
            "cyphers.");
        System.out.println("Now choose your cypher!");
        System.out.println("Type the number corresponding to your desired action.\n" +
            "Your options are:\nCaesar-cypher:\t\tencrypt(1)\tdecrypt(2)");
        System.out.println("Vigenére-cypher:\tencrypt(3)\tdecrypt(4)");
        int userChoice = sc.nextInt();
        switch (userChoice){
            case 1 ->
            case 2 ->
            case 3 ->
            case 4 ->
        }
    }
}
