/**
 * This class simply launches the program, a simply random dice game.
 * @author Richard Barney
 * @version 1.0.0 October 2012
*/
public class Assign2 {
	/**
	 * main method as required by JVM
	 * @param  args   standard command line parameters as a string array.
	 */
	public static void main(String[] args) {
		//create Player1 object from data in DieGame.java
		DieGame obj = new DieGame();
		
		// display welcome message and get the bet
		System.out.println("Welcome to the Random Die Game!\nYou have $" 
						 +obj.getPotAmount()
						 +" in your pot."
						 +"\nWin DOUBLE your bet if the two die are the same number!"
						 +"\nWin your bet if the two die total 7 or 11!"
						 +"\nLose your bet if the two die total 6, 8, or 9!"
						 +"\nOtherwise, nothng happens to your pot.\n");
		obj.getBetFromUser();
		
		// play a round
		obj.playRoundOfGame();
	} // end method main
} // end class Assign2