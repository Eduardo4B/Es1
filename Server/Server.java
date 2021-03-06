package Server;

import java.io.*;
import java.net.*;

public class Server
{
    private int porta;
    String stringModificata = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;
    ServerSocket server = null;
    Socket client = null;
    String stringRicevuta = null;
   

    public Server(int porta)
    {
        this.porta = porta;
    }
   
    public Socket attendi()
    {
        try
        {
            System.out.println("1 Server partito in Esecuzione");

            server = new ServerSocket(porta);

            client = server.accept();

            server.close();

            inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            outVersoClient = new DataOutputStream(client.getOutputStream());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Errore Durante La Connessione");
            System.exit(1);
        }

        return client;
    }

    public void comunica()
    {
        try
        {
            System.out.println("3 Benvenuto Client, Scrivi Una Frase E la Trasformo In Maiuscolo. Attendo...");
            stringRicevuta = inDalClient.readLine();
            System.out.println("6 Ricevuta la Stringa Dal Client: " + stringRicevuta);

            stringModificata = stringRicevuta.toUpperCase();
            System.out.println("7 Invio La Stringa Modificata Al Client... ");
            outVersoClient.writeBytes(stringModificata + '\n');

            System.out.println("9 SERVER: Fine Elaborazione .... Buona Notte!!!");
            client.close();
        }  
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Errore Durante La Connessione");
            System.exit(1);
        }
    }
}
