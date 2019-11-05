package com.firstinfo.dart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DartMigApplication {

	public static void main(String[] args) {
		SpringApplication.run(DartMigApplication.class, args);
	}

}
