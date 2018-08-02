package project.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import project.repository.UserDAO;
import project.repository.UserEntity;
import project.service.PlayabilityTO;
import project.service.UserService;
import project.service.UserTO;
import project.utils.DateUtils;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@Mock
	private UserDAO userDAOMock;

	@InjectMocks
	private UserService userService;

	@Test
	public void shouldUpdateProfile() {
		UserEntity user = new UserEntity(1, "Jan", "Nowak", "jan.nowak@gmail.com", "password", "Life is to short.",
				null);
		UserTO use = new UserTO(1, "Jan", "Nowak", "jan.nowak@gmail.com", "password", "Life is to short.", null);

		Mockito.when(userDAOMock.updateUserProfile(any())).thenReturn(user);
		userService.updateDateUser(use);

		Mockito.verify(userDAOMock, times(1)).updateUserProfile(any(UserEntity.class));
	}

	@Test
	public void shouldShowUserProfile() {
		UserEntity user = new UserEntity(1, "Jan", "Nowak", "jan.nowak@gmail.com", "password", "Life is to short.",
				null);
		Mockito.when(userDAOMock.showUserProfile(any())).thenReturn(user);
		userService.showProfilUser(
				new UserTO(1, "Jan", "Nowak", "jan.nowak@gmail.com", "password", "Life is to short.", null));

		Mockito.verify(userDAOMock, times(1)).showUserProfile(any(UserEntity.class));
	}

	@Test
	public void shouldAddAvailabilityHour() {

		PlayabilityTO pe = new PlayabilityTO(DateUtils.getDateFromText("26-07-18:18:39:00"),
				DateUtils.getDateFromText("26-07-18:18:39:00"));

		UserTO user = new UserTO(1, "Jan", "Nowak", "jan.nowak@gmail.com", "password", "Life is to short.", null);
		Mockito.when(userDAOMock.addAvailabilityHours(any(UserEntity.class), any())).thenReturn(
				new UserEntity(1, "Jan", "Nowak", "jan.nowak@gmail.com", "password", "Life is to short.", null));

		userService.addAvailabilityHour(user, Collections.singletonList(pe));

		Mockito.verify(userDAOMock, times(1)).addAvailabilityHours(any(UserEntity.class), any());

	}

	@Test
	public void shoulEditAvailabilityHour() {
		PlayabilityTO pe = new PlayabilityTO(DateUtils.getDateFromText("26-07-18:18:39:00"),
				DateUtils.getDateFromText("26-07-18:18:39:00"));
		UserTO user = new UserTO(1, "Jan", "Nowak", "jan.nowak@gmail.com", "password", "Life is to short.", null);
		Mockito.when(userDAOMock.editAvailabilityHours(any(UserEntity.class), any())).thenReturn(
				new UserEntity(1, "Jan", "Nowak", "jan.nowak@gmail.com", "password", "Life is to short.", null));

		userService.editAvailabilityHour(user, Collections.singletonList(pe));

		Mockito.verify(userDAOMock, times(1)).editAvailabilityHours(any(UserEntity.class), any());

	}

	@Test
	public void shoulRemoveAvailabilityHour() {
		PlayabilityTO pe = new PlayabilityTO(DateUtils.getDateFromText("26-07-18:18:39:00"),
				DateUtils.getDateFromText("26-07-18:18:39:00"));
		UserTO user = new UserTO(1, "Jan", "Nowak", "jan.nowak@gmail.com", "password", "Life is to short.", null);
		Mockito.when(userDAOMock.deleteAvailabilityHours(any(UserEntity.class), any())).thenReturn(
				new UserEntity(1, "Jan", "Nowak", "jan.nowak@gmail.com", "password", "Life is to short.", null));

		userService.removeAvailabilityHour(user, Collections.singletonList(pe));

		Mockito.verify(userDAOMock, times(1)).deleteAvailabilityHours(any(UserEntity.class), any());

	}

}
