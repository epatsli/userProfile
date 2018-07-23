package myProject.projectOneDomain;

import org.springframework.lang.NonNull;

public class User {

	@NonNull
	private String firstName;

	@NonNull
	private String lastName;

	@NonNull
	private String email;

	@NonNull
	private String password;

	private String lifeMotto;

	public User(String firstName, String lastName, String email, String password, String lifeMotto) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.lifeMotto = lifeMotto;

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

	@Override
	public String toString() {
		return "User firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password
				+ ", lifeMotto=" + lifeMotto + "]";
	}
}
