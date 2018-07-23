package myProject.projectOneService;

import org.springframework.stereotype.Service;

import myProject.projectOneDomain.User;
import myProject.projectOneRepository.UserData;

@Service
public class UserService {

	private UserData userData;

	public UserService() {

		this.userData = new UserData();
	}

	public User getUserByFirstName(String name) {
		return userData.getUserByName(name);
	}

	public void setUserNameByFirstName(String name, String newName) {
		getUserByFirstName(name).setFirstName(newName);
	}

	public void setUserLastNameByFirstName(String name, String newLastName) {
		getUserByFirstName(name).setLastName(newLastName);
	}

	public void setUserMailByFirstName(String name, String newMail) {
		getUserByFirstName(name).setEmail(newMail);
	}

	public void setUserPasswordByFirstName(String name, String newPassword) {
		getUserByFirstName(name).setPassword(newPassword);
	}

	public void setUserLifeMottoByFirstName(String name, String newLifeMotto) {
		getUserByFirstName(name).setLifeMotto(newLifeMotto);
	}
}
