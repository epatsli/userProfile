package project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import project.entity.UserEntity;
import project.mapper.PlayabilitityMapper;
import project.mapper.UserMapper;
import project.repository.UserDAO;
import project.to.PlayabilityTO;
import project.to.UserTO;

@Service
public class UserService {

	private UserDAO userDAO;

	public UserService() {

		this.userDAO = new UserDAO();
	}

	public UserTO updateDateUser(UserTO user) {

		UserEntity updatedUser = userDAO.updateUserProfile(UserMapper.mapToEntity(user));
		return UserMapper.mapToTO(updatedUser);
	}

	public UserTO showProfilUser(UserTO user) {

		UserEntity userProfileInformacion = userDAO.showUserProfile(UserMapper.mapToEntity(user));
		return UserMapper.mapToTO(userProfileInformacion);
	}

	public UserTO addAvailabilityHour(UserTO user, List<PlayabilityTO> availability) {
		UserEntity userEntityPlay = userDAO.addAvailabilityHours(UserMapper.mapToEntity(user),
				PlayabilitityMapper.mapPlayabilityToEntity(availability));
		return UserMapper.mapToTO(userEntityPlay);
	}

	/*
	 * public UserEntity getUserById(int i) { return userDAO.getUserById(i); }
	 * 
	 * public UserEntity getUserProfile(int i) { return
	 * userDAO.getUserProfile(i); }
	 * 
	 * public void setUserProfile(int i, String newName, String newLastName,
	 * String newMail, String newPassword, String newLifeMotto) {
	 * userDAO.setUserProfile(i, newName, newLastName, newMail, newPassword,
	 * newLifeMotto); }
	 * 
	 * public List<UserDTO> getAllUsers() { return
	 * UserMapper.mapUser(userDAO.getAllUsers()); }
	 * 
	 * public UserTO findUserByEmail(String email) { return
	 * UserMapper.mapToTO(userDAO.getUserByEmail(email)); }
	 */
	// current profile information,

}
