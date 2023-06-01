import java.util.Scanner;
import java.util.Random;

 class Game {

       int systemInput;
	   int userInput;
	   int noofGuesses=0;

	   // generating random number in default constructor
	   Game(){
	       Random random=new Random();
		   this.systemInput=random.nextInt(100)+1;
		   }

		   // method to take user guesses

		   public boolean takeUserInput() {
				if(noofGuesses<10) {
					System.out.print("Guess the number: ");
					this.userInput=GuessTheNumber.takeIntegerInput(100);
					noofGuesses++;
					return false;
				}
				else {
				       System.out.println("Number of attempts finished...\n Better luck next time\n");
					   return true;
                }
			}

			//method to check user guess status

			public boolean iscorrectGuess() {

			       if(systemInput == userInput) {
				         System.out.println("Congratulations, you guess the number "+systemInput+" in " +noofGuesses + " guesses ");
						 switch(noofGuesses) {
							case 1:
							 System.out.println("Your score is 100");
							 break;
							 case 2:
							 System.out.println("Your score is 90");
							 break;
							 case 3:
							 System.out.println("Your score is 80");
							 break;
							 case 4 :
							 System.out.println("Your score is 70");
							 break;
							 case 5:
							 System.out.println("Your score is 60");
							 break;
							 case 6:
							 System.out.println("Your score is 50");
							 break;
							 case 7:
							 System.out.println("Your score is 40");
							 break;
							 case 8:
							 System.out.println("Your score is 30");
							 break;
							 case 9:
							 System.out.println("Your score is 20");
							 break;
							 case 10:
							 System.out.println("Your score is 10");
							 break;
						}
						System.out.println();
						return true;
					}
					else if(noofGuesses < 10 && userInput > systemInput) {
						if(userInput - systemInput > 10) {
							System.out.println("Too High");
						}
						else {
								System.out.println("Little High");
						}
					}
                    else if( noofGuesses < 10 && userInput < systemInput) {
                          if( systemInput - userInput > 10) {
								System.out.println("Too low");
							}
							else {
							       System.out.println("Little Low");
							}
						}
						return false;
					}
			}

//main class
public class GuessTheNumber {


         public static int takeIntegerInput(int limit) {
                 int input = 0;
                boolean x=false;

                while( !x) {
                    try {
                         Scanner sc=new Scanner(System.in);
						 input = sc.nextInt();
						 x=true;

						 if( x && input > limit || input < 1) {
							 System.out.println("Choose the number between 1 to "+limit);
							 x = false;
						 }
					}
					catch( Exception e) {
							System.out.println("Enter only integer value");
							x=false;
				    }
				};
				return input;

		 }

     public static void main(String[] args) {

           System.out.println("1.Start the Game\n2. Exit");
			System.out.println("Enter your choice: ");
			int choice = takeIntegerInput(2);
			int nextRound = 1;
			int noofRound = 0;

			 if( choice == 1) {

				  while( nextRound == 1) {

					    Game game=new Game();
						boolean isMatched=false;
						boolean isLimitCross = false;
				  System.out.println("\nRound "+ ++noofRound + "starts  ");

				  while( !isMatched && !isLimitCross) {
					   isLimitCross =game.takeUserInput();
					   isMatched=game.iscorrectGuess();
				  }
				  // input for next round

				  System.out.println("1.Try Next Round \n 2. Exit");
				  System.out.println("Enter your choice : ");
				  nextRound = takeIntegerInput(2);
				  if(nextRound != 1) {
					  System.exit(0);
			         }
		        }
			 }
			 else {
				 System.exit(0);
			 }
	 }
}