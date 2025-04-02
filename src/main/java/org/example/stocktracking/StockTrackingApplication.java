package org.example.stocktracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class StockTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockTrackingApplication.class, args);
	}

}
