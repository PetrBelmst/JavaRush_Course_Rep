package com.company;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {

    int multiply (int x, int y) throws RemoteException;
    double divide (int x, int y) throws RemoteException;
    int sum (int x, int y) throws RemoteException;
    int subtract (int x, int y) throws RemoteException;

}
