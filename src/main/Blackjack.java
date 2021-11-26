package main;

public class Blackjack {
	
	
	
	public static int[] play(Hand handPlayer) {
		DeckCards deckCards = new DeckCards();
		deckCards.shuffle();
		Hand handServer = new Hand();
		
		handPlayer.addToHand(deckCards.takeCard());
		handPlayer.addToHand(deckCards.takeCard());
	}
}
