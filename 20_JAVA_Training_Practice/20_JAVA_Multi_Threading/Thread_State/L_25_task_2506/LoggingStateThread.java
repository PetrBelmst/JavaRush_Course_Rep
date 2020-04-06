package com.company;

public class LoggingStateThread extends Thread {

    Thread target;

    public LoggingStateThread(Thread target) {
        this.target = target;
    }

    @Override
    public void run() {
        State state;
        State stateRep = null;
        while (true) {
            state = target.getState();
            if (state != stateRep) {
                System.out.println(state);
                stateRep = state;
            }
            if (state == State.TERMINATED) break;
        }
    }
}
