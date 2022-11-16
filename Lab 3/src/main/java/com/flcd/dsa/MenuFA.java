package com.flcd.dsa;

import java.util.Scanner;

public class MenuFA {

    private final String faFileName = "src/identifiersFA.txt";

    public void start(){
        FA fa = new FA(faFileName);
        boolean isDone = false;
        Scanner scanner = new Scanner(System.in);
        while(!isDone){

            printMenu();
            System.out.println("Option: ");
            int optionNr = scanner.nextInt();

            switch (optionNr){
                case 1:
                    System.out.println(fa.getAllNodes());
                    break;
                case 2:
                    System.out.println(fa.getAlphabet());
                    break;
                case 3:
                    System.out.println(fa.getTransitionsHashTable());
                    break;
                case 4:
                    System.out.println(fa.getStartingNode());
                    break;
                case 5:
                    System.out.println(fa.getEndingNodes());
                    break;
                case 6:
                    scanner.nextLine();
                    String str = scanner.nextLine();
                    if(fa.verify(str)){
                        System.out.println("The value follows the rules.");
                    }
                    else {
                        System.out.println("The value does not follow the rules");
                    }
                    break;
                case 0:
                    isDone = true;
                    break;
                default:
                    System.out.println("Wrong option number");
            }



        }
    }



    private void printMenu(){
        System.out.println("Choose option: ");
        System.out.println("1 Show the set of states");
        System.out.println("2 Show alphabet");
        System.out.println("3 Show the transitions");
        System.out.println("4 Show the start state");
        System.out.println("5 Show the final states");
        System.out.println("6 Verify by rule read");
        System.out.println("0 Exit");
    }


}
