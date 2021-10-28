package main;

import java.util.ArrayList;

public class Hand {
	public ArrayList<Card> hand = new ArrayList<Card>();
	public int score;
	public int value;
	
	public void addToHand(Card card) {
		if(card != null) {
			hand.add(card);
		}
		score = 0;
		getScore();
	}
	
	public void getScore() {
		for(int i = 0; i < hand.size(); i++) {
			if
			score = score + value;
		}
		
		if(score > 21) {F}
	}
}
