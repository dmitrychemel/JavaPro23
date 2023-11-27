package homework_22_11_2023.task_2_and_3;

public interface TransportControl {
    void newRoute(Vehicle vehicle);
    void newPassenger(Taxi taxi);
    void noPower(Tram tram);
}
