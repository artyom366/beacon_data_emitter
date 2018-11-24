package signal.emitter.record;

import java.io.Serializable;

public final class Data implements Serializable {

    private final String deviceId;

    private final Float temperature;

    private final Location location;

    private final String time;

    public Data(final String deviceId, final Float temperature, final Location location, final String time) {
        this.deviceId = deviceId;
        this.temperature = temperature;
        this.location = location;
        this.time = time;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public Float getTemperature() {
        return temperature;
    }

    public Location getLocation() {
        return location;
    }

    public String getTime() {
        return time;
    }
}
