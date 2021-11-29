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
	}
	
	public Card getCard(int pos) {
		if (pos >= 0 && pos < hand.size()) {return (Card)hand.get(pos);}
		else
			return null;
	}
	
	public int getScore() {
		boolean as = false;
		score = 0;
		for(int i = 0; i < hand.size(); i++) {
			//if(score < 21) {
				value = hand.get(i).getValue();
				if(value > 10) {value = 10;}
				else if(value == 1) {
					as = true;
				}
				if(as == true && score + 11 <= 21) {
					score = score + 11;
				}
				else {score = score + value;}
			}	
		//}		
		//if(score > 21) {return -1;}
		return score;
	}
}
