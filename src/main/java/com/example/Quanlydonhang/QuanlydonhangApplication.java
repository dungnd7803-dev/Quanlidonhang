package com.example.Quanlydonhang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.sql.DataSource;

@SpringBootApplication
@EnableJpaAuditing
public class QuanlydonhangApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuanlydonhangApplication.class, args);
	}
}
