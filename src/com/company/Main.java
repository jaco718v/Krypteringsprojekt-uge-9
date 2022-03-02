package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public StringBuilder caesarCypherDecrypt(String inputString, int cypherTal){
       cypherTal=cypherTal*(-1);
       return caesarCypherEncrypt(inputString,cypherTal);
    }

    public char caesarCypherChar(int cypherShift, char letter) {    //Virker ikke ved shift højere end 26
        char encryptet = letter;
        if (letter != ' ') {
            char encryption = (char) (letter + cypherShift);
            if (encryption > 'Z') {
                encryption = (char) (encryption - 26);
            } else if (encryption < 'A') {
                encryption = (char) (encryption + 26);
            }
            encryptet = (encryption);
        }
        return encryptet;
    }

    public StringBuilder caesarCypherEncrypt(String inputString, int cypherTal){
        StringBuilder text = new StringBuilder();
        inputString = inputString.toUpperCase(Locale.ROOT);
        for (int i =0;i<inputString.length();i++ ){
            text.append(caesarCypherChar(cypherTal,inputString.charAt(i)));
        }
        return text;
    }

    public static void main(String[] args) {
        StringBuilder text=null;
        Scanner sc = new Scanner(System.in);
        Main obj = new Main();
        System.out.println("This program can encrypt and decrypt messages with the Caesar-Cypher," +
            " as well as the Vigenére-Cypher.");
        System.out.println("It will also be possible to repeatably encrypt a message through multiple " +
            "cyphers.");
        System.out.println("Now choose your cypher!");
        int userChoice=1;
        while(userChoice==1 || userChoice==2 || userChoice==3 || userChoice==4) {
            System.out.println("Type the number corresponding to your desired action.\n" +
                "Your options are:\nCaesar-cypher:\t\tencrypt(1)\tdecrypt(2)");
            System.out.println("Vigenére-cypher:\tencrypt(3)\tdecrypt(4)");
            System.out.println("To exit the program enter any other key.");
            userChoice = sc.nextInt();
            switch (userChoice) {
                case 1 -> {System.out.println("Type your message followed by your shift-number");
                text = obj.caesarCypherEncrypt(sc.next(), sc.nextInt());}
                case 2 -> {System.out.println("Type the encrypted message followed by the shift-number");
                text = obj.caesarCypherDecrypt(sc.next(), sc.nextInt());}
                case 3 -> {System.out.println("Type your message followed by key of letters");
                text = obj.vigenereCypherEncrypt(sc.next(), sc.next());}
                case 4 -> {System.out.println("Type the encrypted message followed by the key of letters");
                text = obj.vigenereCypherDecrypt(sc.next(), sc.next());}
            }
            System.out.println("You currrent result is: "+text);
        }
    }
}