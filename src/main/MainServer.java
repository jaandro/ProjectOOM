package main;

import java.io.IOException;

public class MainServer {
	 public static void main(String[] args) throws IOException
	    {
	        Server server = new Server(1234); //Se crea el servidor
	        System.out.println("Starting server\n");
	        server.startServer(); //Se inicia el servidor
	    }
}
