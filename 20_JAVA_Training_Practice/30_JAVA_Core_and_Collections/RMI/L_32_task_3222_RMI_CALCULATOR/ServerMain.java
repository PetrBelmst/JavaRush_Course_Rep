package com.company;


import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerMain {

    public static final String UNIQUE_BINDING_NAME = "server.calculator";

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, InterruptedException{

        final RemoteCalculationServer calculationServer = new RemoteCalculationServer();
	    final Registry registry = LocateRegistry.createRegistry(2055);
	    Remote stubCalculator = UnicastRemoteObject.exportObject(calculationServer, 0);
	    registry.bind(UNIQUE_BINDING_NAME,stubCalculator);
	    Thread.sleep(Integer.MAX_VALUE); // sleep to catch another thread from clientMain
    }
}
