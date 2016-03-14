import java.util.Scanner;

public class Minesweeper {

	private static MineField field;
	private static Ranking rank;	
	public static void main(String[] args) {
		rank=new Ranking();
		mainMessage();
		while(gameCountinue());
		System.out.println("\nThank you for playing :) Have a nice day!");
	}

	//basicly a continues method that determinants wether to continously loop thru the game or not.
	//summary: Prints board, checks user input:"top","restart","exit" or row/column value and acts accordingly. 
	//if none of the above inputs are triggered, then the only other option is a mine is hit and boom() is fetched.
	private static boolean gameCountinue() {

		field = new MineField();
		int result = 0;
		while (true) {

			field.show();
			System.out.print("\nPlease enter your move(row col): ");
			Scanner in = new Scanner(System.in);
			String input = in.nextLine();

			if (input.equals("top")) {
				rank.show();
				continue;
			}
			if (input.equals("restart")) {
				rank.recordName(result);
				return true;
			}
			if (input.equals("exit")) {
				rank.recordName(result);
				return false;
			}
			if (field.legalMoveString(input)) {
				result++;
				if (result == 35) {
					System.out.println("Congratulations you WON the game!");
					rank.recordName(result);
					return true;
				}
				continue;
			}

			
			else if (field.getBoom()) {
				System.out.println("\nBooooooooooooooooooooooooooooom!You stepped on a mine!You survived " + result + " turns");
				rank.recordName(result);
				return true;
			}

		}


	}

	//displays main message.
	private static void mainMessage(){
		System.out.println("Welcome to Minesweeper!");
		System.out.println("To play just input some coordinates and try not to step ont mine :)");
		System.out.println("Usefull commands:");
		System.out.println("restart- Starts a new game.");
		System.out.println("exit- Quits the game.");
		System.out.println("top- Reveals the top scoreboard.");
		System.out.println("Have Fun !");
	}
}
