import static org.junit.jupiter.api.Assertions.*;

import org.example.Car;
import org.example.Motorcycle;
import org.example.Vehicle;
import org.junit.jupiter.api.Test;

class VehicleTest {

    @Test
    void testCarIsInstanceOfVehicle() {
        Vehicle car = new Car();
        assertTrue(car instanceof Vehicle);
    }

    @Test
    void testCarHasFourWheels() {
        Car car = new Car();
        assertEquals(4, car.getNumWheels());
    }

    @Test
    void testMotorcycleHasTwoWheels() {
        Motorcycle motorcycle = new Motorcycle();
        assertEquals(2, motorcycle.getNumWheels());
    }

    @Test
    void testCarTestDriveSetsSpeedTo60() {
        Car car = new Car();
        car.testDrive();
        assertEquals(60, car.getSpeed());
    }

    @Test
    void testMotorcycleTestDriveSetsSpeedTo75() {
        Motorcycle motorcycle = new Motorcycle();
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed());
    }

    @Test
    void testCarParkSetsSpeedToZero() {
        Car car = new Car();
        car.testDrive();
        car.park();
        assertEquals(0, car.getSpeed());
    }

    @Test
    void testMotorcycleParkSetsSpeedToZero() {
        Motorcycle motorcycle = new Motorcycle();
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(0, motorcycle.getSpeed());
    }
}
