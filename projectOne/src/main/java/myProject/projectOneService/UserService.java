package myProject.projectOneService;

import java.util.List;

import org.springframework.stereotype.Service;

import myProject.projectOne.Entity.UserEntity;
import myProject.projectOne.To.UserDTO;
import myProject.projectOne.mapper.UserMapper;
import myProject.projectOneRepository.UserDAO;

@Service
public class UserService {

	private UserDAO userData;

	public UserService() {

		this.userData = new UserDAO();
	}

	public UserEntity getUserById(int i) {
		return userData.getUserById(i);
	}

	public void getUserProfile(int i) {
		userData.getUserProfile(i);
	}

	public void setUserProfile(int i, String newName, String newLastName, String newMail, String newPassword,
			String newLifeMotto) {
		setUserProfile(i, newName, newLastName, newMail, newPassword, newLifeMotto);
	}

	public List<UserDTO> getAllUsers() {
		return UserMapper.mapUser(userData.getAllUsers());
	}
	/*
	 * /// sscsdcsdcdcsdcd public void setUserLastNameByFirstName(String name,
	 * String newLastName) { getUserByFirstName(name).setLastName(newLastName);
	 * }
	 * 
	 * public void setUserMailByFirstName(String name, String newMail) {
	 * getUserByFirstName(name).setEmail(newMail); }
	 * 
	 * public void setUserPasswordByFirstName(String name, String newPassword) {
	 * getUserByFirstName(name).setPassword(newPassword); }
	 * 
	 * public void setUserLifeMottoByFirstName(String name, String newLifeMotto)
	 * { getUserByFirstName(name).setLifeMotto(newLifeMotto); }
	 */
	/*
	 * public void addAvailabilityHours(String name, Playability playability) {
	 * userData.addAvailabilityHours(name, playability); }
	 */
}
