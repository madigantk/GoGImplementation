/*
 * Even or Odd Game
 */

import java.util.Random;

public class evenOrOdd extends getInput {
    int bestOutOf; // how many rounds to play

    //these two represent remainder when divided by 2. Ex if userChoice ==1, then that would be odd becasue oddNum%2 = 1
    int userChoice;
    int computerChoice;

    int userThrow; //number user is throwing in round
    int computerThrow; //number computer is throwing in round
    int userPoints;  //user points in even or odd
    int computerPoints;  //computer points in even or odd
    String tempString;

    //constructor that sets both entities points to 0
    evenOrOdd(){
        userPoints = 0;
        computerPoints = 0;
    }


    //body of the even or odd game
    public int run(){
        Random rand = new Random();
        System.out.println("\nEven and Odd Game:\nThe player will choose even or odd. You will remain even or odd for the whole game and cannot switch from throw to throw. Valid throws are integer values from 1 to 5. The user will also indicate the “best out of number”. This will be how many games are played to win. For example, If you choose 7, the first to win 4 throws wins the game. The 'best out of number' has to be odd.\n");

        //choosing how many games to play
        System.out.println("Pick a best out of number that will be played too. The number has to be an integer.\nBest out of number:");
        bestOutOf = getBestOf();

        //choosing even or odd
        System.out.println("\nPick your choice of even or odd. Your choice will be the same for the whole game and you won’t be able to switch from throw to throw.\nEnter 'o' for odd or 'e' for even: ");
        tempString = getString("e", "o");
        if(tempString == "e"){
            userChoice = 0;
            computerChoice = 1;
            System.out.println("Your choice is even\n");
        }
        else if(tempString == "o"){
            userChoice = 1;
            computerChoice = 0;
            System.out.println("Your choice is odd\n");
        }

        //run until one entity has reached the limit
        while(userPoints < (bestOutOf/2+1) && computerPoints < (bestOutOf/2+1)){

            //gets throw form user
            System.out.println("\nPick an integer between 1 and 5. This is your throw for the round: ");
            userThrow = getNum(1, 5);
            computerThrow = 1 + rand.nextInt(5);
            System.out.println("\nYour choice for this round is: "+userThrow+"\nThe computers choice for this round is: "+computerThrow);

            //sees if throws combined are even or odd
            if((userThrow + computerThrow)%2 == 0){
                System.out.println("The throws combined is "+(userThrow+computerThrow)+" which is an even number.\n");
            }
            else{
                System.out.println("The throws combined is "+(userThrow+computerThrow)+" which is an odd number.\n");
            }

            //checks who won the round
            if((userThrow + computerThrow)%2 == userChoice){
                System.out.println("You won this round!");
                userPoints++;
            }
            else{
                System.out.println("The computer won this round.");
                computerPoints++;
            }

            //displays scoreboard for rounds
            System.out.println("User points: "+userPoints+"\nComp points: "+computerPoints);
        }

        //declares either user or computer winner. returns 1 if user won and 0 if computer won
        if(userPoints == (bestOutOf/2+1)){
            System.out.println("\nCongratulations you won!");
            return 1;
        }
        else{
            System.out.println("\nGame Over. You lost against the computer. Better luck next time.");
            return 0;
        }

    }

}
