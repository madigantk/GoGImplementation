import java.util.Scanner;

public class Playgame {
    public static void main(String args[]){
        int UP = 0; //user points
        int CP = 0; //computer points
        int choice = 0;
        String input;
        Scanner scnr = new Scanner(System.in);
        boolean cont = true;
        int winner = 0; //used as return value from games. 1 if user wins, 0 if computer wins

        System.out.println("\n\nWelcome to the Game of Games! Within this game you can play 5 fun games against the computer:\nFind the Thimble, Coin Flip, Guess the Number, Even and Odd, or Find the Red Thread. \nYou will select a game to play, play through it against the computer, \nand then whoever wins that game will get a point on an overall scoreboard for this Game of Games. \nAfter each game you play, this scoreboard will be displayed. \nYou will play these games repeatedly until you decide to quit. \nOnce you quit, the final tally will be displayed on the scoreboards to show the overall number of games won and lost by each player, \nand finally which player won the most, that is, which player won the Game of Games. \n\nLet's begin!\n");
        
        //runs until player wished to quit
        while (cont){
            System.out.println("Games:\n1. Find the Thimble\n2. Flip the coin\n3. Guess the Number\n4. Even and Odd\n5. Find the Red Thread\n");
            System.out.println("Pick a game to play! To choose a game, enter the corresponding integer with that game.\nChoice: ");
            while (1==1){
                input = scnr.nextLine();
                if (input.charAt(0)<49 || input.charAt(0)> 53){
                    System.out.println("inputut Invalid. You must enter an integer that corresponds to a game. Try again!");
                    continue;
                }
                break;
            }

            choice = (int)input.charAt(0)- 48;

            switch(choice){
                case 1:
                    //find the thimble
                    //example
                    // if(findthethimble() = 1)
                    //cpp++
                    //else
                    //up++
                    break;
                case 2:
                    //flip the coin
                    break;
                case 3:
                    //guess the number
                    break;
                case 4:
                    evenOrOdd game = new evenOrOdd();
                    winner = game.game();
                    if (winner == 1){
                        UP++;
                    }
                    else{
                        CP++;
                    }
                    displayScoreboard(UP, CP);
                    break;
                case 5:
                    //find the red thread
                    break;
                default:
                    break;
            }
            System.out.println("Do you want to continue to play the Game of Games?\nEnter 'Y' for yes and 'N' if you want to quit");

            while (1==1){
                input = scnr.nextLine();
                if (input.charAt(0) == 'Y' || input.charAt(0) == 'y'){
                    break;
                }
                else if(input.charAt(0) == 'N' || input.charAt(0) == 'n' ){
                    cont = false;
                    break;
                }
                else{
                    System.out.println("Invalid inputut. You must enter either 'Y' or 'N'\n");

                }
            }
        }
        displayScoreboard(UP, CP);
        if (UP == CP){
            System.out.println("It's a draw! The Game of Games was a tie.\n");
        }
        else if(UP < CP){
            System.out.println("You lost the Game of Games. The computer is the winner. Better luck next time.\n");
        }
        else{
            System.out.println("Congratulations! You won the Game of Games!\n");
        }
    }


    private static void displayScoreboard(int up, int cp){
        System.out.println("User has won "+up+" games and lost "+cp+" games.\nComputer has won "+cp+" games and lost "+up+" games.\n");

    }
}
