
/**
 * This class handles all the data and math for the random dice game.
 * @author Richard Barney
 * @version 1.0.0 October 2012
*/
//import statements
import java.util.Random;
import java.util.Scanner;
public class DieGame {

	/** int to hold the pot amount */
	private int nPotAmount;
	/** int to hold the bet amount */
	private int nBetAmount;
	/** Random object use for dice generation */
	Random randomDie = new Random();

	/** 
	 * Default constructor, player starts with $100
	 */
	public DieGame() {
		nPotAmount = 100;
		nBetAmount = 1;
	}
	
	/**
	 * Get method that returns the bet amount.
	 * @return the bet amount.
	 */
	public int getBetAmount() {	return nBetAmount; }
	/**
	 * Get method that returns the pot amount.
	 * @return the pot amount.
	 */
	public int getPotAmount() { return nPotAmount; }
	
	/** 
	 * Set method that sets the bet amount.
	 * @param	nBetAmount	the amount entered as a bet.
	 */
	public void setBetAmount(int nBetAmount) { this.nBetAmount = nBetAmount; }
	/**
	 * Set method that sets the pot amount.
	 * @param	nPotAmount	the player's pot.
	 */
	public void setPotAmount(int nPotAmount) { this.nPotAmount = nPotAmount;	}
	
	/**
	 * Method that returns the randomized die values between 1 and 6.
	 * @return the die value
	 */
	public int rollDie() {
		int nDie = randomDie.nextInt(6) + 1;
		return nDie;
	} // end method rollDie
	
	/**
	 * Get the bet from the user.	
	 */
	public void getBetFromUser() {
		Scanner input = new Scanner (System.in);
		// keep asking for input if number entered is less than 0 or greater than pot
		do {
			System.out.println("Please enter a valid bet, or enter 0 to quit: ");
			nBetAmount = input.nextInt();
		} while (getBetAmount() < 0 || getBetAmount() > getPotAmount() && getPotAmount() > 0);
	} // end method getBetFromUser
	

	/**
	 * Play a round of the game that will keep looping as long as player still has money in his pot
	 * or if he does not enter 0, which quits the program.
	 */
	public void playRoundOfGame() {				
		// keep looping while the pot is greater than 0 and the bet amount is not greater than the pot amount
		while (getBetAmount() > 0) {
			// get the die values
			int nDie1 = rollDie();
			int nDie2 = rollDie();
			
			// display the bet amount, results of random die rolls, and die total
			System.out.println("You bet $" +getBetAmount()
							 +".\nYou rolled a "
							 +nDie1
							 +" and a "
							 +nDie2
							 +", which totals "
							 +(nDie1 + nDie2));
			
			// if the two die equal the same number, player wins double their bet
			if (nDie1 == nDie2) {
				nPotAmount = getPotAmount() + getBetAmount() * 2;
				System.out.println("Incredible! You rolled doubles! You've won double your bet amount!"
								 +"\nYou now have $"
								 +getPotAmount()
								 +" in your pot.");
			}
			
			// if the two die equal 7 or 11, player wins their bet
			if (nDie1 + nDie2 == 7 || nDie1 + nDie2 == 11) {
				nPotAmount = getPotAmount() + getBetAmount();
				System.out.println("You win your bet amount ($"
								 +getBetAmount()
								 +")!"
								 +"\nYou now have $"
								 +getPotAmount()
								 +" in your pot.");
			}
			
			// if the two die equal 5 or less, 10, or 12 and the two die are not the same number, nothing happens
			if (nDie1 + nDie2 <=5 && nDie1 != nDie2 || nDie1 + nDie2 == 10 && nDie1 != nDie2 || nDie1 + nDie2 == 12 && nDie1 != nDie2) {
				System.out.println("You do not gain or lose your bet amount."
								 +"\nYou still have $"
								 +getPotAmount()
								 +" in your pot.");
			}

			// if the two die equal 6, 8, or 9 and are not the same number, player loses the bet
			if (nDie1 + nDie2 == 6 && nDie1 != nDie2 || nDie1 + nDie2 == 8 && nDie1 != nDie2 || nDie1 + nDie2 == 9 && nDie1 != nDie2) {
				nPotAmount = getPotAmount() - getBetAmount();
				System.out.println("Oh no! You lost $"
								 +getBetAmount()
								 +" from your pot!\nYou now have $"
								 +getPotAmount()
								 +" in your pot.");
				// end program if pot is empty
				if (getPotAmount() == 0) {
					System.out.print("Oh no! You have run out of money!\nGame over!");
					return;
				}
			}
			
			// get bet again
			getBetFromUser();
		} // end big while statement
		
		//if player bets 0, end game
		if (getBetAmount() == 0) {
			System.out.print("You have bet $0 and ended the game.\nGoodbye.");
		}
	} // end method playRoundOfGame
} // end class DieGame