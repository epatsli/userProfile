package myProject.projectOneRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import myProject.projectOne.Entity.UserEntity;

@Repository
public class UserDAO {

	private List<UserEntity> userList = new ArrayList<>();

	public UserDAO() {
		userList.add(new UserEntity(1, "Jan", "Nowak", "jan.nowak@gmail.com", "password", "Life is to short."));
		userList.add(new UserEntity(2, "Olga", "Kowalska", "ola.kowalska@gmail.com", "admin", "I want to die."));
		userList.add(new UserEntity(3, "Michal", "Tyka", "michal.tyka@gmail.com", "1234", "I don't belive."));
	}

	public UserEntity getUserById(int i) {
		return userList.stream().filter(u -> u.getId() == i).collect(Collectors.toList()).get(0);
	}

	public void getUserProfile(int i) {
		UserEntity user = userList.stream().filter(u -> u.getId() == i).collect(Collectors.toList()).get(0);
		user.toString();
	}

	public void setUserProfile(int i, String newName, String newLastName, String newMail, String newPassword,
			String newLifeMotto) {
		UserEntity user = getUserById(i);
		user.setFirstName(newName);
		user.setLastName(newLastName);
		user.setEmail(newMail);
		user.setPassword(newPassword);
		user.setLifeMotto(newLifeMotto);
	}
	/*
	 * // dfdfsdf public void setUserLastName(String name, String newLastName) {
	 * getUserByName(name).setLastName(newLastName); }
	 * 
	 * public void setUserMail(String name, String newMail) {
	 * getUserByName(name).setEmail(newMail); }
	 * 
	 * public void setPassword(String name, String newPassword) {
	 * getUserByName(name).setPassword(newPassword); }
	 * 
	 * public void setLifeMotto(String name, String newLifeMotto) {
	 * getUserByName(name).setLifeMotto(newLifeMotto); }
	 */

	public List<UserEntity> getAllUsers() {
		// TODO Auto-generated method stub
		return userList;
	}
}
