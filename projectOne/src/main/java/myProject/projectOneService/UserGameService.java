package myProject.projectOneService;

import java.util.Set;

import org.springframework.stereotype.Service;

import myProject.projectOneRepository.UserGameDAO;

@Service
public class UserGameService {

	private UserGameDAO userGameDAO;

	public Set<String> returnListGame(String name) throws Exception {
		return userGameDAO.returnListGame(name);
	}

	public void deleteGame(String userName, String nameGame) throws Exception {
		userGameDAO.deleteGame(userName, nameGame);
	}

	public void addNewGame(String userName, String nameGame) throws Exception {
		userGameDAO.addNewGame(userName, nameGame);
	}

}
