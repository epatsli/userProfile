package project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import project.entity.GameEntity;
import project.repository.GameDAO;

@Service
public class GameService {

	private GameDAO gameData;

	public GameService() {
		this.gameData = new GameDAO();
	}

	public List<GameEntity> getListAllGame() {
		return gameData.getListGame();
	}

	public boolean existGame(String nameGame) {
		boolean bool = (gameData.existGame(nameGame)) ? true : false;
		return bool;
	}

}
