package org.example;

public class Motorcycle extends Vehicle {
    public Motorcycle() {
        this.numWheels = 2;
        this.speed = 0;
    }

    @Override
    public void testDrive() {
        this.speed = 75;
    }

    @Override
    public void park() {
        this.speed = 0;
    }
}
