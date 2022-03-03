package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public StringBuilder vigenereCypherDecrypt(String inputString, String letterKey){
        StringBuilder text = new StringBuilder();
        int count=0;
        for(int i=0; i<inputString.length(); i++){
            int number = letterKey.toUpperCase().charAt(count++) - 'A';
            if (count>letterKey.length()-1){
                count=0;
            }
            number = number*(-1);
            inputString = inputString.toUpperCase(Locale.ROOT);
            text.append(cypherCharShift(number,inputString.charAt(i)));
        }
        return text;
    }

    public StringBuilder vigenereCypherEncrypt(String inputString, String letterKey){   //A er et shift på 0
        StringBuilder text = new StringBuilder();
        int count=0;
        for(int i=0; i<inputString.length(); i++){
            int number = letterKey.toUpperCase().charAt(count++) - 'A';
            if (count>letterKey.length()-1){
                count=0;
            }
            inputString = inputString.toUpperCase(Locale.ROOT);
            text.append(cypherCharShift(number,inputString.charAt(i)));
        }
        return text;
    }


    public StringBuilder caesarCypherDecrypt(String inputString, int cypherTal){
       cypherTal=cypherTal*(-1);
       return caesarCypherEncrypt(inputString,cypherTal);
    }

    public char cypherCharShift(int cypherShift, char letter) {   
        char encrypted = letter;
        if (letter != ' ') {
            char encryption = (char) (letter + cypherShift);
            if (encryption > 'Z') {
                encryption = (char) (encryption - 26);
            } else if (encryption < 'A') {
                encryption = (char) (encryption + 26);
            }
            encrypted = (encryption);
        }
        return encrypted;
    }

    public StringBuilder caesarCypherEncrypt(String inputString, int cypherTal){
        StringBuilder text = new StringBuilder();
        inputString = inputString.toUpperCase(Locale.ROOT);
        for (int i =0;i<inputString.length();i++ ){
            text.append(cypherCharShift(cypherTal,inputString.charAt(i)));
        }
        return text;
    }

    public static void main(String[] args) {
        StringBuilder text;
        Scanner sc = new Scanner(System.in);
        Main obj = new Main();
        System.out.println("This program can encrypt and decrypt messages with the Caesar-Cypher," +
            " as well as the Vigenére-Cypher.");
        System.out.println("Choose your cypher!");
        int userChoice=1;
        String enterText;
        String enterKey;
        int enterShift;
        while(userChoice!=0) {
            System.out.println("(1) Caesar\n(2) Vigenére\n(0) exit");
            userChoice = sc.nextInt();
            switch (userChoice) {
                case 1 -> {System.out.println("Caesar\n(1)Encrypt\n(2)Decrybt\n(0)Main menu");
                    int userChoiceInner=sc.nextInt();
                    switch (userChoiceInner){
                        case 1 -> {
                            System.out.println("Caesar encryption\nEnter text");
                            enterText = sc.next();
                            System.out.println("Choose shift (0-26)");
                            enterShift= sc.nextInt();
                            text = obj.caesarCypherEncrypt(enterText, enterShift);
                            System.out.println("The encrypted result: "+text);
                            }
                        case 2 ->{System.out.println("Caesar decryption\nEnter encoded text");
                            enterText = sc.next();
                            System.out.println("Choose shift (0-26)");
                            enterShift= sc.nextInt();
                            text = obj.caesarCypherDecrypt(enterText, enterShift);
                            System.out.println("The decrypted result: "+text);
                        }
                    }
                }
                case 2 ->  {System.out.println("Vigenére\n(1)Encrypt\n(2)Decrybt\n(0)Main menu");
                    int userChoiceInner=sc.nextInt();
                    switch (userChoiceInner){
                        case 1 -> {
                            System.out.println("Vigenére encryption\nEnter text");
                            enterText = sc.next();
                            System.out.println("Enter key of letters");
                            enterKey= sc.next();
                            text = obj.vigenereCypherEncrypt(enterText, enterKey);
                            System.out.println("The encrypted result: "+text);
                    }
                        case 2 ->{System.out.println("Vigenére decryption\nEnter encoded text");
                            enterText = sc.next();
                            System.out.println("Enter key of letters");
                            enterKey= sc.next();
                            text = obj.vigenereCypherDecrypt(enterText, enterKey);
                            System.out.println("The decrypted result: "+text);
                        }
                }
            }


        }
        }
    }
}