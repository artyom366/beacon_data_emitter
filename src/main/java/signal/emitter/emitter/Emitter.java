package signal.emitter.emitter;

import signal.emitter.record.Data;
import signal.emitter.record.Location;
import signal.emitter.record.Record;

import java.util.Random;
import java.util.UUID;

public final class Emitter {

    private final Random random;

    public Emitter() {
        this.random = new Random();
    }

    public Record emit() {
        final Location location = new Location(String.valueOf(random.nextDouble()), String.valueOf(random.nextDouble()));
        final Data data = new Data(UUID.randomUUID().toString(), (float) random.nextInt(51) - 20, location, String.valueOf(System.currentTimeMillis()));
        return new Record(data);
    }

}
