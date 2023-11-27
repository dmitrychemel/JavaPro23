package homework_22_11_2023.task_2_and_3;

public abstract class Vehicle {
    private String model;
    private int capacity;
    private double fare;
    private String route;


    public void ride(String route) {

    }

    public void stop() {

    }

    public void newRoute(String route) {

    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", capacity=" + capacity +
                ", fare=" + fare +
                ", route='" + route + '\'' +
                '}';
    }
}
