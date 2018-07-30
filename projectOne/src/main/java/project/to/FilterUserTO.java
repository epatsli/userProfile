package project.to;

import java.util.ArrayList;

public class FilterUserTO {
	private String firstName;
	private String lastName;
	private ArrayList<PlayabilityTO> playability;

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

	public ArrayList<PlayabilityTO> getPlayability() {
		return playability;
	}

	public void setPlayability(ArrayList<PlayabilityTO> playability) {
		this.playability = playability;
	}

}
