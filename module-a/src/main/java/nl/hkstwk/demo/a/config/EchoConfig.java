package nl.hkstwk.demo.a.config;

import nl.hkstwk.demo.a.echo.AlphaEchoService;
import nl.hkstwk.demo.a.echo.BetaEchoService;
import nl.hkstwk.demo.a.echo.DefaultEchoService;
import nl.hkstwk.demo.a.echo.EchoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EchoConfig {

    @Bean
    @Conditional(DefaultServiceCondition.class)
    public EchoService defaultEchoService() {
        return new DefaultEchoService();
    }

    @Bean
    @ConditionalOnSelector("alphaEchoService")
    public EchoService alphaEchoService() {
        return new AlphaEchoService();
    }

    @Bean
    @ConditionalOnSelector("betaEchoService")
    public EchoService betaEchoService() {
        return new BetaEchoService();
    }
}
