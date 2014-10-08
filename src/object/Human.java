package object;

public class Human {

	private String firstName;
	private String lastName;
	private Gender gender;
	private Tile position;
	private Lot lot;
	
	// Needs
	private int hunger, comfort, energy, bladder, hygiene, social, entertainment;
	
	public Human(String firstName, String lastName, Gender gender, Lot lot) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.position = lot.getTiles()[0][0]; // Arbitraty tile
		this.lot = lot;
		
		hunger = comfort = energy = bladder = hygiene = social = entertainment = 100;
	}
	
	public int getHunger() {
		return hunger;
	}

	public int getComfort() {
		return comfort;
	}

	public int getEnergy() {
		return energy;
	}

	public int getBladder() {
		return bladder;
	}

	public int getHygiene() {
		return hygiene;
	}

	public int getSocial() {
		return social;
	}

	public int getEntertainment() {
		return entertainment;
	}
	
	private int increaseNeed(int increase, int need) {
		need += increase;
		if (need < 0)
			need = 0;
		else if (need > 100)
			need = 100;
		return need;
	}
	
	public void increaseHunger(int increase) { // Could be a positive or negative number
		hunger = increaseNeed(increase, hunger);
	}
	
	public void increaseComfort(int increase) { // Could be a positive or negative number
		comfort = increaseNeed(increase, comfort);
	}
	
	public void increaseEnergy(int increase) { // Could be a positive or negative number
		energy = increaseNeed(increase, energy);
	}
	
	public void increaseBladder(int increase) { // Could be a positive or negative number
		bladder = increaseNeed(increase, bladder);
	}
	
	public void increaseHygiene(int increase) { // Could be a positive or negative number
		hygiene = increaseNeed(increase, hygiene);
	}
	
	public void increaseSocial(int increase) { // Could be a positive or negative number
		social = increaseNeed(increase, social);
	}
	
	public void increaseEntertainment(int increase) { // Could be a positive or negative number
		entertainment = increaseNeed(increase, entertainment);
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
	
	public Tile getPosition() {
		return position;
	}
	
	public Lot getLot() {
		return lot;
	}
	
	public String toString() {
		return getFullName();
	}
	
	public void goTo(Tile tile) {
		System.out.println(lot.findShortestPath(this.position, tile));
	}
}