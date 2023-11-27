package homework_22_11_2023.task_2_and_3;

public class Taxi extends Vehicle{
    private String licensePlate;
    private boolean available;

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

    public void pickUpPassenger(String routePoint) {
        ride(routePoint);
        available = false;
    }

    public void dropOffPassenger() {
        available = true;
    }
}
