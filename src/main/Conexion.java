package main;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexion {
	private final String HOST = "localhost";
    protected ServerSocket ss; 
    protected Socket cs; 
    protected DataOutputStream outServer, outClient;
    protected String messageServer;

    public Conexion(String type,int port) throws IOException 
    {       
    	if(type.equalsIgnoreCase("server")) {
            ss = new ServerSocket(port);
            cs = new Socket(); 
        }
        else {
            cs = new Socket(HOST, port);
        }
    }
    
}
