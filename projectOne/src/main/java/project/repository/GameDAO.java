package project.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import project.entity.GameEntity;

@Repository
public class GameDAO {

	private Set<GameEntity> listGame = new HashSet<>();

	public GameDAO() {

		listGame.add(new GameEntity("Checkers", 2));
		listGame.add(new GameEntity("Chess", 2));
		listGame.add(new GameEntity("Poker", 3));
		listGame.add(new GameEntity("Queue", 4));
	}

	public List<GameEntity> getListGame() {
		return listGame.stream().filter(u -> (u.getName()).length() > 0).collect(Collectors.toList());
	}

	public boolean existGame(String nameGame) {
		boolean bool = (listGame.contains(nameGame)) ? true : false;
		return bool;
	}

	public GameEntity getGameByName(String name) {
		return listGame.stream().filter(g -> g.getName() == name).collect(Collectors.toList()).get(0);
	}

	public Set<GameEntity> getAllGame() {
		return listGame;
	}
}
