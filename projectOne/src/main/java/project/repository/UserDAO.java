package project.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import project.service.FilterUserTO;
import project.service.PlayabilityTO;

@Repository
public class UserDAO {

	private List<UserEntity> userList = new ArrayList<UserEntity>();

	public UserDAO() {
		userList.add(new UserEntity(1, "Jan", "Nowak", "jan.nowak@gmail.com", "password", "Life is to short.", null));
		userList.add(new UserEntity(2, "Olga", "Kowalska", "ola.kowalska@gmail.com", "admin", "I want to die.", null));
		userList.add(new UserEntity(3, "Michal", "Tyka", "michal.tyka@gmail.com", "1234", "I don't belive.", null));
	}

	public UserEntity getUserById(long i) {
		UserEntity user = userList.stream().filter(u -> u.getId() == i).findFirst().orElse(null);
		return user;
	}
	/*
	 * public UserEntity getUserById(int i) { return userList.stream().filter(u
	 * -> u.getId() == i).collect(Collectors.toList()).get(0); }
	 * 
	 * public UserEntity getUserProfile(int i) { return
	 * userList.stream().filter(u -> u.getId() ==
	 * i).collect(Collectors.toList()).get(0); }
	 * 
	 * public void setUserProfile(int i, String newName, String newLastName,
	 * String newMail, String newPassword, String newLifeMotto) { UserEntity
	 * user = getUserById(i); user.setFirstName(newName);
	 * user.setLastName(newLastName); user.setEmail(newMail);
	 * user.setPassword(newPassword); user.setLifeMotto(newLifeMotto); }
	 */

	public List<UserEntity> getAllUsers() {
		return userList;
	}

	public UserEntity getUserByEmail(String email) {
		return userList.stream().filter(u -> u.getEmail() == email).collect(Collectors.toList()).get(0);
	}

	public UserEntity updateUserProfile(UserEntity user) {
		int id = user.getId();
		int i = 0;
		for (UserEntity usr : userList) {
			if (usr.getId() == id) {
				userList.remove(i);
				userList.add(i, user);
				break;
			} else {
				i++;
			}
		}
		return user;
	}

	public UserEntity showUserProfile(UserEntity user) {
		user.toString();
		return user;
	}

	Map<UserEntity, List<PlayabilityEntity>> playabilityUser = new HashMap<>();

	public UserEntity addAvailabilityHours(UserEntity user, List<PlayabilityEntity> playability) {

		int id = user.getId();
		for (UserEntity usr : userList) {
			if (usr.getId() == id) {
				usr.setPlayability(playability);
				break;
			}
		}
		return user;
	}

	public UserEntity editAvailabilityHours(UserEntity user, List<PlayabilityEntity> playability) {

		int id = user.getId();
		List<PlayabilityEntity> abilityUser = userList.stream().filter(u -> u.getId() == id)
				.collect(Collectors.toList()).get(0).getPlayability();

		for (PlayabilityEntity pl : abilityUser) {
			if (pl.equals(playability)) {
				abilityUser.remove(pl);
				abilityUser.add(playability.get(0));
				break;
			}
		}
		return user;
	}

	public UserEntity deleteAvailabilityHours(UserEntity user, List<PlayabilityEntity> playability) {
		int id = user.getId();
		List<PlayabilityEntity> abilityUser = userList.stream().filter(u -> u.getId() == id)
				.collect(Collectors.toList()).get(0).getPlayability();

		for (PlayabilityEntity pl : abilityUser) {
			if (pl.equals(playability.get(0))) {
				pl.setStartDate(null);
				pl.setEndDate(null);
				pl.setComment("I can't play in this moment.");
				break;
			}
		}
		return user;
	}

	public List<UserEntity> getUserByFilter(FilterUserTO filterUser) {
		return userList.stream()
				.filter(u -> u.getFirstName().startsWith(filterUser.getFirstName())
						&& u.getLastName().equals(filterUser.getLastName())
						&& u.getPlayability().contains(filterUser.getPlayability()))
				.collect(Collectors.toList());
	}

	public List<UserEntity> getUserByNameAndLastName(String name, String lastName) {
		return userList.stream().filter(u -> u.getFirstName().startsWith(name) && u.getLastName().equals(lastName))
				.collect(Collectors.toList());
	}

	public List<UserEntity> getUserByNameAndPlayability(String name, ArrayList<PlayabilityTO> arrayList) {
		return userList.stream()
				.filter(u -> u.getFirstName().startsWith(name) && u.getPlayability().contains(arrayList))
				.collect(Collectors.toList());
	}

	public List<UserEntity> getUserByLastNameAndPlayability(String lastName, ArrayList<PlayabilityTO> arrayList) {
		return userList.stream().filter(u -> u.getLastName().equals(lastName) && u.getPlayability().contains(arrayList))
				.collect(Collectors.toList());
	}

	public List<UserEntity> getUserByName(String name) {
		return userList.stream().filter(u -> u.getFirstName().startsWith(name)).collect(Collectors.toList());
	}

	public List<UserEntity> getUserByPlayability(ArrayList<PlayabilityTO> arrayList) {
		return userList.stream().filter(u -> u.getPlayability().contains(arrayList)).collect(Collectors.toList());
	}

	public List<UserEntity> getUserByLastName(String lastName) {
		return userList.stream().filter(u -> u.getLastName().equals(lastName)).collect(Collectors.toList());
	}

}
