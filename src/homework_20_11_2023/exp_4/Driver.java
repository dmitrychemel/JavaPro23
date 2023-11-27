package homework_20_11_2023.exp_4;

public class Driver {
    private String name;
    private int driveExperience;
    private Car currentCar;

    public Driver(String name, int driveExperience, FleetManager fleetManager) {
        this.name = name;
        this.driveExperience = driveExperience;
        fleetManager.addFreeDriver(this);
    }

    public Car getCurrentCar() {
        return currentCar;
    }

    public void setCurrentCar(Car currentCar) {
        this.currentCar = currentCar;
    }

    public void assignCar(Car car, FleetManager fleetManager) {
        fleetManager.assignCarToDriver(car, this);
    }

    public void freeCar(FleetManager fleetManager) {
        fleetManager.addFreeDriver(this);
        fleetManager.addToFleet(currentCar);
    }


}
