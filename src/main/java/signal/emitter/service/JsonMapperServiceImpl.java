package signal.emitter.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import signal.emitter.record.Record;

@Service
public class JsonMapperServiceImpl implements JsonMapperService {

    private final ObjectMapper objectMapper;

    public JsonMapperServiceImpl() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public String map(final Record record) {

        try {
            return objectMapper.writeValueAsString(record);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
