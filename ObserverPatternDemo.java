package com.tutorialspoint;

import java.util.ArrayList;
import java.util.List;

// Main class
public class ObserverPatternDemo {
    public static void main(String[] args) {

        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);

        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}

// Subject class
class Subject {

    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }
}

// Observer Interface
interface Observer {
    void update();
}

// Binary Observer
class BinaryObserver implements Observer {

    private Subject subject;

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println(
            "Binary String: " + Integer.toBinaryString(subject.getState())
        );
    }
}

// Octal Observer
class OctalObserver implements Observer {

    private Subject subject;

    public OctalObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println(
            "Octal String: " + Integer.toOctalString(subject.getState())
        );
    }
}

// Hexa Observer
class HexaObserver implements Observer {

    private Subject subject;

    public HexaObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println(
            "Hex String: " +
            Integer.toHexString(subject.getState()).toUpperCase()
        );
    }
}
