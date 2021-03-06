package Client;

import java.io.*;
import java.net.*;

public class Client{
    
private int porta;
String nomeServer ="nomeServer";
int portaServer = 6789;
DataInputStream in;
DataOutputStream out;

public Client(int porta)
    {
        this.porta = porta;
    }
protected Socket connetti() throws IOException{

    System.out.println("2 CLIENT partito in esecuzione ");

        try
        {
            tastiera = new BufferedReader(new InputStreamReader(System.in));

            mioSocket = new Socket(nomeServer, portaServer);

            outVersoServer = new DataOutputStream(mioSocket.getOutputStream());
            inDalServer = new BufferedReader(new InputStreamReader(mioSocket.getInputStream()));

        }
        catch(UnknownHostException e)
        {
            System.out.print("Host Sconosciuto");
        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Errore Durante La Connessione");
            System.exit(1);
        }

        return mioSocket;
    }

    public void comunica()

    {
        try
        {
            System.out.println("4... Inserisci la stringa da trasmettere al server " + '\n');
            stringUtente = tastiera.readLine();

            System.out.println("5... Invio la stringa al server e attendo");
            outVersoServer.writeBytes(stringUtente + '\n');

            System.out.println("8 Ho La Risposta Dal Server... ");

            stringRicevutaDalServer = inDalServer.readLine();

            System.out.println(stringRicevutaDalServer);
            System.out.println("9 CLIENT: Termina Elaborazione E Chiude Connessione");
            mioSocket.close();
        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Errore Durante La Connessione");
            System.exit(1);
        }
    }

}
