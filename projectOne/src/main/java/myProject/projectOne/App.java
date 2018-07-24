package myProject.projectOne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@ComponentScan
public class App {
	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(App.class, args);
		System.out.println("Hello World!");
		// User user = context.getBean(User.class);

	}
}
