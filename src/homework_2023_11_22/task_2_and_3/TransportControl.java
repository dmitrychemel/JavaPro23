package homework_2023_11_22.task_2_and_3;

public interface TransportControl {
    void newRoute(Vehicle vehicle);
    void newPassenger(Taxi taxi);
    void noPower(Tram tram);
}
