package signal.emitter.record;

import java.io.Serializable;

public final class Location implements Serializable {

    private final String latitude;

    private final String longitude;

    public Location(final String latitude, final String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
