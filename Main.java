/**
 * Driver program that creates standard 52-card deck (as Card array)
 * and prints out each card in deck.
 *
 * @author Lily Kaplan <lily.kaplan2102@gmail.com>
 * @version 1.0
 */

public class Main {

	/* ALGORITHM
	*
	1. Generate 52 card deck into Card array
	- Uses a nested for loop:
	- - The outer for loop iterates through all the suits
	- - The inner for loop iterates through all the values
	- - The card gets generated in the inner for loop.
	2. Print deck (simple)
	- Prints each suit in its own row
	*
	*/
	public static void main(String[] args) {
		/*** RUNNING TESTER ***/
		//uncomment line below to run CardTester:
		// CardTester.main(null);

		/*** DRIVER PROGRAM ***/
		//1. Generate 52 card deck into Card array
		Card[] deck = new Card[52];
		char[] suits = { Card.HEART, Card.DIAMOND, Card.CLUB, Card.SPADE };
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 13; j++) {
				int index = (13 * i) + j;
				deck[index] = new Card((j + 1), suits[i]);
			}
		}
		
		//2. Print deck
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 13; j++)
			{
				int index = (13 * i) + j;
				System.out.print(deck[index] + " ");
			}
			System.out.println();
		}

	}
}