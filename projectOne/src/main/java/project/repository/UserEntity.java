package project.repository;

import java.util.List;

import org.springframework.lang.NonNull;

public class UserEntity {

	private int id;

	@NonNull
	private String firstName;

	@NonNull
	private String lastName;

	@NonNull
	private String email;

	@NonNull
	private String password;

	private String lifeMotto;

	private List<PlayabilityEntity> playability;

	public UserEntity(int id, String firstName, String lastName, String email, String password, String lifeMotto,
			List<PlayabilityEntity> playability) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.lifeMotto = lifeMotto;
		this.playability = null;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<PlayabilityEntity> getPlayability() {
		return playability;
	}

	public void setPlayability(List<PlayabilityEntity> playability) {
		this.playability = playability;
	}

	@Override
	public String toString() {
		return "User firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password
				+ ", lifeMotto=" + lifeMotto + "]";
	}
}
