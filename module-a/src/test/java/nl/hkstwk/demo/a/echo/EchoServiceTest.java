package nl.hkstwk.demo.a.echo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {EchoConfig.class})
@TestPropertySource(properties = "echo.qualifiers=")
class EchoServiceDefaultTest {

    @Autowired
    private EchoService echoService;

    @Test
    void whenNoQualifiers_thenDefaultBeanIsUsed() {
        assertThat(echoService.echo()).isEqualTo("Hello DefaultBean!");
    }
}

@SpringBootTest(classes = {EchoConfig.class})
@TestPropertySource(properties = "echo.qualifiers=alpha")
class EchoServiceAlphaTest {

    @Autowired
    private EchoService echoService;

    @Test
    void whenAlphaQualifier_thenAlphaBeanIsUsed() {
        assertThat(echoService.echo()).isEqualTo("Hello alpha");
    }
}

@SpringBootTest(classes = {EchoConfig.class})
@TestPropertySource(properties = "echo.qualifiers=beta")
class EchoServiceBetaTest {

    @Autowired
    private EchoService echoService;

    @Test
    void whenBetaQualifier_thenBetaBeanIsUsed() {
        assertThat(echoService.echo()).isEqualTo("Hello beta");
    }
}

@SpringBootTest(classes = {EchoConfig.class})
@TestPropertySource(properties = "echo.qualifiers=alpha,beta")
class EchoServiceMultipleQualifiersTest {

    @Autowired
    private EchoService echoService;

    @Test
    void whenMultipleQualifiers_thenFirstMatchingBeanIsUsed() {
        assertThat(echoService.echo()).isEqualTo("Hello alpha");
    }
}

@SpringBootTest(classes = {EchoConfig.class})
@TestPropertySource(properties = "echo.qualifiers=beta,alpha")
class EchoServiceMultipleQualifiersReversedTest {

    @Autowired
    private EchoService echoService;

    @Test
    void whenMultipleQualifiersReversed_thenFirstMatchingBeanIsUsed() {
        assertThat(echoService.echo()).isEqualTo("Hello beta");
    }
}
