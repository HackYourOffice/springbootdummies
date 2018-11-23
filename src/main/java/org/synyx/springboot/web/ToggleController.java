package org.synyx.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.synyx.springboot.health.HealthToggle;


@RestController
public class ToggleController {

    private final HealthToggle healthToggle;

    public ToggleController(HealthToggle healthToggle) {

        this.healthToggle = healthToggle;
    }

    @GetMapping("/toggle")
    public void toggle() {

        healthToggle.toggle();
    }
}
