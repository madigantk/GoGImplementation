import java.util.Scanner;

public class getInput {
    String input;
    int tempNum;
    


    //returns a positive odd integer
    int getBestOf(){
        Scanner scnr = new Scanner(System.in);
        while (1==1){
            input = scnr.nextLine();
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

    //gets inout till inout is number between x and y and then returns. x is lower bound and y is upper bound. both inclusive.
    int getNum(int x, int y){
        Scanner scnr = new Scanner(System.in);
        while (1==1){
            input = scnr.nextLine();
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
    
    //allows user to input 
    String getString(String x, String y){
        Scanner scnr = new Scanner(System.in);
        while (1==1){
            input = scnr.nextLine();
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
