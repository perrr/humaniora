package object;

public class Human {

	private String firstName;
	private String lastName;
	private Gender gender;
	
	// Needs
	private int hunger, comfort, energy, bladder, hygiene, social, entertainment;
	
	public Human(String firstName, String lastName, Gender gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		
		hunger = comfort = energy = bladder = hygiene = social = entertainment = 100;
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
	
	public String getFullName() {
		return firstName + " " + lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public String toString() {
		return getFullName();
	}
	
}