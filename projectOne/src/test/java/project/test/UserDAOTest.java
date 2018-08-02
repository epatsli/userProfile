package project.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import project.repository.PlayabilityEntity;
import project.repository.UserDAO;
import project.repository.UserEntity;
import project.utils.DateUtils;

@RunWith(MockitoJUnitRunner.class)
public class UserDAOTest {

	@InjectMocks
	private UserDAO userDAO;

	@Test
	public void shouldReturnSizeDAO() {
		assertEquals(3, userDAO.getAllUsers().size());
	}

	@Test
	public void shouldReturnProfil() {
		UserEntity user = userDAO.getAllUsers().get(1);
		assertEquals("Olga", userDAO.showUserProfile(user).getFirstName());
		assertEquals("ola.kowalska@gmail.com", userDAO.showUserProfile(user).getEmail());
		assertEquals("admin", userDAO.showUserProfile(user).getPassword());
		assertEquals("Jan", userDAO.getAllUsers().get(0).getFirstName());
	}

	@Test
	public void shouldUpdateUserDate() {
		assertEquals("Jan", userDAO.getAllUsers().get(0).getFirstName());
		UserEntity user = new UserEntity(1, "Adam", "Nowak", "jan.nowak@gmail.com", "password", "Life is to short.",
				null);
		assertEquals("Adam", userDAO.updateUserProfile(user).getFirstName());
		assertEquals("jan.nowak@gmail.com", userDAO.updateUserProfile(user).getEmail());
	}

	@Test
	public void shouldAddPlayability() {
		PlayabilityEntity pe = new PlayabilityEntity(DateUtils.getDateFromText("25-07-18:12:39:00"),
				DateUtils.getDateFromText("25-07-18:18:39:00"));
		List<PlayabilityEntity> list = new ArrayList<PlayabilityEntity>();
		list.add(pe);
		UserEntity user = userDAO.getAllUsers().get(2);
		userDAO.addAvailabilityHours(user, Collections.singletonList(pe));
		assertEquals(list, user.getPlayability());
	}

}
