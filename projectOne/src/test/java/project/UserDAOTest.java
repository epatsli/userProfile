package project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import project.entity.UserEntity;
import project.repository.UserDAO;

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
	/*
	 * @Test public void shouldAddPlayability() { UserEntity user =
	 * userDAO.getAllUsers().get(2); assertEquals(null, user.getPlayability());
	 * PlayabilityEntity newPlay=new PlayabilityEntity(2017-02-03, 2017-02-03,
	 * ""); assertEquals(null, ); }
	 */
}
