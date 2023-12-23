package homework_2023_11_22.task_2_and_3;

public class Tram extends Vehicle {
    private int trackWidth;
    private boolean electric;
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

    public void tramStop(String nextBusStop) {
        stop();
        openDoors();
        closeDoors();
        rideToNextTramStop(nextBusStop);
    }

    private void openDoors() {
    }

    private void closeDoors() {
    }

    public void rideToNextTramStop(String route) {
        newRoute(route);
    }
}
