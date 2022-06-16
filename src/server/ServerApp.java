package server;


import java.net.*;
import java.io.*;

public class ServerApp {
    private static Socket          socket   = null;
    private static ServerSocket    server   = null;
    private static DataOutputStream out       =  null;
    private static RandomWordPicker randWordPicker = new RandomWordPicker();

    public static void main(String args[]) {

	    try { 
            server = new ServerSocket(2001);
            System.out.println("Server started");
 
            System.out.println("Waiting for a client ...");
 
            socket = server.accept();

            System.out.println("Client accepted");           

            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(randWordPicker.pickWord());

	    }
        catch (IOException e) {
            
        }
    }
}
