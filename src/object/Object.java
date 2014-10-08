package object;

public abstract class Object {

	private final String name;
	private final int price;
	private final int length;
	private final int width;
	private Human inUseBy;
	private Tile tile;
	private int rotation; // a number from 0 to 3
	
	public Object(String name, int price, int length, int width) {
		this.name = name;
		this.price = price;
		this.length = length;
		this.width = width;
		rotation = 0;
		inUseBy = null;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getLength() {
		return length;
	}

	public int getWidth() {
		return width;
	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}
	
	public void rotateLeft() {
		rotation = (rotation - 1) % 4;
	}
	
	public void rotateRight() {
		rotation = (rotation + 1) % 4;
	}
	
	public String toString() {
		return name;
	}
	
	public void setTile(Tile tile) {
		this.tile = tile;
	}
	
	public Tile getTile() {
		return tile;
	}
	
	public Human getUsedBy() {
		return inUseBy;
	}
	
	public void setUsedBy(Human human) {
		inUseBy = human;
	}
	
	public boolean isInUse() {
		return inUseBy != null;
	}
}