package myProject.projectOneRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import myProject.projectOneDomain.User;

@Repository
public class UserData {

	private List<User> userList = new ArrayList<>();

	public UserData() {
		User newUser = new User("Jan", "Nowak", "jan.nowak@gmail.com", "password", "Life is to short.");
		userList.add(newUser);
		newUser = new User("Olga", "Kowalska", "ola.kowalska@gmail.com", "admin", "I want to die.");
		userList.add(newUser);
		newUser = new User("Michal", "Tyka", "michal.tyka@gmail.com", "1234", "I don't belive.");
		userList.add(newUser);
	}

	public User getUserByName(String name) {
		return userList.stream().filter(u -> u.getFirstName().equals(name)).collect(Collectors.toList()).get(0);
	}

	public void setUserName(String name, String newName) {
		getUserByName(name).setFirstName(newName);
	}

	public void setUserLastName(String name, String newLastName) {
		getUserByName(name).setLastName(newLastName);
	}

	public void setUserMail(String name, String newMail) {
		getUserByName(name).setEmail(newMail);
	}

	public void setPassword(String name, String newPassword) {
		getUserByName(name).setPassword(newPassword);
	}

	public void setLifeMotto(String name, String newLifeMotto) {
		getUserByName(name).setLifeMotto(newLifeMotto);
	}
}
