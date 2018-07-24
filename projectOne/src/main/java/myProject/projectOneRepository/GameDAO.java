package myProject.projectOneRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import myProject.projectOneDomain.Game;

@Repository
public class GameDAO {

	private Set<Game> listGame = new HashSet<>();

	public GameDAO() {

		listGame.add(new Game("Checkers", 2));
		listGame.add(new Game("Chess", 2));
		listGame.add(new Game("Poker", 3));
		listGame.add(new Game("Queue", 4));
	}

	public List<Game> getListGame() {
		return listGame.stream().filter(u -> (u.getName()).length() > 0).collect(Collectors.toList());
	}

	public boolean existGame(String nameGame) {
		boolean bool = (listGame.contains(nameGame)) ? true : false;
		return bool;
	}
}
