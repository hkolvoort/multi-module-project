package nl.hkstwk.demo.a.echo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

@Configuration
public class EchoConfig {

    @Bean
    @Primary
    public EchoService echoService(
            @Value("${echo.qualifiers:}") String qualifiersProperty,
            Map<String, Supplier<EchoService>> echoServiceSuppliers
    ) {
        if (qualifiersProperty == null || qualifiersProperty.trim().isEmpty()) {
            return new DefaultEchoService();
        }

        List<String> qualifiers = Arrays.stream(qualifiersProperty.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();

        // Return the first matching qualifier from the list
        for (String qualifier : qualifiers) {
            Supplier<EchoService> supplier = echoServiceSuppliers.get(qualifier);
            if (supplier != null) {
                return supplier.get();
            }
        }

        return new DefaultEchoService();
    }

    @Bean
    public Supplier<EchoService> alpha() {
        return AlphaEchoService::new;
    }

    @Bean
    public Supplier<EchoService> beta() {
        return BetaEchoService::new;
    }
}
