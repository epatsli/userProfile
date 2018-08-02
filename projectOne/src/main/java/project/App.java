package project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy

@SpringBootApplication

@ComponentScan(basePackages = { "project.controller", "project.service", "project.repository", "project.mapper" })
public class App {
	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(App.class, args);
		System.out.println("Hello World!");

	}
}