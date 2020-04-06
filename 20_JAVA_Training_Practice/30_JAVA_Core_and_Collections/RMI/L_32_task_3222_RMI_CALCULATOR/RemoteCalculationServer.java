package com.company;

import java.rmi.RemoteException;

public class RemoteCalculationServer implements Calculator{
    @Override
    public int multiply(int x, int y) throws RemoteException {
        return x * y;
    }

    @Override
    public double divide(int x, int y) throws RemoteException {
        return (double) x / y;
    }

    @Override
    public int sum(int x, int y) throws RemoteException {
        return x + y;
    }

    @Override
    public int subtract(int x, int y) throws RemoteException {
        return x - y;
    }
}
