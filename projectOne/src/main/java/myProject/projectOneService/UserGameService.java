package myProject.projectOneService;

import java.util.Set;

import org.springframework.stereotype.Service;

import myProject.projectOneRepository.UserGameData;

@Service
public class UserGameService {

	private UserGameData userGameData;

	public Set<String> returnListGame(String name) throws Exception {
		return userGameData.returnListGame(name);
	}

	public void deleteGame(String userName, String nameGame) throws Exception {
		userGameData.deleteGame(userName, nameGame);
	}

	public void addNewGame(String userName, String nameGame) throws Exception {
		userGameData.addNewGame(userName, nameGame);
	}

}
