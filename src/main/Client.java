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
            while (flag == true) { 
	            System.out.print("Do you want another card? ");
	            System.out.println("Y / N "); 
	            if (entry.next().equals("y") || entry.next().equals("Y")) {
	            	handPlayer.addToHand(deckCards.takeCard());
	            	outServer.writeUTF("The player take card: "+ handPlayer.getCard(numCards).getValueString() + " of "+ handPlayer.getCard(numCards).getSuitString() + "\n");
	            	numCards++;
	                System.out.print(handPlayer.getCard(numCards).getValueString() + " of "+ handPlayer.getCard(numCards).getSuitString() + "\n");
	            }
	            else if (entry.next().equals("n") || entry.next().equals("N")) {flag = false;}
            }
            cs.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
