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
	
	public void startServer()//Método para iniciar el servidor
    {
        try
        {
            System.out.println("Waiting..."); //Esperando conexión
            cs = ss.accept(); //Accept comienza el socket y espera una conexión desde un cliente
            System.out.println("Client online");

            //Se obtiene el flujo de salida del cliente para enviarle mensajes
            outClient = new DataOutputStream(cs.getOutputStream());

            //Se le envía un mensaje al cliente usando su flujo de salida
            outClient.writeUTF("Request accepted");

            //Se obtiene el flujo entrante desde el cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));

            while((messageServer = entrada.readLine()) != null) //Mientras haya mensajes desde el cliente
            {
                System.out.println(messageServer);
            }

            System.out.println("Conexion ended.");

            ss.close();//Se finaliza la conexión con el cliente
        }
        catch (Exception e)
        {
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
	
	

