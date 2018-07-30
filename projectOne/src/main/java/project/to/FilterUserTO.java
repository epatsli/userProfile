package project.to;

import java.util.ArrayList;

import project.entity.PlayabilityEntity;

public class FilterUserTO {
	private String firstName;
	private String lastName;
	private ArrayList<PlayabilityEntity> playability;

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

	public ArrayList<PlayabilityEntity> getPlayability() {
		return playability;
	}

	public void setPlayability(ArrayList<PlayabilityEntity> playability) {
		this.playability = playability;
	}

}
