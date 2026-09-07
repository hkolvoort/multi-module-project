package nl.hkstwk.demo.a.echo;

import nl.hkstwk.demo.a.config.EchoConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {EchoConfig.class})
@TestPropertySource(properties = "selector.qualifiers=alphaEchoService")
class AlphaEchoServiceTest {

    @Autowired
    private Map<String, EchoService> echoServices;

    @Test
    void whenAlphaQualifier_thenAlphaBeanIsUsed() {
        EchoService alphaEchoService = echoServices.get("alphaEchoService");

        assertThat(echoServices).containsOnlyKeys("alphaEchoService");
        assertThat(alphaEchoService.echo()).isEqualTo("Hello alpha");
    }
}
