package project.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import project.domain.GamePlayed;
import project.entity.UserEntity;

@Repository
public class HistoryGameDAO {

	List<UserEntity> userList;;

	private ArrayList<GamePlayed> previousGame = new ArrayList<GamePlayed>();
	/*
	 * public HistoryGameDAO() { previousGame.add(new GamePlayed(new
	 * GameEntity("Checkers", 2), userList.get(1), userList.get(2), 3));
	 * previousGame.add(new GamePlayed(new GameEntity("Checkers", 2),
	 * userList.get(1), userList.get(3), 3)); previousGame.add(new
	 * GamePlayed(new GameEntity("Checkers", 2), userList.get(2),
	 * userList.get(3), 3)); previousGame.add(new GamePlayed(new
	 * GameEntity("Chess", 2), userList.get(1), userList.get(2), 3));
	 * previousGame.add(new GamePlayed(new GameEntity("Chess", 2),
	 * userList.get(1), userList.get(3), 3)); previousGame.add(new
	 * GamePlayed(new GameEntity("Chess", 2), userList.get(2), userList.get(3),
	 * 3)); previousGame.add(new GamePlayed(new GameEntity("Queue", 4),
	 * userList.get(3), userList.get(2), 3)); previousGame.add(new
	 * GamePlayed(new GameEntity("Queue", 4), userList.get(3), userList.get(3),
	 * 3)); previousGame.add(new GamePlayed(new GameEntity("Queue", 4),
	 * userList.get(2), userList.get(3), 3));
	 * 
	 * }
	 */
}
