package org.synyx.springboot.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

import org.springframework.stereotype.Component;


@Component
public class HealthToggle implements HealthIndicator {

    private boolean toggled = false;

    public void toggle() {

        if (!toggled) {
            toggled = true;
        } else {
            toggled = false;
        }
    }


    @Override
    public Health health() {

        if (toggled) {
            return Health.up().build();
        } else {
            return Health.down().build();
        }
    }
}
