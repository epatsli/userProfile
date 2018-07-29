package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aspect.Aspect.LogExecutionTime;
import project.entity.UserEntity;
import project.mapper.PlayabilitityMapper;
import project.mapper.UserMapper;
import project.repository.UserDAO;
import project.to.PlayabilityTO;
import project.to.UserTO;

@Service
public class UserService {

	private final UserDAO userDAO;

	@Autowired
	public UserService(UserDAO userDAO) {

		this.userDAO = userDAO;
	}

	public UserTO updateDateUser(UserTO user) {

		UserEntity updatedUser = userDAO.updateUserProfile(UserMapper.mapToEntity(user));
		return UserMapper.mapToTO(updatedUser);
	}

	public UserTO showProfilUser(UserTO user) {

		UserEntity userProfileInformacion = userDAO.showUserProfile(UserMapper.mapToEntity(user));
		return UserMapper.mapToTO(userProfileInformacion);
	}

	@LogExecutionTime
	public UserTO addAvailabilityHour(UserTO user, List<PlayabilityTO> availability) {
		UserEntity userEntityPlay = userDAO.addAvailabilityHours(UserMapper.mapToEntity(user),
				PlayabilitityMapper.mapPlayabilityToEntity(availability));
		return UserMapper.mapToTO(userEntityPlay);
	}

	public UserTO editAvailabilityHour(UserTO user, List<PlayabilityTO> availability) {
		UserEntity userPlay = userDAO.editAvailabilityHours(UserMapper.mapToEntity(user),
				PlayabilitityMapper.mapPlayabilityToEntity(availability));
		return UserMapper.mapToTO(userPlay);
	}

	public UserTO removeAvailabilityHour(UserTO user, List<PlayabilityTO> availability) {
		UserEntity userPlay = userDAO.deleteAvailabilityHours(UserMapper.mapToEntity(user),
				PlayabilitityMapper.mapPlayabilityToEntity(availability));
		return UserMapper.mapToTO(userPlay);
	}

	public UserTO getUserById(int i) {
		UserEntity user = userDAO.getUserById(i);
		return UserMapper.mapToTO(user);
	}

	public List<UserTO> getAllUsers() {
		List<UserEntity> allUser = userDAO.getAllUsers();
		return (List<UserTO>) UserMapper.mapUsersTO(allUser);
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
