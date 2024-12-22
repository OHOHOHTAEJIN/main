package com.infor.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan(basePackages = "com.infor.main")
@EnableAutoConfiguration
public class MainApplication {

	private static Environment environment;

	@Autowired
	public MainApplication(Environment environment) {
		MainApplication.environment = environment;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MainApplication.class, args);
		System.out.println("Main Start");
		MainApplication da = new MainApplication(environment);
		da.contextLoads();
	}

	public void contextLoads() throws Exception {
		System.out.println("DemoApplication 실행");
		System.out.println("profile 값 :: " + environment.getProperty("spring.profiles.active"));

		String username = environment.getProperty("spring.test.username");
		System.out.println("USERNAME :: " + username);
	}

}
