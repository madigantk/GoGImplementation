import java.util.Scanner;
import java.util.Random;

public class evenOrOdd {
    int bestOutOf;
    
    //these two represent remainder when divided by 2. Ex if userChoice ==1, then that would be odd becasue oddNum%2 = 1
    int userChoice;
    int computerChoice;

    int userThrow;
    int computerThrow;
    int userPoints;
    int computerPoints;
    String input;

    evenOrOdd(){
        userPoints = 0;
        computerPoints = 0;
    }

    public int game(){
        Scanner scnr = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Even and Odd Game:\nThe player will choose even or odd. You will remain even or odd for the whole game and cannot switch from throw to throw. Valid throws are integer values from 1 to 5. The user will also indicate the “best out of number”. This will be how many games are played to win. For example, If you choose 7, the first to win 4 throws wins the game. The 'best out of number' has to be odd.\n");
        
        //choosing how many games to play
        System.out.println("Pick a best out of number that will be played too. The number has to be an integer.\nBest out of number: \n");
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

        //choosing even or odd
        System.out.println("Pick your choice of even or odd. Your choice will be the same for the whole game and you won’t be able to switch from throw to throw.\nEnter 'o' for odd or 'e' for even: ");
        while(1==1){
            input = scnr.nextLine();
            if(input.charAt(0) == 'e' || input.charAt(0) == 'E'){
                userChoice = 0;
                computerChoice = 1;
                System.out.println("Your choice is even\n");
                break;

            }
            else if(input.charAt(0) == 'o' || input.charAt(0) == 'O'){
                userChoice = 1;
                computerChoice = 0;
                System.out.println("Your choice is odd\n");
                break;
            }
            else{
                System.out.println("Invalid choice. Plese input 'e' for even or 'o' for odd: ");
            }
        }

        while(userPoints < (bestOutOf/2+1) && computerPoints < (bestOutOf/2+1)){
            System.out.println("\nPick an integer between 1 and 5. This is your throw for the round: ");
            while (1==1){
                input = scnr.nextLine();
                if (input.charAt(0)<49 || input.charAt(0)> 53){
                    System.out.println("Invalid input. Please pick an integer between 1 and 5");
                    continue;
                }
                break;
            }
            userThrow = (int) input.charAt(0) - 48;
            computerThrow = 1 + rand.nextInt(5);


            System.out.println("Your choice for this round is: "+userThrow+"\nThe computers choice for this round is: "+computerThrow);
            if((userThrow + computerThrow)%2 == 0){
                System.out.println("The throws combined is "+(userThrow+computerThrow)+" which is an even number.\n");
            }
            else{
                System.out.println("The throws combined is "+(userThrow+computerThrow)+" which is an odd number.\n");
            }

            if((userThrow + computerThrow)%2 == userChoice){
                System.out.println("You won this round!");
                userPoints++;
            }
            else{
                System.out.println("The computer won this round.");
                computerPoints++;
            }
            System.out.println("User points: "+userPoints+"\nComp points: "+computerPoints);
        }

        if(userPoints == (bestOutOf/2+1)){
            System.out.println("Congratulations you won!");
            return 1;
        }
        else{
            System.out.println("Game Over. You lost against the computer. Better luck next time.");
            return 0;
        }



    }
    
}
