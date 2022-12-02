import java.util.Scanner;
import java.util.Random;

public class FindTheThimble{
    int bestOutOf;
    String input;

    FindTheThimble(){}
    

    public int run(){
        Scanner scnr = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Find the Thimble: The game is about guessing which hand contains the thimble. The player will be playing against the computer and will be the one guessing throughout the rest of the number of agreed games. The total number of agreed games to be played before finding the winner is called “best out of number” . If the player guesses the correct hand with the thimble, they get a point and if it’s incorrect, the computer earns a point. Whoever has the most points after the agreed total games wins a point that will be added to their overall score board of Games of games.");
        System.out.println("‘best out of number’ is the total number of the games to be played before deciding the winner. ‘X’: is the variable of which hand has the thimble. ‘left’ calls to guess that the thimble is in the left hand of the computer. ‘right’ calls to guess that the thimble is in the right hand of the computer.");
        System.out.println("Enter the ‘best out of number’ you want to play—this must be a positive odd integer. The player with the most points will be declared as the winner after playing this total number of games.");
        
        while(1==1){
            input = scnr.nextLine();
            if (input.charAt(0) == (int) input.charAt(0) && ((int)input.charAt(0)-48) % 2 == 1 && ((int)input.charAt(0)-48) > 0){
                bestOutOf = (int) input.charAt(0) - 48;
                break;
            }
            else{
                System.out.println("Invalid choice. Please enter a positive odd number\nBest out of number:\n");
            } 
        }

        System.out.println("You will be the guesser throughout the game.");







    }
}