package nl.hkstwk.demo.a.echo;

import nl.hkstwk.demo.a.config.EchoConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {EchoConfig.class})
@TestPropertySource(properties = "selector.qualifiers=alphaEchoService,betaEchoService")
class MultipleEchoServicesTest {
    @Autowired
    private Map<String, EchoService> echoServices;

    @Test
    @DisplayName("Zou alpha en beta services moeten geven als meerdere selectors zijn ingesteld")
    void should_returnAlphaAndBetaServices_when_multipleQualifiersAreConfigured() {
        // given
        EchoService alphaEchoService = echoServices.get("alphaEchoService");
        EchoService betaEchoService = echoServices.get("betaEchoService");

        // when

        // then
        assertThat(echoServices)
                .containsOnlyKeys("alphaEchoService", "betaEchoService");

        assertThat(echoServices).containsOnlyKeys("alphaEchoService", "betaEchoService");
        assertThat(alphaEchoService.echo()).isEqualTo("Hello alpha");
        assertThat(betaEchoService.echo()).isEqualTo("Hello beta");
    }
}
