package signal.emitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import signal.emitter.emitter.Emitter;
import signal.emitter.record.Record;

@Service
public class EmitterServiceImpl implements EmitterService {

    private final Emitter emitter;
    private final JsonMapperService jsonMapperService;

    @Autowired
    public EmitterServiceImpl(final JsonMapperService jsonMapperService) {
        this.jsonMapperService = jsonMapperService;
        this.emitter = new Emitter();
    }

    @Override
    public String emit() {
        final Record record = emitter.emit();
        return jsonMapperService.map(record);
    }
}
