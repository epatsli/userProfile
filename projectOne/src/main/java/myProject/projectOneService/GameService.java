package myProject.projectOneService;

import java.util.List;

import org.springframework.stereotype.Service;

import myProject.projectOneDomain.Game;
import myProject.projectOneRepository.GameDAO;

@Service
public class GameService {
	private GameDAO gameData;

	public GameService() {
		this.gameData = new GameDAO();
	}

	public List<Game> getListAllGame() {
		return gameData.getListGame();
	}

	public boolean findGame(String nameGame) {
		boolean bool = (gameData.existGame(nameGame)) ? true : false;
		return bool;
	}
}
