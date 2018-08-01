package project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aspect.Aspect.LogExecutionTime;
import project.entity.UserEntity;
import project.mapper.PlayabilitityMapper;
import project.mapper.UserMapper;
import project.repository.UserDAO;
import project.to.FilterUserTO;
import project.to.PlayabilityTO;
import project.to.UserTO;
import utils.SearchParamsUtils;

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

	public UserTO getUserById(long i) {
		UserEntity user = userDAO.getUserById(i);
		return UserMapper.mapToTO(user);
	}

	public List<UserTO> getAllUsers() {
		List<UserEntity> allUser = userDAO.getAllUsers();
		return (List<UserTO>) UserMapper.mapUsersTO(allUser);
	}

	public List<UserTO> getUserByFilter(FilterUserTO user) {

		int paramsSum = SearchParamsUtils.countFilterUserParamsSum(user);
		String name = user.getFirstName();
		String lastName = user.getLastName();
		ArrayList<PlayabilityTO> playability = user.getPlayability();

		List<UserTO> result = new ArrayList<>();

		switch (paramsSum) {
		case 1:
			return UserMapper.mapUsersTO(userDAO.getUserByName(name));

		case 2:
			result = UserMapper.mapUsersTO(userDAO.getUserByLastName(lastName));
			break;
		case 3:
			result = UserMapper.mapUsersTO(userDAO.getUserByNameAndLastName(name, lastName));
			break;
		case 4:
			result = UserMapper.mapUsersTO(userDAO.getUserByPlayability(playability));
			break;
		case 5:
			result = UserMapper.mapUsersTO(userDAO.getUserByNameAndPlayability(name, playability));
			break;
		case 6:
			result = UserMapper.mapUsersTO(userDAO.getUserByLastNameAndPlayability(lastName, playability));
			break;
		case 7:
			result = UserMapper.mapUsersTO(userDAO.getUserByFilter(user));
			break;

		default:
			result = UserMapper.mapUsersTO(userDAO.getAllUsers());
			break;
		}

		return result;

	}

	private boolean nameIsEmpty(String name) {
		if (name.isEmpty() && name == "")
			return true;
		else
			return false;
	}
}
