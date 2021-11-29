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
		int numCards = 0;
		boolean flag = true;
		
		handPlayer.addToHand(deckCards.takeCard());
		handPlayer.addToHand(deckCards.takeCard());
		
	
        try {             	
            outServer = new DataOutputStream(cs.getOutputStream());            
            while (numCards < 2) {                
                outServer.writeUTF(handPlayer.getCard(numCards).getValueString() + " of "+ handPlayer.getCard(numCards).getSuitString() + "\n");
                System.out.print(handPlayer.getCard(numCards).getValueString() + " of "+ handPlayer.getCard(numCards).getSuitString() + "\n");
                numCards++;
            }
            if(handPlayer.getScore() == 21) {
            	System.out.print("Your score is 21!");
            	outServer.writeUTF("The player's score is 21!");
            }
            
            while (flag == true) { 
	            System.out.print("Do you want another card? "+ "\n");
	            System.out.println("Y / N "); 
	            if (entry.next().equals("y") || entry.next().equals("Y")) {
	            	handPlayer.addToHand(deckCards.takeCard());
	            	outServer.writeUTF("The player take card: "+ handPlayer.getCard(numCards).getValueString() + " of "+ handPlayer.getCard(numCards).getSuitString() + "\n");	            	
	                System.out.print(handPlayer.getCard(numCards).getValueString() + " of "+ handPlayer.getCard(numCards).getSuitString() + "\n");
	                numCards++;
	                System.out.print("Your score is " + handPlayer.getScore()+ "\n");
	                if(handPlayer.getScore() > 21) {
	                	System.out.print("Your score is higher than 21, you lose!"+ "\n");
	                	outServer.writeUTF("The player has lost as his score is higher than 21."+ "\n");
	                	flag = false;
	                	cs.close();
	                }
	                if(handPlayer.getScore() == 21) {
	                	System.out.print("Your score is 21!"+ "\n");
	                	outServer.writeUTF("The player's score is 21!"+ "\n");
	                }
	            }
	            else if (entry.next().equals("n") || entry.next().equals("N")) {
	            	 if(handPlayer.getScore() > 21) {
		                	System.out.print("Your score is higher than 21, you lose!"+ "\n");
		                	outServer.writeUTF("The player has lost as his score is higher than 21."+ "\n");
		                	flag = false;
		                	cs.close();
	                }            	 
            		 System.out.print("Your score is " + handPlayer.getScore()+ "\n");
            		 outServer.writeUTF("The player's score is " + handPlayer.getScore()+ "\n");
            		 flag = false;    
            		 if(handPlayer.getScore() == 21) {
                     	System.out.print("Your score is 21!"+ "\n");
                     	outServer.writeUTF("The player's score is 21!"+ "\n");
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
