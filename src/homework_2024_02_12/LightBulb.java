package homework_2024_02_12;//package org.example.dryKissYagni;


public class LightBulb {
    private boolean isLight;

    public boolean isLight() {
        return isLight;
    }

    public void turnOn() {
        isLight = true;
    }

    public void turnOff() {
        isLight = false;
    }
}

class SwitchQ {
    private LightBulb bulb;


    public SwitchQ(LightBulb bulb) {
        this.bulb = bulb;
    }

    public void press() {
        if(bulb.isLight()) {
            bulb.turnOff();
        } else {
            bulb.turnOn();
        }
    }
}
