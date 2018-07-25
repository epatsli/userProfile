package project.to;

import java.util.ArrayList;

import project.domain.Playability;

public class UserTO {
	private int id;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String lifeMotto;
	private ArrayList<Playability> playability;

	public UserTO(int id, String firstName, String lastName, String email, String password, String lifeMotto) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.lifeMotto = lifeMotto;
		this.playability = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLifeMotto() {
		return lifeMotto;
	}

	public void setLifeMotto(String lifeMotto) {
		this.lifeMotto = lifeMotto;
	}

	public ArrayList<Playability> getPlayability() {
		return playability;
	}

	public void setPlayability(ArrayList<Playability> playability) {
		this.playability = playability;
	}

}
