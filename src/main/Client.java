package main;

import java.io.DataOutputStream;
import java.io.IOException;

public class Client extends Conexion {

	public Client(int port) throws IOException {
		super("client", port);		
	}

	public void startClient() //M�todo para iniciar el cliente
    {
        try {
            //Flujo de datos hacia el servidor
            outServer = new DataOutputStream(cs.getOutputStream());

            //Se enviar�n dos mensajes
            for (int i = 0; i < 2; i++)
            {
                //Se escribe en el servidor usando su flujo de datos
                outServer.writeUTF("Este es el mensaje n�mero " + (i+1) + "\n");
            }

            cs.close();//Fin de la conexi�n

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
