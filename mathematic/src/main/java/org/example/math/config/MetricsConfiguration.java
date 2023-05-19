package org.example.math.config;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.example.math.service.MathematicsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfiguration {

    @Bean
    public MeterBinder availableExercisesMetric(MathematicsService mathService) {
        return registry ->
              Gauge.builder("exercise.max.available", mathService::getMaxAvailableNumber)
                    .baseUnit("NUMBER")
                    .description("Maximal value available in the exercise")
                    .register(registry);
    }

}
