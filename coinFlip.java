import java.util.Scanner;
import java.util.Random;

public class coinFlip extends getInput{

		int UP;						// User Points (wins)
		int CP;						// Computer Points (losses)
		int min;					// Minimum needed wins
		int gog_score;				// Returns if User wins series
		
		String guess;				// Heads or Tails guess by player
		String flip;				// Coin flip result
		
		boolean flag = false; 

	// THE METHOD THAT RUNS THE ACTUAL GAME //
	public int run(){
		
		UP = 0;
		CP = 0;

		System.out.println("Flip the Coin: The game is about guessing if a flipped coin lands on heads or tails.\n\n"
						+ "The player will be playing against the computer and will be the one guessing throughout the rest of the number of agreed games.\n\n"
						+ "The total number of agreed games to be played before finding the winner  is called “best out of number”.\n\n"
						+ "If the player guesses correctly they get a point and if it’s incorrect, the computer earns a point.\n\n"
						+ "Whoever has the most points after the agreed total games wins a point that will be added to their overall score board of Games of games.\n\n");

		// ENTERING THE BEST-OF NUMBER TO PLAY OUT OF //
		System.out.println("\nEnter the 'best out of number' you want to play –– this must be an odd integer. The player with the most points will be declared as the winner after playing this total number of games.\n");
		min = bestOfMin(getBestOf());

		System.out.println("\nYou will be the guesser throughout the game.");
		
		// THE INPUT OF GUESSING HEADS/TAILS //
		while(!flag){
			
			System.out.println("\nEnter your guess. Enter ‘heads’ to guess the coin will land on heads, or ‘tails’ to guess the coin will land on tails.\n");
			guess = getString("heads", "tails");

			System.out.println("You have guessed " + guess + ".\n");
			System.out.println("Flipping the coin....\n");
			
			// SIMULATE/RETURN THE COIN FLIP //
			flip = flipCoin();

			System.out.println("The coin landed on " + flip + ".\n");

			// EVALUATING THE GUESS AND THE COIN FLIP RESULT //
			evaluate(flip, guess);
			
			// SETTING THE FLAG ONCE EITHER THE USER OR COMPUTER REACHES THE MINIMUM AMOUNT OF WINS
			if(UP == min || CP == min){
				flag = true;
			}
		}
		
		// CONCLUSION GETS ANALYZED AND WIN/LOSS GETS RETURNED //
		conclusion();
		return gog_score;
		}

	public int bestOfMin(int a){
		int out = ((a/2)+1);
		return out;}
	
	// The evaluation of who wins //
	public void evaluate(String f, String g){
		if(f.equalsIgnoreCase(g)){
			System.out.println("Correct guess, the coin landed on " + f + "! You've earned a point.");
			UP++;
			//System.out.println(UP + " player wins.");
		} else {
			System.out.println("Incorrect guess, the coin landed on " + f + ". The computer earned a point.");
			CP++;
			//System.out.println(CP + " computer wins.");
		}}
	
	// Setting the return/Printing of who won the series //
	public void conclusion(){
		if(UP > CP){
			System.out.println("\nCongratulations, you won!\n");
			gog_score = 1;
		} else {
			System.out.println("\nThe computer won, better luck next time.\n");
			gog_score = 0;
		}}

	// Simulation of the actual flipping of the coin //
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

		return buffer;}
}
