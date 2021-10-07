package main;

import java.io.IOException;

public class MainClient {
	public static void main(String[] args) throws IOException {
        Client client = new Client(1234); 
        System.out.println("Starting client\n");
        client.startClient(); 
    }
}
