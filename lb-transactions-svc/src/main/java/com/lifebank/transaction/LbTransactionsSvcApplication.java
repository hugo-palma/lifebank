package com.lifebank.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class LbTransactionsSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(LbTransactionsSvcApplication.class, args);
	}

}
