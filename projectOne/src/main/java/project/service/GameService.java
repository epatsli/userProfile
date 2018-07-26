package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.repository.GameDAO;

@Service
public class GameService {

	private final GameDAO gameData;

	@Autowired
	public GameService(GameDAO gameData) {
		this.gameData = gameData;
	}

	public boolean existGame(String nameGame) {
		boolean bool = (gameData.existGame(nameGame)) ? true : false;
		return bool;
	}

}
