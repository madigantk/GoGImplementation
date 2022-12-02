import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class coinFlip{

		int UP;						// User Points (wins)
		int CP;						// Computer Points (losses)
		int series;					// best of value
		int min;					// Minimum needed wins
		int gog_score;				// Returns if User wins series
		
		String guess;				// Heads or Tails guess by player
		String flip;				// Coin flip result
		
		boolean valid_guess; 	// Detects valid guess
		boolean valid_best_of;	// Detects valid series value
		boolean flag;

		coinFlip(){
			valid_guess = false;
			valid_best_of = false;
			flag = false;
		}

		

	public int run(){
		
		UP = 0;
		CP = 0;

		System.out.println("Flip the Coin: The game is about guessing if a flipped coin lands on heads or tails.\n\n"
						+ "The player will be playing against the computer and will be the one guessing throughout the rest of the number of agreed games.\n\n"
						+ "The total number of agreed games to be played before finding the winner  is called “best out of number”.\n\n"
						+ "If the player guesses correctly they get a point and if it’s incorrect, the computer earns a point.\n\n"
						+ "Whoever has the most points after the agreed total games wins a point that will be added to their overall score board of Games of games.\n\n");

		// ENTERING THE BEST-OF-NUMBER
		do {

			System.out.println("\nEnter the 'best out of number' you want to play –– this must be an odd integer. The player with the most points will be declared as the winner after playing this total number of games.\n");

			try{

				Scanner kb = new Scanner(System.in);
				series = kb.nextInt();
				if (series <= 0){
					System.out.println("\nInvalid input. You must enter a positive integer.\n");
				} else if (series % 2 == 0){
					System.out.println("\nInvalid input. You must enter an odd number.\n");
				} else{
					valid_best_of = true;
				}
			} catch (InputMismatchException e){
				System.out.println("\nInvalid input. You must enter an integer.\n");
				valid_best_of = false;
			}		
			
		} while(!valid_best_of);

		min = bestOfMin(series);

		System.out.println("\nYou will be the guesser throughout the game.");

		while(!flag){
			
			Scanner kb = new Scanner(System.in);
			System.out.println("\nEnter your guess. Enter ‘heads’ to guess the coin will land on heads, or ‘tails’ to guess the coin will land on tails.\n");
			guess = kb.next();
			valid_guess = false;

			while(!valid_guess){				
				if (guess.equalsIgnoreCase("heads") || guess.equalsIgnoreCase("tails")){
					valid_guess = true;
				} else {
					System.out.println("\nInvalid input. You must enter 'heads' or 'tails'.\n");
					break;
				}
			}

			if(valid_guess){
				System.out.println("You have guessed " + guess + ".\n");
				System.out.println("The computer flips the coin.\n");

				flip = flipCoin();

				System.out.println("The coin landed on " + flip + ".\n");

				evaluate(flip, guess);

				if(UP == min || CP == min){
					flag = true;
				}
			}
			
		}

		conclusion();
		return gog_score;
	}

	public int bestOfMin(int a){
		int out = ((a/2)+1);
		return out;
	}

	public void evaluate(String f, String g){
		if(f.equalsIgnoreCase(g)){
			System.out.println("Correct guess, the coin landed on " + f + "! You've earned a point.");
			UP++;
			//System.out.println(UP + " player wins.");
		} else {
			System.out.println("Incorrect guess, the coin landed on " + f + ". The computer earned a point.");
			CP++;
			//System.out.println(CP + " computer wins.");
		}
	}

	public void conclusion(){
		if(UP > CP){
			System.out.println("\nCongratulations, you won!\n");
			gog_score = 1;
		} else {
			System.out.println("\nThe computer won, better luck next time.\n");
			gog_score = 0;
		}
	}

	public String flipCoin(){
		Random rand = new Random();

		int a = rand.nextInt(2);
		//System.out.println(a);

		String buffer = "";
		switch(a){
			case 0:
				buffer = "heads";
				break;
			case 1:
				buffer = "tails";
				break;
			default:
				break;
		}

		return buffer;
	}
}