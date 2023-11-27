package homework_22_11_2023.task_4;

import java.time.LocalDateTime;

public abstract class Device implements ControlInterface {
    private String deviceId;
    private String location;
    private boolean isOn;
    private LocalDateTime lastChecked;


    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }

    @Override
    public void getStatus() {

    }
}
