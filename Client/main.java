package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main 
{
    public static void main( String[] args ) throws IOException
    {
        String nomeSever = "";     
        String portaServer = "";         
        
        System.out.println("Inserire indirizzo IP");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nomeSever = br.readLine();  
        
        System.out.println("Inserire Porta Server");        
        portaServer = br.readLine();  

        Client client = new Client(nomeServer, Integer.valueOf(portaServer));
        
        client.connetti();
        client.comunica();
    }
}