package project;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import project.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest3 {

	@Autowired
	private UserService service;

	@Test
	public void someTest() {
		Assert.assertTrue(service.getAllUsers().size() > 0);
		Assert.assertEquals(3, service.getAllUsers().size());
	}
}
