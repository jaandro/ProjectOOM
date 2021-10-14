package main;

public class DeckCards {
	public Card[] deckCards;
	
	public DeckCards() {
		deckCards = new Card[52];
		int i = 0;
		for (int suit = 0; suit <= 3; suit++) {
			for (int value = 1; value <= 13; value++) {
					deckCards[i] = new Card(suit,value);
					i++;
			}
		}	
	}
	
	public void Shuffle() {
		for (int i = 0; i < 51; i++) {
			int random = (int)(Math.random()*(i+1));	
			Card x = deckCards[i];
			deckCards[i] = deckCards[random];
			deckCards[random] = x;
		}

	}
	
}


