package signal.emitter.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class EmitterServiceImplTest {

    @Spy
    private JsonMapperServiceImpl jsonMapperService;

    @InjectMocks
    private EmitterServiceImpl emitterService;

    @Test
    public void emitTest() {
        final String result = emitterService.emit();
        assertThat(result, is(notNullValue()));
    }

}