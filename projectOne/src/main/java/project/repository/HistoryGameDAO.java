package project.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import project.domain.GamePlayed;
import project.entity.GameEntity;

public class HistoryGameDAO {
	GameEntity game;
	ArrayList<GamePlayed> previousGame = new ArrayList<GamePlayed>();
	Map<GameEntity, ArrayList<GamePlayed>> historyGame = new HashMap<>();

	public HistoriaGameDAO()
	{
		previousGame.add(new("Chess",));
	historyGame.put(new GameEntity("Chess", 2), value);
	}
}
