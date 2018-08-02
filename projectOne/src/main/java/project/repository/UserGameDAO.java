package project.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserGameDAO {

	List<GameEntity> listGameUserOne = new ArrayList<>();
	List<GameEntity> listGameUserTwo = new ArrayList<>();
	List<GameEntity> listGameUserThree = new ArrayList<>();
	UserEntity user;
	GameDAO setGame;

	public UserGameDAO() {
		listGameUserOne.add(new GameEntity("Checkers", 2));
		listGameUserOne.add(new GameEntity("Poker", 3));
		listGameUserOne.add(new GameEntity("Queue", 4));

		listGameUserTwo.add(new GameEntity("Chess", 2));
		listGameUserTwo.add(new GameEntity("Poker", 3));

		listGameUserThree.add(new GameEntity("Queue", 4));
		listGameUserThree.add(new GameEntity("Checkers", 2));
		listGameUserThree.add(new GameEntity("Poker", 3));
	}

	/*
	 * public Set<String> returnListGame(String name) throws Exception { if
	 * (user.getFirstName().equals("Jan")) { return listGameUserOne; } else if
	 * (user.getFirstName().equals("Olga")) { return listGameUserTwo; } else if
	 * (user.getFirstName().equals("Michal")) { return listGameUserThree; } else
	 * throw new Exception("This user don't have list of games."); }
	 * 
	 * public void deleteGame(String userName, String nameGame) throws Exception
	 * { Set<String> result = returnListGame(userName); result.remove(nameGame);
	 * }
	 * 
	 * public void addNewGame(String userName, String nameGame) throws Exception
	 * { Set<String> result = returnListGame(userName); if
	 * (setGame.existGame(nameGame)) { result.add(nameGame); } else { GameEntity
	 * newGame = new GameEntity("Chinese", 5); result.add(newGame.getName()); }
	 * }
	 */
	////
	public List<GameEntity> returnListGame(UserEntity user) throws Exception {
		if (user.getId() == 1) {
			return listGameUserOne;
		} else if (user.getId() == 2) {
			return listGameUserTwo;
		} else if (user.getId() == 3) {
			return listGameUserThree;
		} else
			throw new Exception("This user don't have list of games.");
	}

	public List<GameEntity> deleteGame(UserEntity user, GameEntity game) throws Exception {
		List<GameEntity> setGame = returnListGame(user);
		for (GameEntity gm : setGame) {
			if (game.getName().equals(gm.getName()))
				setGame.remove(game);
			break;
		}
		return setGame;
	}

	public List<GameEntity> addNewGame(UserEntity user, GameEntity game) throws Exception {

		List<GameEntity> setGame = returnListGame(user);
		int count = 0;
		for (GameEntity gm : setGame) {
			if (gm.getName().equals(game.getName())) {
				setGame.add(game);
				break;
			} else {
				++count;
			}
		}
		if (count == setGame.size()) {
			GameEntity newGame = new GameEntity("Chinese", 5);
			setGame.add(game);
		}
		return setGame;

	}
}
