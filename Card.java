/**
 * Represents one playing card from a standard 52-card deck
 * (https://en.wikipedia.org/wiki/Playing_card)
 *
 * Class Invariant:
 * - Card value represents the number/letter printed on the card,
 * usually in the corners (A, 2, 3, ..., 9, 10, J, Q, K)
 * - Card value is stored as an integer to make error checking/validation easier,
 * but must be outputted appropriately (1 is A, 11 is J, 12 is Q, 13 is K) for user
 * - Card suit represents one of 4 suits (heart, diamond, club, spade)
 * - Card suit is stored as the unicode char representing the suit,
 * constant variables will be used throughout code for consistency
 * - Whenever value/suit is changed, it must be within the valid values
 *
 * @author Lily Kaplan <lily.kaplan2102@gmail.com>
 * @version 1.0
 */

/*
 * UML CLASS DIAGRAM:
 * -------------------------------------------------------
 *   Card
 * -------------------------------------------------------
 * - value : int
 * - suit : char
 * + HEART : char			//static constant with value ♥
 * + DIAMOND : char			//static constant with value ♦
 * + CLUB : char			//static constant with value ♣
 * + SPADE : char			//static constant with value ♠
 * + DEFAULT_VALUE : int	//static constant with value 1
 * + DEFAULT_SUIT : char	//static constant with value ♥
 * -------------------------------------------------------
 * + Card()
 * + Card(value : int, suit : char)
 * + Card(original : Card)
 * + setValue(value : int) : boolean
 * + setSuit(suit : char) : boolean
 * + setAll(value : int, suit : char) : boolean
 * + getSuit() : char
 * + getValue() : int
 * + getPrintValue() : String
 * + getPrintCard() : String
 * + toString() : String
 * + equals(otherCard : Card) : boolean
 * + printCard() : void
 * -------------------------------------------------------
 */

public class Card {

	/*** CONSTANT VARIABLES ***/
	public static final char HEART = '♥';
	public static final char DIAMOND = '♦';
	public static final char CLUB = '♣';
	public static final char SPADE = '♠';
	public static final int DEFAULT_VALUE = 1;
	public static final char DEFAULT_SUIT = '♥';

	/*** INSTANCE VARIABLES ***/
	private int value;
	private char suit;


	/*** CONSTRUCTOR METHODS ***/
	/**
	 * Default constructor, builds default card object as: A ♥
	 */
	public Card()
	{
		this.setAll(DEFAULT_VALUE, DEFAULT_SUIT);
	}




	/**
	 * Full constructor builds object with all data for instance variables provided.
	 * If arguments are not valid, program shuts down with error message
	 *
	 * @param value numerical value of card (1-13), not what shows on card (A, 2-10,
	 *              J, Q, K)
	 * @param suit  one of four suit values (unicode value for heart, diamond,
	 *              spade, or club)
	 */
	public Card(int value, char suit)
	{
		if(!this.setValue(value))
		{
			System.out.printf("ERROR: Value out of range. Attempted to set value to %d. Exiting...%n", value);
			System.exit(1);
		}
		if(!this.setSuit(suit))
		{
			System.out.println("ERROR: Invalid suit entered. Exiting...");
			System.exit(2);
		}
	}


	/**
	 * Copy constructor builds object with all data from Card object provided. No
	 * changes made to original object, no shallow copying
	 *
	 * @param original Card object to be copied
	 */
	public Card(Card original)
	{
		if (original != null)
		{
			setAll(original.getValue(), original.getSuit());
		}
		else
        {
            System.out.println("CRITICAL ERROR: Attempted to copy null Card. Exiting...");
            System.exit(3);
        }
	}


	/*** MUTATOR METHODS (SETTERS) ***/
	/**
	 * Sets value for card only if valid, otherwise will not change instance
	 * variable. Returns boolean representing whether error occured (false) or
	 * operation completed successfully (true)
	 *
	 * @param value numerical value of card (1-13), not what shows on card (A, 2-10,
	 *              J, Q, K)
	 *
	 * @return true if card value is between 1 and 13 (inclusive), false otherwise
	 */
	public boolean setValue(int value)
	{
		if((value < 1) || (value > 13))
		{
			return false;
		}
		else
		{
			this.value = value;
			return true;
		}
	}


	/**
	 * Sets suit for card only if valid, otherwise will not change instance
	 * variable. Returns boolean representing whether error occured (false) or
	 * operation completed successfully (true)
	 *
	 * @param suit one of four suit values (unicode value for heart, diamond, spade,
	 *             or club)
	 *
	 * @return true if card suit is unicode value for heart, diamond, club or spade.
	 *         false otherwise
	 */
	public boolean setSuit(char suit)
	{
		if((suit == HEART) || (suit == DIAMOND) || (suit == SPADE) || (suit == CLUB))
		{
			this.suit = suit;
			return true;
		}
		else
		{
			return false;
		}
	}


	/**
	 * Sets suit and value for card only if valid, returns boolean representing
	 * whether error occured (false) or operation completed successfully (true)
	 *
	 * @param value numerical value of card (1-13), not what shows on card (A, 2-10,
	 *              J, Q, K)
	 * @param suit  one of four suit values (unicode value for heart, diamond,
	 *              spade, or club)
	 *
	 * @return true if card value AND suit are valid, false otherwise
	 */
	public boolean setAll(int value, char suit)
	{
		if(this.setValue(value) && this.setSuit(suit))
		{
			return true;
		}
		else
		{
			return false;
		}

	}


	/*** ACCESSOR METHODS (GETTERS) ***/
	/**
	 * Access unicode character representing suit of card
	 *
	 * @return suit as unicode character for heart, spade, diamond, or club
	 */
	public char getSuit()
	{
		return this.suit;
	}


	/**
	 * Access numerical value of card (1-13)
	 *
	 * @return value as raw integer 1-13 (not what player sees as A, 2-10, J, Q, K;
	 *         see {@link #getPrintValue()})
	 */
	public int getValue()
	{
		return this.value;
	}


	/**
	 * Access value of card as seen by user (A, 2-10, J, Q, K) that would be printed
	 * on card
	 *
	 * @return value as String user sees on card (A, 2-10, J, Q, K), not numerical
	 *         value 1-13 (see {@link #getValue()})
	 */
	public String getPrintValue()
	{
		int tempValue = this.getValue();
		if(tempValue == 1)
		{
			return "A";
		}
		else if ((tempValue >= 2) && (tempValue <= 10))
		{
			return Integer.toString(tempValue);
		}
		else if (tempValue == 11)
		{
			return "J";
		}
		else if (tempValue == 12)
		{
			return "Q";
		}
		else if (tempValue == 13)
		{
			return "K";
		}
		else
		{
			return "A";
		}

	}


	/**
	 * Access ASCII art version of card data, each line separated by newline
	 * character, no newline character at end of String
	 *
	 * @return String containing ASCII art with card suit and card print value
	 */
	public String getPrintCard()
	{
		String valueString = this.getPrintValue();
		String outputString = "-------";
		outputString += String.format("|%c   %c|%n", suit, suit);
		outputString += String.format("|  %s  |%n", valueString);
		outputString += String.format("|%c   %c|%n", suit, suit);
		outputString += "-------";
		return outputString;
	}


	/*** OTHER REQUIRED METHODS ***/
	/**
	 * String of all instance variables, no newline character at end of String.
	 * Using print value to use as "condensed" version of printed card (ex: A ♥)
	 * 
	 * @return String containing (print) value and suit, separated by a space
	 */
	public String toString()
	{
		return this.getPrintValue() + " " + this.suit;
	}


	/**
	 * Checking for equality of Card objects, all instance variables exactly equal
	 * to each other (case-sensitive). Argument object not changed
	 * 
	 * @param other Card object to compare for equality
	 * 
	 * @return boolean representing equality between both objects, all data is
	 *         exactly equal to each other
	 */
	public boolean equals(Card other)
	{
		return this.value == other.value
			&& this.suit == other.suit;
	}


	/*** EXTRA METHODS ***/
	/**
	 * Prints card ASCII art to console (see {@link #getPrintCard()})
	 */



}
