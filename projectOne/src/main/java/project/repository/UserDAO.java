package project.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import project.domain.Playability;
import project.entity.UserEntity;

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

	public UserEntity getUserProfile(int i) {
		return userList.stream().filter(u -> u.getId() == i).collect(Collectors.toList()).get(0);
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

	public List<UserEntity> getAllUsers() {
		return userList;
	}

	public UserEntity getUserByEmail(String email) {
		return userList.stream().filter(u -> u.getEmail() == email).collect(Collectors.toList()).get(0);
	}

	///
	List<UserEntity> listUser = new ArrayList<UserEntity>();
	List<ArrayList<Playability>> list = new ArrayList<ArrayList<Playability>>();

	Map<UserEntity, List<Playability>> playabilityUser = new HashMap<>();

	public void addAvailabilityHours(int i, List<Playability> playability) {
		UserEntity user = userList.get(i - 1);
		playabilityUser.put(user, playability);
	}
}
