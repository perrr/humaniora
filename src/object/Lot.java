package object;

import java.util.ArrayList;
import java.util.HashMap;

public class Lot {

	private Tile[][] tiles;
	
	public Lot(int length, int width) {
		tiles = new Tile[length][width];
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[i].length; j++) {
				tiles[i][j] = new Tile(i, j);
			}
		}
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[i].length; j++) {
				addNeighbors(tiles[i][j]);
			}
		}
	}
	
	public int getLength() {
		return tiles.length;
	}

	public int getWidth() {
		return tiles[0].length;
	}
	
	public Tile[][] getTiles() {
		return tiles;
	}

	public ArrayList<Object> getObjectsOnLot() {
		ArrayList<Object> objectsOnLot = new ArrayList<>();
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[i].length; j++) {
				objectsOnLot.addAll(tiles[i][j].getObjects());
			}
		}
		return objectsOnLot;
	}

	public ArrayList<Human> getHumansOnLot() {
		ArrayList<Human> humansOnLot = new ArrayList<>();
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[i].length; j++) {
				if (tiles[i][j].isOccupied())
					humansOnLot.add(tiles[i][j].getHuman());
			}
		}
		return humansOnLot;
	}

	public void removeObjectFromLot(Object object) {
		object.getTile().removeObject(object);
		object.setTile(null);
	}
	
	public void moveObject(Object object, Tile toTile) {
		removeObjectFromLot(object);
		toTile.addObject(object);
		object.setTile(toTile);
	}
	
	public ArrayList<Action> getAvailableActions(Human human) {
		ArrayList<Action> availableActions = new ArrayList<>();
		
		for (Object object : getObjectsOnLot()) {
			if (!object.isInUse() || object.getUsedBy() == human) {
				availableActions.add(new Action(human, object));
			}
		}
		
		return availableActions;
	}
	
	public ArrayList<Tile> findShortestPath(Tile fromTile, Tile toTile) { // Uses A*	
		ArrayList<Tile> openNodes = new ArrayList<>();
		ArrayList<Tile> closedNodes = new ArrayList<>();
		HashMap<Tile, ArrayList<Tile>> shortestPath = new HashMap<>();
		
		Tile currentNode = fromTile;
		shortestPath.put(currentNode, new ArrayList<Tile>());
		
		while (currentNode != toTile) {
			closedNodes.add(currentNode);
			
			for (Tile neighborNode : currentNode.getNeighbors()) {
				if (!closedNodes.contains(neighborNode) && neighborNode.isEmpty()) {
					
					if (!openNodes.contains(neighborNode)) {
						openNodes.add(neighborNode);
					}
					
					if(shortestPath.get(neighborNode) == null || shortestPath.get(neighborNode).size() > shortestPath.get(currentNode).size() + 1) {
						ArrayList<Tile> newShortestPath = new ArrayList<>();
						newShortestPath.addAll(shortestPath.get(currentNode));
						newShortestPath.add(currentNode);
						shortestPath.put(neighborNode, newShortestPath);
					}
					
				}
				
			}
			
			Tile bestNode = null;
			int bestCost = Integer.MAX_VALUE;
			for (Tile openNode : openNodes) {
				int cost = shortestPath.get(openNode).size() + heuristic(openNode, toTile);
				if (cost < bestCost) {
					bestNode = openNode;
					bestCost = cost;
				}
			}
			
			currentNode = bestNode;
			openNodes.remove(currentNode);
		}
		
		return shortestPath.get(toTile);
	}
	
	private int heuristic(Tile fromTile, Tile toTile) {
		return Math.abs(toTile.getX() - fromTile.getX()) + Math.abs(toTile.getY() - fromTile.getY());
	}
	
	private void addNeighbors(Tile tile) {
		if(tile.getX() > 0) tile.addNeighbor(tiles[tile.getX()-1][tile.getY()]);
		if(tile.getX() < tiles.length-1) tile.addNeighbor(tiles[tile.getX()+1][tile.getY()]);
		if(tile.getY() > 0) tile.addNeighbor(tiles[tile.getX()][tile.getY()-1]);
		if(tile.getY() < tiles[tile.getX()].length-1) tile.addNeighbor(tiles[tile.getX()][tile.getY()+1]);
	}
}