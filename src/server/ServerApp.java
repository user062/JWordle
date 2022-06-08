package server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.*;

public class ServerApp {

    public static void main(String args[]) {
        RandomWordPicker randWordPicker;
	    try { 
            randWordPicker = new RandomWordPicker(); 

	    } catch (java.rmi.RemoteException e) { 
	      System.out.println("!!! --> Cannot instantiate the Server"); 
	      e.printStackTrace();
	      return;
	    } 

	    try {
		    LocateRegistry.createRegistry(2001);
            Naming.rebind("rmi://localhost:2001/randwordpicker", randWordPicker); 
            System.out.println("randwordpicker bound in registry at the localhost "); 
            System.out.println("rmi://localhost:2001/randwordpicker"); 
	    } catch (SecurityException e) { 
            System.out.println("!!! --> A SecurityManager has been installed but the policy file has not been set properly"); 
            e.printStackTrace(); 
	    } catch (java.net.MalformedURLException e) { 
            e.printStackTrace(); 
	    } catch (java.rmi.RemoteException e) { 
            System.out.println("!!! --> There is no RMI Registry running on that host : Cannot bind the HelloServer"); 
            e.printStackTrace(); 
	    } 
	  }
           
}
