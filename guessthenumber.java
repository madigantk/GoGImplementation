//guess the number game
import java.util.Scanner;

public class Guess_the_number{

    public static void guess_the_number(){

        int lower_range=0;
        int upper_range=0;
        int tries=0;
        int guess=0;
        int i=0;

        System.out.println("Guess the Number:");
        System.out.println("You will specify a range of numbers and how many chances you have to guess. You will be playing against the computer; therefore");
        System.out.println("the computer will randomly generate an integer within the range you give, and you will be entering guesses to try and guess that number");
        System.out.println("The constraint here is the number of guesses cannot be more than half the number of values in the range. For example, if therange is from 1-10,");
        System.out.println("the user can make at most 5 guesses. You will have the chosen number of guesses to correctly get the unknown number.");
        System.out.println(" ");
        System.out.println("---Enter the min number in the range the number must be an integer---");
        
        Scanner sl=new Scanner(System.in);
        Scanner su=new Scanner(System.in);

        lower_range=sl.nextInt();
        
        System.out.println("enter the maximum number in the range the number must be an integer");


        upper_range=su.nextInt();

        if(upper_range<lower_range){
          System.out.println("Invalid input. The maximum number must be greater than the minimum number.");
          System.out.println("enter the maximum number in the range—this must be larger than the minimum number you entered");
          upper_range=su.nextInt();
        }

        System.out.println("The range of number is from "+lower_range+" to "+upper_range);
        // System.out.println(lower_range+"= The minimum "+upper_range+"=the maximum");
        
        int number = (int)(((Math.random()*upper_range-lower_range))+lower_range+lower_range/2);

        
        Scanner scanner=new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of guesses (this will be the number of attempts you have to guess the unknown number");
        System.out.println("You must enter a positive integer. The number of guesses cannot be more than half the number of values in the range.");
        
        tries= scanner.nextInt();

        if(tries>(upper_range-lower_range)/2){
          System.out.println("this number of tries is not valid");
          System.out.println("Enter a new number of tries");
          tries=scanner.nextInt();
        }
        else if(tries<0){
          System.out.println("Invalid input. The number must be a positive integer");
          System.out.println("Enter a new number of tries");
          tries=scanner.nextInt();
        }
        
        System.out.println("You will have "+tries+" attemps to guess the unknown number");
        System.out.println("You are the guesser. The computer will now choose a number");
        System.out.println("The computer has chosen a number between "+lower_range+" to "+upper_range);
        System.out.println("");
        System.out.println("");
        System.out.println("Enter a guess for the unknown integer in range "+lower_range +" to "+ upper_range);

        for (i = 0; i < tries; i++) {
            int attempts=tries;

            guess = sc.nextInt();
            
            System.out.println("You guessed "+guess);
            
            if(guess>upper_range-1){
              System.out.println("the guess is outside of range ");
              //attempts=attempts-1;
              //System.out.println("Your guess was incorrect."+guess+" was not the number. Try again, you have"+attempts+"more tries");
              System.out.println("Enter a guess for the unknown integer in range "+lower_range +" to "+ upper_range);
              guess = sc.nextInt();
            }
            else if(guess<lower_range){
              System.out.println("the guess is outside of range ");
              //attempts=attempts-1;
              //System.out.println("Your guess was incorrect."+guess+" was not the number. Try again, you have"+attempts+"more tries");
              System.out.println("Enter a guess for the unknown integer in range "+lower_range +" to "+ upper_range);
              guess = sc.nextInt();
            }
            if (number == guess) {
                System.out.println("Congratulations you won! you correctly guessed that the number was "+number);
                //return 1;
                break;
            }
            else if (number != guess && i != tries - 1) {
                System.out.println("Your guess was incorrect. "+guess+" was not the number. Try again, you have "+attempts+" more tries");
                attempts=attempts-1;
                System.out.println("attemps="+attempts);
            }
        }
            if (i == tries) {
                System.out.println("Game Over. You lost agaist the computer. Better luck next time");
                //return 0;
        }
    }


    public static void main(String arg[])
    {
         guess_the_number();
    }
}
