package project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import project.entity.UserEntity;
import project.repository.UserDAO;
import project.service.UserService;
import project.to.UserTO;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@Mock
	private UserDAO userDAOMock;

	@InjectMocks
	private UserService userService;
	UserEntity user = new UserEntity(1, "Jan", "Nowak", "jan.nowak@gmail.com", "password", "Life is to short.");

	@Test
	public void size() {
		Mockito.when(userDAOMock.updateUserProfile(user)).thenReturn(user);
		UserTO use = new UserTO(1, "Jan", "Nowak", "jan.nowak@gmail.com", "password", "Life is to short.");
		userService.updateDateUser(use);
	}
}
