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
        while(1==1){
            try{
                tempNum = scnr.nextInt();
                if (tempNum > 0 && tempNum% 2 == 1 ){
                    return tempNum;
                }
                else{
                    System.out.println("Invalid choice. Please enter a positive odd number.\nInput number: ");
                }
            }
            catch(Exception e){
                System.out.println("Invalid choice. Please enter positive odd number\nInput number: ");
                scnr.next();
            }
        }
        
    }

    //gets input till input is number between x and y and then returns. x is lower bound and y is upper bound. both inclusive.
    int getNum(int x, int y){
        Scanner scnr = new Scanner(System.in);
        
        while(1==1){
            try{
                tempNum = scnr.nextInt();
                if (tempNum>= x && tempNum <= y){
                    return tempNum;
                }
                else{
                    System.out.println("Invalid choice. Please enter a number inbetween "+x+" and "+y+"\nInput number: ");
                }
            }
            catch(Exception e){
                System.out.println("Invalid choice. Please enter a number inbetween "+x+" and "+y+"\nInput number: ");
                scnr.next();
            }
        }

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
