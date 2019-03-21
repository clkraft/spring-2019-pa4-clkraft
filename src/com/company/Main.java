package com.company;

import java.io.*;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException{
        String userChoice = "0";// user choice
        while (userChoice.equals("0")) {//begins while loop
            userChoice = getMenuChoice();//gets true user choice from menu
            switch (userChoice) {//switch for different possible cases
                case "1"://gives case
                    fileOut();//calls method fileOut()
                    break;//ends case
                case "2":
                    fileOut();
                    break;
                case "3":
                    fileOut();
                    break;
                case "4":
                    System.exit(0);//exits system
                    break;
                default:
                    System.out.println("Please enter a valid choice.");//message in case menu choice was not valid

            }
        }
    }

    public static String getMenuChoice() {
        Scanner keyboard = new Scanner(System.in);//sets up new scanner called keyboard
        String userChoice;//initializes userChoice
        System.out.println("Please choose a choice for your file. \n" +
                "Press 1 to Encrypt File\n" +
                "Press 2 to Decrypt File\n" +
                "Press 3 to Show Word Count\n" +
                "Press 4 to Exit\n");//message to user informing them of their choices
        userChoice = keyboard.next();//sets user choice equal to next thing entered from keyboard
        return userChoice;//returns userChoice value
    }

    public static String name() {
        String fileName;//initializes fileName
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter file name: ");//asks user to enter name of their file
        fileName = keyboard.next() + ".txt";//takes file name fomr next keyboard input and adds .txt to it

        return fileName;//returns full file name with .txt
    }
    public static String newName(){
        String newName;//initializes newName
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a new file name: ");//prompts user to enter a name for their new file
        newName = keyboard.next();//sets name of new file to next keyboard input
        return newName;//returns new file name
    }


    public static void fileOut() throws IOException {

        int count = 0;//initializes integer count and sets it to 0

        String fileName = name();//calls name method to get the fileName

        String newName = newName();//calls name method to get the newName

        Scanner inFile = new Scanner(new File(fileName));//sets up scanner to read in file

        FileWriter fileWriter = new FileWriter(newName + ".txt",  true);//sets the file writers name as the new name and adds .txt
        PrintWriter outFile = new PrintWriter(fileWriter);//creates printwriter object to write in output.txt

        while (inFile.hasNext()) {//while loop for when the read in file has a next line
            String fileInput = inFile.nextLine();//sets the next line to the file input
            String[] tempArray = fileInput.split(" ");//splits each line into words and places them in arrays
            count = count + tempArray.length;//finds word count by adding the length of each line to 0

            for (int i = 0; i < fileInput.length(); i++) {//for the place of each character up until the word length is reached
                outFile.print(charSwitch(fileInput.charAt(i)));//prints the converted character of i spot in a word into the output.txt
            }

            outFile.println();//prints full line into the output.txt

        }
        inFile.close();//closes infile
        outFile.close();//closes out file
        System.out.println("Your word count is "+ count + " words");//prints out word count
    }

    public static char charSwitch( char charInput ) {
        char convertedChar;//initializes converted char
        //if a char is in between a and m 13 is added to the place in the alphabet, if its between m and z 13 is subtracted to get the converted char, if its not of the previous the char stays the same
        if (charInput >= 'A' && charInput <= 'M')
        {
            convertedChar = (char) (charInput + 13);
        } else if (charInput >= 'M' && charInput <= 'Z') {
            convertedChar = (char) (charInput - 13);
        } else {
            convertedChar = charInput;
        }

        return convertedChar;
    }

}



