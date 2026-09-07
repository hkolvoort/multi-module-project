package nl.hkstwk.demo.a.config;

import org.jspecify.annotations.NonNull;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OnSelectorCondition implements Condition {

    @Override
    public boolean matches(@NonNull ConditionContext context, @NonNull AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionalOnSelector.class.getName());

        if (attributes == null) {
            return false;
        }

        String selector = (String) attributes.get("value");

        Environment environment = context.getEnvironment();
        String[] servicesArray = environment.getProperty("selector.qualifiers", String[].class);
        List<String> selectors = servicesArray != null ? Arrays.asList(servicesArray) : Collections.emptyList();

        return selectors.contains(selector);
    }
}