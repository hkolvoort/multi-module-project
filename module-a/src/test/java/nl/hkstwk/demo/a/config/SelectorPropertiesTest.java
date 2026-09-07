package nl.hkstwk.demo.a.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {SelectorProperties.class})
@TestPropertySource(properties = "selector.qualifiers=alphaEchoService,betaEchoService")
@EnableConfigurationProperties(SelectorProperties.class)
class SelectorPropertiesTest {

    @Autowired
    private SelectorProperties selectorProperties;

    @Test
    @DisplayName("Zou qualifiers lijst met betaEchoService, betaEchoService moeten geven als properties zijn ingesteld")
    void should_returnQualifiersList_when_propertiesAreConfigured() {
        // given
        List<String> expectedQualifiers = List.of("alphaEchoService", "betaEchoService");

        // when
        List<String> actualQualifiers = selectorProperties.getQualifiers();

        // then
        assertThat(actualQualifiers).isEqualTo(expectedQualifiers);
    }

    @Test
    @DisplayName("Zou qualifiers lijst met juiste grootte moeten geven als properties zijn ingesteld")
    void should_returnQualifiersWithCorrectSize_when_propertiesAreConfigured() {
        // given
        int expectedSize = 2;

        // when
        List<String> actualQualifiers = selectorProperties.getQualifiers();

        // then
        assertThat(actualQualifiers).hasSize(expectedSize);
    }

    @Test
    @DisplayName("Zou qualifiers lijst met juiste waarden moeten bevatten als properties zijn ingesteld")
    void should_containCorrectValues_when_propertiesAreConfigured() {
        // given
        String[] expectedValue = {"betaEchoService","alphaEchoService"};

        // when
        List<String> actualQualifiers = selectorProperties.getQualifiers();

        // then
        assertThat(actualQualifiers).containsExactlyInAnyOrder(expectedValue);
    }
}
