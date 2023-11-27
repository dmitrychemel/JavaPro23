package homework_20_11_2023.exp_4;

public class Car {
    private String brand;
    private String model;
    private int year;
    private int techInspection;

    private int currentYear = 2023;

    public Car(String brand, String model, int year, int techInspection, FleetManager fleetManager) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.techInspection = techInspection;
        fleetManager.addToFleet(this);
    }

    public String infoCar() {
        return "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", techInspection=" + techInspection +
                '}';
    }

    public void checkTechInspection() {
        if(currentYear - techInspection >= 0) {
            System.out.println("Техосмотр есть");
        } else {
            System.out.println("Texосмотр устарел");
        }
    }


}
