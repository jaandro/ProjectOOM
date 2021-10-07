package main;

import java.io.DataOutputStream;
import java.io.IOException;

public class Client extends Conexion {

	public Client(int port) throws IOException {
		super("client", port);		
	}

	public void startClient() 
    {
        try {            
            outServer = new DataOutputStream(cs.getOutputStream());          
            for (int i = 0; i < 2; i++) {                
                outServer.writeUTF("Message: " + (i+1) + "\n");
            }
            cs.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
