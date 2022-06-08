package server;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import common.RandomWordPickerInterface;

public class RandomWordPicker extends UnicastRemoteObject implements RandomWordPickerInterface {
    private Random rng = new Random();
    private ArrayList<String> words = new ArrayList<String>(Arrays.asList(new String[]{"hello", "world"}));

    public RandomWordPicker() throws RemoteException {
        super(2001);
    }

    public String pickWord() {
        return this.words.get(rng.nextInt(words.size()));
    }
}
