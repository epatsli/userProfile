package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.entity.GameEntity;
import project.mapper.GameMapper;
import project.repository.GameDAO;
import project.to.GameTO;

@Service
public class GameService {

	private GameDAO gameData;

	@Autowired
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

	public GameTO getGameByName(String name) {
		return GameMapper.mapToTO(gameData.getGameByName(name));
	}

	public List<GameTO> getAllGame() {
		return GameMapper.mapGame(gameData.getAllGame());
	}

}
