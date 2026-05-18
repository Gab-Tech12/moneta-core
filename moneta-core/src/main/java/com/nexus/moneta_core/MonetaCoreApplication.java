package com.nexus.moneta_core;

import com.nexus.moneta_core.domain.Account;
import com.nexus.moneta_core.domain.User;
import com.nexus.moneta_core.repositories.AccountRepository;
import com.nexus.moneta_core.repositories.UserRepository;
import com.nexus.moneta_core.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class MonetaCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonetaCoreApplication.class, args);
	}




}