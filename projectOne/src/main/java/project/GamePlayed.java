package project;

import java.util.Date;

import project.repository.GameEntity;
import project.repository.UserEntity;

public class GamePlayed {
	private GameEntity Game;
	private UserEntity UserWin;
	private UserEntity UserLose;
	private Date date;
	private int Point;

	public GamePlayed(GameEntity game, UserEntity userWin, UserEntity userLose, int point) {
		Game = game;
		UserWin = userWin;
		UserLose = userLose;
		Point = point;
	}

	public GameEntity getGame() {
		return Game;
	}

	public void setGame(GameEntity game) {
		Game = game;
	}

	public UserEntity getUserWin() {
		return UserWin;
	}

	public void setUserWin(UserEntity userWin) {
		UserWin = userWin;
	}

	public UserEntity getUserLose() {
		return UserLose;
	}

	public void setUserLose(UserEntity userLose) {
		UserLose = userLose;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getPoint() {
		return Point;
	}

	public void setPoint(int point) {
		Point = point;
	}

}
