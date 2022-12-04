import java.util.Scanner;
import java.util.Random;

public class FindTheRedThread extends getInput {

  int SpoolsPerTurn = 0;
  String[] Spools = new String[20];
  int PlayerScore;
  int ComputerScore;
  String[] PossibleColors = new String[]{"blue", "green", "yellow"};
  int WhosTurn;
  int CompCount = 0;
  int PlayerCount = 0;


  FindTheRedThread(){
    PlayerScore = 0;
    ComputerScore = 0;
  }


  public void PrintSpools(){

    System.out.println("Available spools: ");
    for(int i = 0; i < Spools.length; i++){
      if(Spools[i] != "picked"){
        System.out.printf("Spool %d   ", i+1);
      }
    }
    System.out.println();
  }



  public int run(){
    Scanner reader = new Scanner(System.in);
    Random rand = new Random();

    for(int i = 0; i < Spools.length; i++){         //Assigning each spool a random color
      int RandomColor = rand.nextInt(3);
      Spools[i] = PossibleColors[RandomColor];
    }

    int RedSpool = rand.nextInt(20);              //Assigning a random spool to be the color red
    Spools[RedSpool] = "red";



    System.out.println("Find the Red Thread Game: There is a box filled with 20 spools of thread of various colors—one of these spools is red. You will take turns with the computer picking spools from the box. Each turn, the available spools (the spools still in the box) will be displayed—they will be numbered S1-S20 and each represents a color that is unknown while they are in the box. After you or the computer picks their spool(s), the color of the chosen spool(s) will be displayed. Whoever picks the red spool wins and a point will be added to their overall score board of the Game of Games. You will specify at the start how many spools a player can pull from the box at a time (note: this number must be an integer and cannot be more than half the spools in the box). The computer will randomly generate who will have first pick for the game");
    System.out.println("Enter how many spools a player can pull from the box at a time. Enter an ineteger between 1-10");
    SpoolsPerTurn = getNum(1,10);


    WhosTurn = rand.nextInt(2);
    if(WhosTurn == 0){
      System.out.println("Computer goes first");
    }
    else{
      System.out.println("You go first");
    }

    while(1==1){
      if(WhosTurn == 0){
        int CompPick = -1;
        System.out.println("It is the computer's turn");
        PrintSpools();
        while(CompPick == -1){                  ////Making sure the computer chooses a spool that is available
          CompPick = rand.nextInt(20);
          if(Spools[CompPick-1] == "picked"){
            CompPick = -1;
          }
        }

        System.out.printf("The computer picked spool %d%n", CompPick);
        System.out.printf("The color of spool %d is %s%n%n%n", CompPick, Spools[CompPick-1]);
        CompCount++;
        if(Spools[CompPick-1] == "red"){
          System.out.println("Game Over. You lost against the computer. Better luck next time.");
          return 0;
        }
        Spools[CompPick-1] = "picked";
        if(CompCount == SpoolsPerTurn){
          WhosTurn = 1;
          PlayerCount = 0;
        }
      }

      else{                                   //Player's Turn
        int PlayerPick = -1;
        System.out.println("It is your turn");
        PrintSpools();
        System.out.println();
        while(PlayerPick == -1){
          try{
            System.out.println("Pick a spool from the available options. Enter the integer of the spool you want to pick (1 for S1, 2 for S2, etc.)");
            PlayerPick = reader.nextInt();
            if(PlayerPick < 1 || PlayerPick > 20){
              System.out.println("Error. You must pick within the range of the spools (integer cannot be less than 1 or greater than 20).");
            }
            if(Spools[PlayerPick-1] == "picked"){
              System.out.println("Error. You must pick a spool that is available (look at the display list of all available spools).");
              PlayerPick = -1;
            }
          }
          catch(Exception e){
            System.out.println("Error. You must enter an integer. Try again.");
            reader.next();
            PlayerPick = -1;
          }
        }
        PlayerCount++;
        System.out.printf("You picked spool %d%n", PlayerPick);
        System.out.printf("The color of spool %d is %s%n%n%n", PlayerPick, Spools[PlayerPick-1]);
        if(Spools[PlayerPick-1] == "red"){
          System.out.println("Congratulations, you won!");
          return 1;
        }
        Spools[PlayerPick-1] = "picked";
        if(PlayerCount == SpoolsPerTurn){
          WhosTurn = 0;
          CompCount = 0;
        }





      }







    }


  }

}
