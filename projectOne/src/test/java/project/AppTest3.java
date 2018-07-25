package project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import project.entity.UserEntity;
import project.service.GameService;
import project.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest3 {

	@Autowired
	private UserService service;

	@Autowired
	private GameService gameService;

	@Test
	public void shouldReturnEmail() {
		assertEquals("jan.nowak@gmail.com", service.findUserById(1).getEmail());
		assertEquals("Jan", service.findUserById(1).getFirstName());
		assertEquals("Kowalska", service.findUserById(2).getLastName());
		assertEquals(2, service.findUserById(2).getId());
	}

	@Test
	public void shouldReturnSizeUserDAO() {
		assertTrue(service.getAllUsers().size() > 0);
		assertEquals(3, service.getAllUsers().size());
	}

	@Test
	public void shouldReturnSizeGameDAO() {
		assertTrue(gameService.getListAllGame().size() > 0);
		assertEquals(4, gameService.getListAllGame().size());
		// assertEquals("Chess", gameService.getAllGame().get(1).getName());
	}

	@Test
	public void shouldReturnNameUserProfile() {
		assertEquals("Olga", service.getUserById(2).getFirstName());
	}

	@Test
	public void shouldReturnPasswordUserProfile() {

		assertEquals("password", service.getUserById(1).getPassword());
	}

	@Test
	public void shouldChangeUserProfile() {
		assertEquals("Kowalska", service.getUserById(2).getLastName());
		service.setUserProfile(2, "Olga", "Ziemowit", "ola.kowalska@gmail.com", "admin", "I want to die");
		assertEquals("Ziemowit", service.getUserById(2).getLastName());
	}

	@Test
	public void shouldGetUserProfile() {
		UserEntity user = new UserEntity(3, "Michal", "Tyka", "michal.tyka@gmail.com", "1234", "I don't belive.");
		assertEquals(user, service.getUserProfile(3));
	}

}
