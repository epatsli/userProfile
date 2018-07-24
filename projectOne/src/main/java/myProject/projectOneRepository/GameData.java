package myProject.projectOneRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import myProject.projectOneDomain.Game;

@Repository
public class GameData {

	private Set<Game> listGame = new HashSet<>();

	public GameData() {
		Game game = new Game("Checkers", 2);
		listGame.add(game);
		game = new Game("Chess", 2);
		listGame.add(game);
		game = new Game("Poker", 3);
		listGame.add(game);
		game = new Game("Queue", 4);
		listGame.add(game);
	}

	public List<Game> getListGame() {
		return (List<Game>) listGame.stream().filter(u -> (u.getName()).length() > 0).collect(Collectors.toList());
	}

	public boolean findGame(String nameGame) {
		if (listGame.contains(nameGame))
			return true;
		return false;
	}
}
