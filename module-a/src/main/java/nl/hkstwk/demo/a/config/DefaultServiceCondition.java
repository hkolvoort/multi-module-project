package nl.hkstwk.demo.a.config;

import org.jspecify.annotations.NonNull;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DefaultServiceCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, @NonNull AnnotatedTypeMetadata metadata) {
        // Lees de lijst uit de application.properties
        Environment environment = context.getEnvironment();
        String[] servicesArray = environment.getProperty("selector.qualifiers", String[].class);
        List<String> selectors = servicesArray != null ? Arrays.asList(servicesArray) : Collections.emptyList();

        // De default bean mag ALLEEN laden als de lijst leeg is of niet bestaat
        return selectors.isEmpty();
    }
}
