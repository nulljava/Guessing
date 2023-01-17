// David Huang
// September 28th
// Guessing Game

import java.util.*;

public class Guessing 
{

	public static int getRandomNumber(int low, int high)
	{
		// Math.random() returns a decimal in the range [0, 1)
		// Pick a low and high value and test this out.  Can the 
		// computer choose the low and high bounds as its number?
		int rand = (int) (Math.random() * (high - low + 1)) + low;
		return rand;
	}
	
	public static String compareToSecret(int guessedNum, int secretNum)
	{
		String guessIs = "";
		if (guessedNum < secretNum)
			guessIs = "low";
		else if (guessedNum == secretNum)
			guessIs = "correct";
		else 
			guessIs = "high";
		return guessIs;
	}
	
	public static boolean inRange(int low, int high, int num)
	{
		if (low <= num && num <= high)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void main(String[] args) { 
	Scanner userInput = new Scanner(System.in);
	String again;
	do {
		System.out.println("Enter your name: ");
		String name = userInput.nextLine();
		System.out.println("Welcome " + name + "!");
		
		System.out.println("Enter low range.");		
		int lowest = userInput.nextInt();
		System.out.println("Enter high range.");
		int highest = userInput.nextInt();
		if (highest < lowest)
		{	
			throw new IllegalArgumentException((String) "Highest range is lower than lowest range.");
		}
		int secret = getRandomNumber(lowest, highest);
		
		System.out.println("Enter the guess.");		
		int guess = userInput.nextInt();
		if (inRange (lowest, highest, guess) == false) {	
			throw new IllegalArgumentException((String) "Guess is either: higher than highest range OR lower than lowest range.");
		}
		
		if (secret == guess)
		{
			System.out.println("You guessed right!");
			System.out.println("My number was " + secret + "!");
			System.out.println("Play again? (Y/N)");
			again = userInput.nextLine();
		}
		else 
		{
			String lowHigh = compareToSecret(guess, secret);
			System.out.println("Nope. " + guess + " is too " + lowHigh);
			System.out.println("Guess again? (Y/N)");
			again = userInput.nextLine();
		}
		again = userInput.nextLine();
				
		}
		while (again.equalsIgnoreCase("Y"));

}
}
