package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.entity.UserEntity;
import project.mapper.UserMapper;
import project.repository.UserDAO;
import project.to.UserDTO;
import project.to.UserTO;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public UserService() {

		this.userDAO = new UserDAO();
	}

	public UserEntity getUserById(int i) {
		return userDAO.getUserById(i);
	}

	public UserEntity getUserProfile(int i) {
		return userDAO.getUserProfile(i);
	}

	public void setUserProfile(int i, String newName, String newLastName, String newMail, String newPassword,
			String newLifeMotto) {
		userDAO.setUserProfile(i, newName, newLastName, newMail, newPassword, newLifeMotto);
	}

	public List<UserDTO> getAllUsers() {
		return UserMapper.mapUser(userDAO.getAllUsers());
	}

	//// my
	public UserTO findUserByEmail(String email) {
		return UserMapper.mapToTO(userDAO.getUserByEmail(email));
	}

	public UserTO findUserById(int i) {
		return UserMapper.mapToTO(userDAO.getUserById(i));
	}
}
