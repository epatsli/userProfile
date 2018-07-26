package project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Hello world!
 *
 */

@Configuration
@EnableAspectJAutoProxy

@SpringBootApplication
@ComponentScan
public class App {
	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(App.class, args);
		System.out.println("Hello World!");
		// User user = context.getBean(User.class);

	}
}
