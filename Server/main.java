package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main 
{
    public static void main(String args[]) throws IOException
    {
        
        String portaClient = "";      

        System.out.println("Inserire Porta Server");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        portaClient = br.readLine(); 
        
        Server server = new Server(Integer.valueOf(porta));
        
        server.attendi();
        server.comunica();
    }
}