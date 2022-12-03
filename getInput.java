/*
 * This is a super class that has methods for getting valid inputs from the user of different type
 */

import java.util.Scanner;

public class getInput {
    String input;
    int tempNum;
    


    //gets input till input is a positive odd integer that is used for how many rounds of each game to play. Then returns
    int getBestOf(){
        Scanner scnr = new Scanner(System.in);
        while (1==1){
            input = scnr.nextLine();

            //checks that input is an int, is odd, and it larger than 0
            if (input.charAt(0) == (int) input.charAt(0) && ((int)input.charAt(0)-48) % 2 == 1 && ((int)input.charAt(0)-48) > 0){
                tempNum = (int) input.charAt(0) - 48;
                break;
            }
            else{
                System.out.println("Invalid choice. Please enter a positive odd number\nBest out of number: ");
            }
        }
        return tempNum;
    }

    //gets input till input is number between x and y and then returns. x is lower bound and y is upper bound. both inclusive.
    int getNum(int x, int y){
        Scanner scnr = new Scanner(System.in);
        while (1==1){
            input = scnr.nextLine();

            //checks the input is greater than or equal to x and less than or equal to y
            if (input.charAt(0)>=(48+x) && input.charAt(0)<= (48+y)){
                tempNum = (int) input.charAt(0) - 48;
                break;
            }
            else{
                System.out.println("Invalid choice. Please enter a number inbetween "+x+" and "+y+"\nInput number: ");
            }
        }
        return tempNum;

    }
    
    //gets input till unput is either equal to x or y. 
    String getString(String x, String y){
        Scanner scnr = new Scanner(System.in);
        while (1==1){
            input = scnr.nextLine();

            //checks that input is either x or y. if not than gets new input from user
            if (input.equals(x) || input.equals(y)){
                break;
            }
            else{
                System.out.println("Invalid input. Please enter either "+x+" or "+y+"\nInput: ");
            }
        }
        return input;
    }

    
}
