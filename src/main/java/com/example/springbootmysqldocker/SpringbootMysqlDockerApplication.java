package com.example.springbootmysqldocker;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootMysqlDockerApplication {

	private static  ConfigurableApplicationContext context;
	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(SpringbootMysqlDockerApplication.class, args);

		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			System.out.println("Shutting Down");


			context.close();
		}));



	}

}
