package object;

import java.util.ArrayList;
import java.util.HashMap;

public class Lot {

	private HashMap<Integer, ArrayList<Object>> objectsOnLot;
	private HashMap<Integer, Human> humansOnLot;
	private int length;
	private int width;
	
	public Lot(int length, int width) {
		this.length = length;
		this.width = width;
		objectsOnLot = new HashMap<>();
		humansOnLot = new HashMap<>();
		for (int i = 0; i < length * width; i++) {
			objectsOnLot.put(i, new ArrayList<Object>());
		}
	}
	
	public int getX(int tile) {
		return tile % width;
	}
	
	public int getY(int tile) {
		return tile / width;
	}

	public int getLength() {
		return length;
	}

	public int getWidth() {
		return width;
	}

	public HashMap<Integer, ArrayList<Object>> getObjectsOnLot() {
		return objectsOnLot;
	}

	public HashMap<Integer, Human> getHumansOnLot() {
		return humansOnLot;
	}
	
	public ArrayList<Object> getObjectsOnTile(int tile) {
		return objectsOnLot.get(tile);
	}
	
	public Human getHumanOnTile(int tile) {
		return humansOnLot.get(tile);
	}
	
	public void placeObjectOnLot(int tile, Object object) {
		objectsOnLot.get(tile).add(object);
	}
	
	public void placeHumanOnLot(int tile, Human human) {
		humansOnLot.put(tile, human);
	}
	
	public boolean tileIsEmpty(int tile) {
		return objectsOnLot.get(tile).isEmpty() && !humansOnLot.containsKey(tile);
	}
	
	public ArrayList<Object> getAllObjectsOnLot() {
		ArrayList<Object> objects = new ArrayList<>();
		for (int i = 0; i < length * width; i++) {
			objects.addAll(objectsOnLot.get(i));
		}
		return objects;
	}

}
