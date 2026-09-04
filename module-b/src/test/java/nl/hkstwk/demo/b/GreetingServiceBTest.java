package nl.hkstwk.demo.b;

import nl.hkstwk.demo.a.GreetingServiceA;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@DisplayName("GreetingServiceB tests")
class GreetingServiceBTest {

    @Mock
    private GreetingServiceA greetingServiceA;

    @InjectMocks
    private GreetingServiceB greetingServiceB;

    @Test
    @DisplayName("Zou groet met [B] prefix moeten geven als naam gegeven is")
    void should_returnGreetingWithBPrefix_when_nameProvided() {
        // given
        String name = "harm";

        // when
        String result = greetingServiceB.greeting(name);

        // then
        assertThat(result).isEqualTo("[B] Hello harm from module A!");
    }
}