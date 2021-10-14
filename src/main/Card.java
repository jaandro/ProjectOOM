package main;

public class Card {
	public final static int SWORDS = 0, SPADES = 1, HEARTS = 2, DIAMONDS = 3;	
	private int suit;
	private int value;
	
	public Card(int suit, int value) {
		this.suit = suit;
		this.value = value;
	}

	public int getSuit() {
		return suit;
	}

	public int getValue() {
		return value;
	}
	
	public String getSuitString() {
		switch(suit) {
		case SWORDS: return "Swords";
		case SPADES: return "Spades";
		case HEARTS: return "Hearts";
		case DIAMONDS: return "Diamonds";
		}
		return null;		
	}
	
	public String getValueString() {
		switch (value) {
		case 1: return "AS";
		case 2: return "2";
		case 3: return "3";
		case 4: return "4";
		case 5: return "5";
		case 6: return "6";
		case 7: return "7";
		case 8: return "8";
		case 9: return "9";
		case 10: return "10";
		case 11: return "J";
		case 12: return "Q";
		case 13: return "K";
		}
		return null;
	}
	
}
