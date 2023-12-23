package homework_2023_11_20.exp_4;

public class Fleet {

    private String name;
    private String address;
    private FleetManager[] fleetManagers;

    public Fleet(String name, String address) {
        this.name = name;
        this.address = address;
        fleetManagers = new FleetManager[0];
    }

    public void addFleetManager(FleetManager fleetManager) {
        FleetManager[] newList = new FleetManager[fleetManagers.length + 1];
        System.arraycopy(fleetManagers, 0, newList, 0, fleetManagers.length);
        newList[fleetManagers.length] = fleetManager;
        fleetManagers = newList;
    }

    public FleetManager searchFleetManagerByName(String name) {
        for (int i = 0; i < fleetManagers.length; i++) {
            if(fleetManagers[i].getName().equals(name)) {
                return fleetManagers[i];
            }
        }
        return null;
    }
}
