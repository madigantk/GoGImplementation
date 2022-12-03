/*
 * Find the thimble Game
 */

import java.util.Random;

public class FindTheThimble extends getInput{
    int bestOutOf; //how many rounds to play
    int tempNum; //1 if right, 0 if left
    String computerChoice; // which hand the computer hid the thimble in
    String userGuess; //which hand the user guesses the thimle is in
    int userPoints;  // user points 
    int computerPoints;  //computer points

    //constructor that sets both entities points to 0
    FindTheThimble(){
        userPoints = 0;
        computerPoints = 0;
    }
    
    //body of the find the thimble game
    public int run(){
        Random rand = new Random();

        //explanation of game
        System.out.println("\n\nFind the Thimble: The game is about guessing which hand contains the thimble. The player will be playing against the computer and will be the one guessing throughout the rest of the number of agreed games. The total number of agreed games to be played before finding the winner is called “best out of number” . If the player guesses the correct hand with the thimble, they get a point and if it’s incorrect, the computer earns a point. Whoever has the most points after the agreed total games wins a point that will be added to their overall score board of Games of games.");
        System.out.println("‘best out of number’ is the total number of the games to be played before deciding the winner. ‘X’: is the variable of which hand has the thimble. ‘left’ calls to guess that the thimble is in the left hand of the computer. ‘right’ calls to guess that the thimble is in the right hand of the computer.");
        
        //choosing how many games to play
        System.out.println("Enter the ‘best out of number’ you want to play—this must be a positive odd integer. The player with the most points will be declared as the winner after playing this total number of games.\n Best out of number:");
        bestOutOf = getBestOf();

        System.out.println("\nYou will be the guesser throughout the game.");

        //run until one entity has reached the limit
        while(userPoints < (bestOutOf/2+1) && computerPoints < (bestOutOf/2+1)){

            //computer hiding the thimble
            tempNum = rand.nextInt(2);
            if(tempNum == 1){
                computerChoice = "right";
            }
            else{
                computerChoice = "left";
            }
            System.out.println("\nThe computer has hidden the thimble.\n");

            //user guessing which hand thimble is hiddenin
            System.out.println("Enter your guess. Enter ‘left’ to guess the left hand, or ‘right’ to guess the right hand.");
            userGuess = getString("right", "left");
            System.out.println("\nYou have guessed "+userGuess);

            //checking if user gussed correctly and adding a point accordingly
            if(computerChoice.equals(userGuess)){
                userPoints++;
                System.out.println("\nCorrect guess, the thimble was in "+computerChoice+" hand! You earned a point");
            }
            else{
                computerPoints++;
                System.out.println("Incorrect guess, the thimble was in "+computerChoice+" hand. The computer earned a point.");
            }

            //displays scoreboard for rounds
            System.out.println("User points: "+userPoints+"\nComp points: "+computerPoints);
        }

        //declares either user or computer winner. returns 1 if user won and 0 if computer won
        System.out.println("\nGame Over");
        if(userPoints == (bestOutOf/2+1)){
            System.out.println("\nCongratulations you won!");
            return 1;
        }
        else{
            System.out.println("The computer won. Better luck next time.");
            return 0;
        }



    }
}