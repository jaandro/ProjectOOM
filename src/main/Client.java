package main;

import java.io.DataOutputStream;
import java.io.IOException;

public class Client extends Conexion {

	public Client(int port) throws IOException {
		super("client", port);		
	}

	public void startClient() 
    {
		DeckCards deckCards = new DeckCards();
		deckCards.shuffle();
		Hand handPlayer = new Hand();
		cs = ss.accept(); 
		handPlayer.addToHand(deckCards.takeCard());
		handPlayer.addToHand(deckCards.takeCard());
        try {            
            outServer = new DataOutputStream(cs.getOutputStream());          
            for (int i = 0; i < 2; i++) {                
                outServer.writeUTF(handPlayer.getCard(i).getValueString() + " of "+ handPlayer.getCard(i).getSuitString() + "\n");
                System.out.print(handPlayer.getCard(i).getValueString() + " of "+ handPlayer.getCard(i).getSuitString() + "\n");
            }
            cs.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
