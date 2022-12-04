/*
 * This class is the drver for the Game of Games with the main class. Extends getInput class for getting user input.
 * Also has a display scoreboard method for dispalying the scoreboard
 */


public class Playgame extends getInput {
    public static void main(String args[]){
        int UP = 0; //user points
        int CP = 0; //computer points
        int choice;  // user game choice
        String tempString;
        boolean cont = true;  //set till true until user wants to quit, than false
        int winner = 0; //used as return value from games. 1 if user wins, 0 if computer wins

        System.out.println("\n\nWelcome to the Game of Games! Within this game you can play 5 fun games against the computer:\nFind the Thimble, Coin Flip, Guess the Number, Even and Odd, or Find the Red Thread. \nYou will select a game to play, play through it against the computer, \nand then whoever wins that game will get a point on an overall scoreboard for this Game of Games. \nAfter each game you play, this scoreboard will be displayed. \nYou will play these games repeatedly until you decide to quit. \nOnce you quit, the final tally will be displayed on the scoreboards to show the overall number of games won and lost by each player, \nand finally which player won the most, that is, which player won the Game of Games. \n\nLet's begin!\n");

        //runs until player wished to quit. than cont = false
        while (cont){
            System.out.println("Games:\n1. Find the Thimble\n2. Flip the coin\n3. Guess the Number\n4. Even and Odd\n5. Find the Red Thread\n");
            System.out.println("Pick a game to play! To choose a game, enter the corresponding integer with that game.\nChoice: ");

            //made instance becasue main method is static, so couldnt call direclty. gets game choice from user
            getInput playgame = new getInput();
            choice = playgame.getNum(1,5);

            //swtich board for that game user wants to play, 1=find the thimble. 2=coin flip. 3=guess the number. 4=even or odd. 5=find the red thread
            switch(choice){
                case 1:
                    FindTheThimble game1 = new FindTheThimble();
                    winner = game1.run();
                    if (winner == 1){
                        UP++;
                    }
                    else{
                        CP++;
                    }
                    displayScoreboard(UP, CP);
                    break;

                case 2:
                    coinFlip game2 = new coinFlip();
                    winner = game2.run();
                    if (winner == 1){
                        UP++;
                    }
                    else{
                        CP++;
                    }
                    displayScoreboard(UP, CP);
                    break;

                case 3:
                    Guess_the_number game3 = new Guess_the_number();
                    winner = game3.run();
                    if (winner == 1){
                        UP++;
                    }
                    else{
                        CP++;
                    }
                    displayScoreboard(UP, CP);
                    break;

                case 4:
                    evenOrOdd game4 = new evenOrOdd();
                    winner = game4.run();
                    if (winner == 1){
                        UP++;
                    }
                    else{
                        CP++;
                    }
                    displayScoreboard(UP, CP);
                    break;

                case 5:
                    FindTheRedThread game5 = new FindTheRedThread();
                    winner = game5.run();
                    if (winner == 1){
                        UP++;
                    }
                    else{
                        CP++;
                    }
                    displayScoreboard(UP, CP);
                    break;
                default:
                    break;
            }

            //gets input from user for if they want to keep playing
            System.out.println("Do you want to continue to play the Game of Games?\nEnter 'Y' for yes and 'N' if you want to quit");
            tempString = playgame.getString("Y", "N");
            if (tempString.equals("N")){
                cont = false;
            }
        }

        //once they want to quit, displays scoreboard one last time and then delcares either user or computer the winner
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
        System.out.println("\nScoreboard:\nUser has won "+up+" games and lost "+cp+" games.\nComputer has won "+cp+" games and lost "+up+" games.\n");

    }
}
