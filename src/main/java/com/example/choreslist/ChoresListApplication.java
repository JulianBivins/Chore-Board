package com.example.choreslist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChoresListApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ChoresListApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println(chores);
	}
}
