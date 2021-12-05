package main;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Client extends Conexion {

	public Client(int port) throws IOException {
		super("client", port);		
	}

	public void startClient() 
    {
		DeckCards deckCards = new DeckCards();
		deckCards.shuffle();
		Hand handPlayer = new Hand();
		Hand handDealer = new Hand();
		
		Scanner entry = new Scanner(System.in);
		int numCardsPlayer = 0;
		int numCardsDealer = 0;
		boolean flag = true;
		boolean flag2 = true;
		
		handPlayer.addToHand(deckCards.takeCard());
		handPlayer.addToHand(deckCards.takeCard());
		
		handDealer.addToHand(deckCards.takeCard());
		handDealer.addToHand(deckCards.takeCard());
		
	
        try {             	
            outServer = new DataOutputStream(cs.getOutputStream());  
            System.out.print("Your Cards: " + "\n");
            while (numCardsPlayer < 2) {                
                outServer.writeUTF(handPlayer.getCard(numCardsPlayer).getValueString() + " of "+ handPlayer.getCard(numCardsPlayer).getSuitString() + "\n");
                System.out.print(handPlayer.getCard(numCardsPlayer).getValueString() + " of "+ handPlayer.getCard(numCardsPlayer).getSuitString() + "\n");                
                numCardsPlayer++;
            }
            System.out.print("\n");
            outServer.writeUTF("\n");
            outServer.writeUTF("Dealer Cards: " + "\n");
            System.out.print("Dealer Cards: " + "\n");
            while (numCardsDealer < 2) {            	
                outServer.writeUTF(handDealer.getCard(numCardsDealer).getValueString() + " of "+ handDealer.getCard(numCardsDealer).getSuitString() + "\n");                
                System.out.print(handDealer.getCard(numCardsDealer).getValueString() + " of "+ handDealer.getCard(numCardsDealer).getSuitString() + "\n");
                numCardsDealer++;
            }
            if(handPlayer.getScore() == 21) {
            	System.out.print("\n");
            	System.out.print("Your score is 21!");
            	outServer.writeUTF("The player's score is 21!");
            }
            
            while (flag == true) {
            	System.out.print("\n");
	            System.out.print("Do you want another card? "+ "\n");
	            System.out.println("Y / N "); 
	            if (entry.next().equals("y") || entry.next().equals("Y")) {
	            	handPlayer.addToHand(deckCards.takeCard());
	            	outServer.writeUTF("The player take card: "+ handPlayer.getCard(numCardsPlayer).getValueString() + " of "+ handPlayer.getCard(numCardsPlayer).getSuitString() + "\n");	            	
	                System.out.print(handPlayer.getCard(numCardsPlayer).getValueString() + " of "+ handPlayer.getCard(numCardsPlayer).getSuitString() + "\n");
	                numCardsPlayer++;
	                System.out.print("Your score is " + handPlayer.getScore()+ "\n");
	                if(handPlayer.getScore() > 21) {
	                	System.out.print("Your score is higher than 21, you lose!"+ "\n");
	                	outServer.writeUTF("The player has lost as his score is higher than 21."+ "\n");
	                	flag = false;
	                	cs.close();
	                }
	                if(handPlayer.getScore() == 21) {
	                	System.out.print("\n");
	                	System.out.print("Your score is 21!"+ "\n");
	                	outServer.writeUTF("The player's score is 21!"+ "\n");
	                }
	            }
	            else { //if (entry.next().equals("n") || entry.next().equals("N")) {
	            	 if(handPlayer.getScore() > 21) {
	            		 System.out.print("\n");
		                	System.out.print("Your score is higher than 21, you lose!"+ "\n");
		                	outServer.writeUTF("The player has lost as his score is higher than 21."+ "\n");
		                	flag = false;
		                	cs.close();
	                }            	 
	            	 System.out.print("\n");
            		 System.out.print("Your score is " + handPlayer.getScore()+ "\n");
            		 outServer.writeUTF("The player's score is " + handPlayer.getScore()+ "\n");
            		 flag = false;    
            		 if(handPlayer.getScore() == 21) {
            			 System.out.print("\n");
                     	System.out.print("Your score is 21!"+ "\n");
                     	outServer.writeUTF("The player's score is 21!"+ "\n");
                     }
            		 
            		 while(handDealer.getScore() < 17 && handDealer.getScore() < handPlayer.getScore() ) {
            			 handDealer.addToHand(deckCards.takeCard());
            			 System.out.print("The dealer takes a card: " + handDealer.getCard(numCardsDealer).getValueString() + " of "+ handDealer.getCard(numCardsDealer).getSuitString() + "\n");
            			 System.out.print("Dealer's score is " + handDealer.getScore()+ "\n");
                		 outServer.writeUTF("Dealer's score is " + handDealer.getScore()+ "\n");
                		 numCardsDealer++;
            		 }
            		 
            		 if(handDealer.getScore() < handPlayer.getScore() || handDealer.getScore() > 21) {
            			 System.out.print("Player WINS!");
            			 outServer.writeUTF("Player WINS!");
            		 }
            		 else if(handDealer.getScore() == handPlayer.getScore()) {
            			 System.out.print("DRAW!");
            			 outServer.writeUTF("DRAW!");
            		 }
            		 else {
            			 System.out.print("Player LOSES!");
            			 outServer.writeUTF("Player LOSES!");
            		 }
	            }
            }
            cs.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
