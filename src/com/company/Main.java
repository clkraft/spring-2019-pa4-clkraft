package com.company;

public class Main {

    public static void main(String[] args) throws IOException{
        String userChoice = "0";
        while (userChoice.equals("0")) {
            userChoice = getMenuChoice();
            switch (userChoice) {
                case "1":
                    fileOut();
                    break;
                case "2":
                    fileOut();
                    break;
                case "3":
                    fileOut();
                    break;
                case "4":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid choice.");

            }
        }
    }

    public static String getMenuChoice() {
        Scanner keyboard = new Scanner(System.in);
        String userChoice;
        System.out.println("Please choose a choice for your file. \n" +
                "Press 1 to Encrypt File\n" +
                "Press 2 to Decrypt File\n" +
                "Press 3 to Show Word Count\n" +
                "Press 4 to Exit\n");
        userChoice = keyboard.next();
        return userChoice;
    }

    public static String name() {
        String fileName;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter file name: ");
        fileName = keyboard.next() + ".txt";

        return fileName;
    }
    public static String newName(){
        String newName;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a new file name: ");
        newName = keyboard.next();
        return newName;
    }


    public static void fileOut() throws IOException {

        int count = 0;

        String fileName = name();

        String newName = newName();

        Scanner inFile = new Scanner(new File(fileName));

        FileWriter fileWriter = new FileWriter(newName + ".txt",  true);
        PrintWriter outFile = new PrintWriter(fileWriter);

        while (inFile.hasNext()) {
            String fileInput = inFile.nextLine();
            String[] tempArray = fileInput.split(" ");
            count = count + tempArray.length;

            for (int i = 0; i < fileInput.length(); i++) {
                outFile.print(charSwitch(fileInput.charAt(i)));
            }

            outFile.println();

        }
        inFile.close();
        outFile.close();
        System.out.println("Your word count is "+ count + " words");
    }

    public static char charSwitch( char charInput ) {
        char convertedChar;

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



