package myProject.projectOne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Hello world!
 *
 */

@SpringBootApplication
public class App {
	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(App.class, args);
		System.out.println("Hello World!");
		// User user = context.getBean(User.class);

	}
}
