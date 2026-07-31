/*
Problem: Scheduled Tasks
Run a background job on a fixed schedule using @Scheduled,
after enabling scheduling with @EnableScheduling on a
configuration class.
*/

package com.example.demo.scheduling;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Configuration
@EnableScheduling
class SchedulingConfig {
}

@Component
public class ScheduledTasks {

    // Runs every 5 seconds
    @Scheduled(fixedRate = 5000)
    public void reportStatus() {
        System.out.println("Health check at " + LocalDateTime.now());
    }

    // Runs at 2:00 AM every day (cron expression)
    @Scheduled(cron = "0 0 2 * * *")
    public void nightlyCleanup() {
        System.out.println("Running nightly cleanup job");
    }
}
