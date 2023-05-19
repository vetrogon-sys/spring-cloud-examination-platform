package com.example.examinator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Custom health indicator which checks phase of the Moon before allowing
 * users accessing the application.
 *
 * @author Aleksandr Barmin
 */
@Component
public class PhaseOfTheMoonHealthIndicator implements HealthIndicator {
  private Random random;

  @PostConstruct
  public void init() {
    random = ThreadLocalRandom.current();
  }

  @Override
  public Health health() {
    if (random.nextInt(2) == 0) {
      return Health.down()
          .status("Invalid phase of the Moon")
          .build();
    }
    return Health.up().build();
  }
}
