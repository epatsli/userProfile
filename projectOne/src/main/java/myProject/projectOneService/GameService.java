package myProject.projectOneService;

import java.util.List;

import org.springframework.stereotype.Service;

import myProject.projectOneDomain.Game;
import myProject.projectOneRepository.GameData;

@Service
public class GameService {
	private GameData gameData;

	public GameService() {
		super();
		this.gameData = new GameData();
	}

	public List<Game> getListAllGame() {
		return gameData.getListGame();
	}

	public boolean findGame(String nameGame) {
		if (gameData.findGame(nameGame))
			return true;
		return false;
	}
}
