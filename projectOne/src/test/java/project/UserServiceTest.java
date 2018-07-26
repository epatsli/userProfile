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

	@SuppressWarnings("deprecation")
	@Test
	public void shouldUpdateProfile() {
		UserEntity user = new UserEntity(1, "Jan", "Nowak", "jan.nowak@gmail.com", "password", "Life is to short.",
				null);
		UserTO use = new UserTO(1, "Jan", "Nowak", "jan.nowak@gmail.com", "password", "Life is to short.", null);

		Mockito.when(userDAOMock.updateUserProfile(Mockito.anyObject())).thenReturn(user);
		userService.updateDateUser(use);
	}

}
