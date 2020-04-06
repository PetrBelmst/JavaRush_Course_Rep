package com.company;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientMain {

    public static final String UNIQUE_BINDING_NAME = "server.calculator";

    public static void main(String[] args) throws RemoteException, NotBoundException {

        Registry registry = LocateRegistry.getRegistry(2055);
        Calculator calculator = (Calculator) registry.lookup(UNIQUE_BINDING_NAME);
        int resultOfCalculation = calculator.multiply(3,5);
        System.out.println(resultOfCalculation);
    }
}









