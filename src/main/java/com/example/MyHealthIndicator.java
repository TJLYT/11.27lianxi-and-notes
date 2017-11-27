package com.example;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
@Component
	public class MyHealthIndicator implements HealthIndicator {

@Override
@Bean
	public Health health() {
		int errorCode = check(); // 
			if (errorCode != 0) {
				return Health.down().withDetail("Error Code", errorCode).build();
}
			return Health.up().build();
}

private int check() {
	int a=12;
	return a;
}
}
