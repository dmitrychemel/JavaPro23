package homework_22_11_2023.task_2_and_3;

public class Bus extends Vehicle{
    private boolean accessibility;
    private int busNumber;

    @Override
    public void ride(String route) {
        System.out.println("Маршрут построен");
    }

    @Override
    public void stop() {
        System.out.println(getClass().getName() + "маршрут прекрашен");
    }

    @Override
    public void newRoute(String route) {
        ride(route);
        System.out.println("Маршрут перестроен на" + route);
    }

    public void busStop(String nextBusStop) {
        stop();
        openDoors();
        closeDoors();
        rideToNextBusStop(nextBusStop);
    }

    private void openDoors() {
        accessibility = true;
    }

    private void closeDoors() {
        accessibility = false;
    }

    public void rideToNextBusStop(String route) {
        newRoute(route);
    }
}
