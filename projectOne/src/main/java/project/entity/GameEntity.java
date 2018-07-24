package project.entity;

public class GameEntity {

	private String name;
	private int numberPlayer;

	public GameEntity(String name, int numberPlayer) {
		this.name = name;
		this.numberPlayer = numberPlayer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberPlayer() {
		return numberPlayer;
	}

	public void setNumberPlayer(int numberPlayer) {
		this.numberPlayer = numberPlayer;
	}

}
