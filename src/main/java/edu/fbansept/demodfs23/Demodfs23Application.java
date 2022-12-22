package edu.fbansept.demodfs23;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Demodfs23Application {

	public static void main(String[] args) {
		SpringApplication.run(Demodfs23Application.class, args);
	}

}
