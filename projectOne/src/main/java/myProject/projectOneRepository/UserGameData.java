package myProject.projectOneRepository;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

import myProject.projectOneDomain.Game;
import myProject.projectOneDomain.User;

@Repository
public class UserGameData {

	Set<String> listGameUserOne = new HashSet<>();
	Set<String> listGameUserTwo = new HashSet<>();
	Set<String> listGameUserThree = new HashSet<>();
	User user;
	GameData setGame;

	public UserGameData() {

		listGameUserOne.add("Checkers");
		listGameUserOne.add("Poker");
		listGameUserOne.add("Queue");

		listGameUserTwo.add("Chess");
		listGameUserTwo.add("Poker");

		listGameUserThree.add("Queue");
		listGameUserThree.add("Checkers");
		listGameUserThree.add("Poker");
	}

	public Set<String> returnListGame(String name) throws Exception {
		if (user.getFirstName().equals("Jan")) {
			return listGameUserOne;
		} else if (user.getFirstName().equals("Olga")) {
			return listGameUserTwo;
		} else if (user.getFirstName().equals("Michal")) {
			return listGameUserThree;
		} else
			throw new Exception("This user don't have list of games.");
	}

	public void deleteGame(String userName, String nameGame) throws Exception {
		Set<String> result = returnListGame(userName);
		result.remove(nameGame);
	}

	public void addNewGame(String userName, String nameGame) throws Exception {
		Set<String> result = returnListGame(userName);
		if (setGame.findGame(nameGame)) {
			result.add(nameGame);
		} else {
			Game newGame = new Game("Chinese", 5);
			result.add(newGame.getName());
		}
	}

}
