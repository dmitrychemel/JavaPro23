package homework_2023_11_20.exp_4;

import java.util.Arrays;

public class FleetManager {
    private String name;
    private Car[] listCars;
    private Driver[] listDrivers;

    public FleetManager(String name) {
        this.name = name;
        listCars = new Car[0];
        listDrivers = new Driver[0];
    }

    public String getName() {
        return name;
    }

    public void addToFleet(Car car) {
        Car[] newList = new Car[listCars.length + 1];
        System.arraycopy(listCars, 0, newList, 0, listCars.length);
        newList[listCars.length] = car;
        listCars = newList;
    }

    public void assignCarToDriver(Car car, Driver driver) {
        if(checkFreeCars(car)) {
            deleteCar(car);
            driver.setCurrentCar(car);
            deleteFreeDriver(driver);
        }
    }

    private boolean checkFreeCars(Car car) {
        for (int i = 0; i < listCars.length; i++) {
            if(listCars[i].equals(car)) {
                return true;
            }
        }
        return false;
    }

    private void deleteCar(Car car) {
        for (int i = 0; i < listCars.length ; i++) {
            if(listCars[i].equals(car)){
                Car[] newList = new Car[listCars.length - 1];
                System.arraycopy(listCars, 0, newList, 0, i);
                System.arraycopy(listCars, i + 1, newList, 0, listCars.length - i - 1);
                listCars = newList;
            }
        }
    }

    private void deleteFreeDriver(Driver driver) {
        for (int i = 0; i < listDrivers.length ; i++) {
            if(listDrivers[i].equals(driver)){
                Driver[] newList = new Driver[listDrivers.length - 1];
                System.arraycopy(listDrivers, 0, newList, 0, i);
                System.arraycopy(listDrivers, i + 1, newList, 0, listDrivers.length - i - 1);
                listDrivers = newList;
            }
        }
    }

    public void addFreeDriver(Driver driver) {
        Driver[] newList = new Driver[listDrivers.length + 1];
        System.arraycopy(listDrivers, 0, newList, 0, listDrivers.length);
        newList[listDrivers.length] = driver;
        listDrivers = newList;
    }

    @Override
    public String toString() {
        return "FleetManager{" +
                "name='" + name + '\'' +
                ", listCars=" + Arrays.toString(listCars) +
                ", listDrivers=" + Arrays.toString(listDrivers) +
                '}';
    }
}
