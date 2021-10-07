package main;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexion {
	private final String HOST = "localhost";
    protected ServerSocket ss; //Socket del servidor
    protected Socket cs; //Socket del cliente
    protected DataOutputStream outServer, outClient;
    protected String messageServer;

    public Conexion(String type,int port) throws IOException 
    {       
    	if(type.equalsIgnoreCase("server"))
        {
            ss = new ServerSocket(port);//Se crea el socket para el servidor en puerto 1234
            cs = new Socket(); //Socket para el cliente
        }
        else
        {
            cs = new Socket(HOST, port); //Socket para el cliente en localhost en puerto 1234
        }
    }
    
}
