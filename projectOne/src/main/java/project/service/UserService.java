package project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import project.entity.UserEntity;
import project.mapper.UserMapper;
import project.repository.UserDAO;
import project.to.UserDTO;

@Service
public class UserService {

	private UserDAO userData;

	public UserService() {

		this.userData = new UserDAO();
	}

	public UserEntity getUserById(int i) {
		return userData.getUserById(i);
	}

	public UserEntity getUserProfile(int i) {
		return userData.getUserProfile(i);
	}

	public void setUserProfile(int i, String newName, String newLastName, String newMail, String newPassword,
			String newLifeMotto) {
		userData.setUserProfile(i, newName, newLastName, newMail, newPassword, newLifeMotto);
	}

	public List<UserDTO> getAllUsers() {
		return UserMapper.mapUser(userData.getAllUsers());
	}
}
