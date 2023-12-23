package homework_2023_11_22.task_4;

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
