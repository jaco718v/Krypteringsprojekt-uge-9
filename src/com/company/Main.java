package com.company;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main obj = new Main();
        System.out.println("This program can encrypt and decrypt messages with the Caesar-Cypher," +
            " as well as the Vigenére-Cypher.");
        System.out.println("It will also be possible to repeatably encrypt a message through multiple " +
            "cyphers.");
        System.out.println("Now choose your cypher!");
        int userChoice=0;
        while(userChoice==1 || userChoice==2 || userChoice==3 || userChoice==4) {
            System.out.println("Type the number corresponding to your desired action.\n" +
                "Your options are:\nCaesar-cypher:\t\tencrypt(1)\tdecrypt(2)");
            System.out.println("Vigenére-cypher:\tencrypt(3)\tdecrypt(4)");
            System.out.println("To exit the program enter any other key.");
            userChoice = sc.nextInt();
            switch (userChoice) {
                case 1 -> System.out.println("Type your message followed by your shift-number");
                obj.caesarCypherEncrypt(sc.next(), sc.nextInt());
                case 2 -> System.out.println("Type the encrypted message followed by the shift-number");
                obj.caesarCypherdecrypt(sc.next(), sc.nextInt());
                case 3 -> System.out.println("Type your message followed by key of letters");
                obj.vigenereCypherEncrypt(sc.next(), sc.next());
                case 4 -> System.out.println("Type the encrypted message followed by the key of letters");
                obj.vigenereCypherDecrypt(sc.next(), sc.next());
            }

        }
    }
}