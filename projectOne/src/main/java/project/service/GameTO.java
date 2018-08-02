package project.service;

public class GameTO {
	private String Name;
	private int numberPlayer;

	public GameTO(String name, int numberPlayer) {
		Name = name;
		this.numberPlayer = numberPlayer;
	}

	public String getName() {
		return Name;
	}

	public int getNumberPlayer() {
		return numberPlayer;
	}

	public void setNumberPlayer(int numberPlayer) {
		this.numberPlayer = numberPlayer;
	}

	public void setName(String name) {
		Name = name;
	}

}
