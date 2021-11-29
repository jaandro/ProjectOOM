package main;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class Server extends Conexion {
	int port;
	String host;
	final int MAXPLAYERS = 4;
	int numberPlayers;
	int rounds;

	public Server(int port) throws IOException {
		super("server", port);
	}	
	
	public void startServer()
    {
        try {
            System.out.println("Waiting...");
            cs = ss.accept(); 
            System.out.println("Hand of Player: ");            
            outClient = new DataOutputStream(cs.getOutputStream());            
            outClient.writeUTF("Game accepted");            
            BufferedReader entry = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            while((messageServer = entry.readLine()) != null) {
                System.out.println(messageServer);
            }

            System.out.println("Game ended.");
            ss.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getNumberPlayers() {
		return numberPlayers;
	}

	public void setNumberPlayers(int numberPlayers) {
		this.numberPlayers = numberPlayers;
	}

	public int getRounds() {
		return rounds;
	}

	public void setRounds(int rounds) {
		this.rounds = rounds;
	}
		
}
	
	

