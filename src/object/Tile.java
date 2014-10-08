package object;

import java.util.ArrayList;

public class Tile {

	private int x;
	private int y;
	private ArrayList<Object> objects;
	private Human human;
	private ArrayList<Tile> neighbors;
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
		objects = new ArrayList<>();
		neighbors = new ArrayList<>();
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public ArrayList<Object> getObjects() {
		return objects;
	}
	
	public Human getHuman() {
		return human;
	}
	
	public boolean isOccupied() {
		return human != null;
	}
	
	public void placeObject(Object object) {
		object.setTile(this);
		objects.add(object);
	}
	
	public void placeHuman(Human human) {
		if (!isOccupied())
			this.human = human;
		else
			throw new IllegalArgumentException("The tile is already occupied by a human");
	}
	
	public boolean isEmpty() {
		return !isOccupied() && objects.isEmpty();
	}
	
	public void addObject(Object object) {
		objects.add(object);
	}
	
	public void removeObject(Object object) {
		objects.remove(object);
	}
	
	public ArrayList<Tile> getNeighbors(){
		return neighbors;
	}
	
	public void addNeighbor(Tile tile) {
		neighbors.add(tile);
	}

	public String toString() {
		return "[" + x + ", " + y + "]";
	}
}