package project;

import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import project.service.UserService;
import project.to.UserTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContextTest {

	@Autowired
	private UserService service;

	@Test
	public void someTest() throws Exception {
		service.addAvailabilityHour(new UserTO(2, "Olga", "Ziemowit", "ola.kowalska@gmail.com", "admin",
				"I want to die", Collections.EMPTY_LIST), Collections.EMPTY_LIST);
	}
}
