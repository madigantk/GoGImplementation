import java.util.Scanner;
import java.util.Random;

public class FindTheRedThread{

  int SpoolsPerTurn = 0;
  String[] Spools = new String[20];
  int PlayerScore;
  int ComputerScore;
  String[] PossibleColors = new String{"blue","green","yellow"};

  FindtheRedThread(){
    PlayerScore = 0;
    ComputerScore = 0;
  }

  public int game(){
    Scanner reader = new Scanner(System.in);
    Random rand = new Random();
    System.out.println("Find the Red Thread Game: There is a box filled with 20 spools of thread of various colors—one of these spools is red. You will take turns with the computer picking spools from the box. Each turn, the available spools (the spools still in the box) will be displayed—they will be numbered S1-S20 and each represents a color that is unknown while they are in the box. After you or the computer picks their spool(s), the color of the chosen spool(s) will be displayed. Whoever picks the red spool wins and a point will be added to their overall score board of the Game of Games. You will specify at the start how many spools a player can pull from the box at a time (note: this number must be an integer and cannot be more than half the spools in the box). The computer will randomly generate who will have first pick for the game");
    while(SpoolsPerTurn = 0){
      System.out.println("Enter how many spools a player can pull from the box at a time. Enter an ineteger between 1-10")
      SpoolsPerTurn = reader.nextInt();
      if(SpoolsPerTurn < 1 || SpoolsPerTurn > 10){
        System.out.println("Error. You must enter an integer between 1-10. Try again.");
        SpoolsPerTurn = 0;
      }
    }
    int x = random.nextInt(2);
    if(x = 0){
      System.out.println("Computer goes first");
      System.out.println("It is the computer's turn");
      System.out.println("Available spools")
    }
    else{
      System.out.println("You go first");
    }


  }


}
