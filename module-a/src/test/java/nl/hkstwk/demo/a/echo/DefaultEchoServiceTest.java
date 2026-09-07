package nl.hkstwk.demo.a.echo;

import nl.hkstwk.demo.a.config.EchoConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {EchoConfig.class})
@TestPropertySource(properties = "selector.qualifiers=")
class DefaultEchoServiceTest {

    @Autowired
    private Map<String, EchoService> echoServices;

    @Test
    void whenNoQualifiers_thenDefaultBeanIsUsed() {
        EchoService echoService = echoServices.get("defaultEchoService");

        assertThat(echoServices).containsOnlyKeys("defaultEchoService");
        assertThat(echoService.echo()).isEqualTo("Hello DefaultBean!");
    }
}
