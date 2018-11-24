package signal.emitter.record;

import java.io.Serializable;

public final class Record implements Serializable {

    private final Data data;

    public Record(final Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }
}
