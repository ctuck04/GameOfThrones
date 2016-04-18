package data;

import java.util.ArrayList;
import java.util.List;

public class Char {
	private String firstName;
	private String lastName;
	private String gender;
	private String status;
	private List<Char> characters = new ArrayList<>();

	public Char () {
		
	}
	
	public Char (String firstName, String lastName, String gender, String status) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.status = status;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "First name:" + firstName + ", Last name:" + lastName + ", Gender:" + gender + " , Status:" + status;
	}
}
