package nl.hkstwk.demo.a;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GreetingServiceATest {

    @Test
    @DisplayName("Zou begroetingsbericht moeten geven als naam is opgegeven")
    void should_returnGreetingMessage_when_nameProvided() {
        // given
        GreetingServiceA greetingServiceA = new GreetingServiceA();
        String expected = "Hello harm from module A!";

        // when
        String result = greetingServiceA.greeting("harm");

        // then
        assertThat(result).isEqualTo(expected);
    }
}