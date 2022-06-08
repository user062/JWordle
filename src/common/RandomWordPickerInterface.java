package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RandomWordPickerInterface extends Remote {
    public String pickWord() throws RemoteException;
}
