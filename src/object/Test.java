package object;

public class Test {

	public static void main(String[] args) {
		Lot lot = new Lot(10, 10);
		Human human = new Human("Audun", "Lysbakken", Gender.MALE, lot);
		Chair chair1 = new Chair("Stol1", 140, 1, 1);
		Chair chair2 = new Chair("Stol2", 140, 1, 1);
		Chair chair3 = new Chair("Stol3", 140, 1, 1);
		Chair chair4 = new Chair("Stol4", 140, 1, 1);
		Tile[][] tiles = lot.getTiles();
		tiles[2][2].placeObject(chair1);
		tiles[1][5].placeObject(chair2);
		tiles[5][5].placeObject(chair3);
		tiles[1][9].placeObject(chair4);
		System.out.println(chair1.getName());
		tiles[3][4].placeHuman(human);
		//System.out.println(lot.getHumanOnTile(13));
		//System.out.println(lot.getAllObjectsOnLot());
		lot.removeObjectFromLot(chair1);
		//System.out.println(lot.getAllObjectsOnLot());
		
		System.out.println("----");
		
		System.out.println(chair2.getTile());
		lot.moveObject(chair2, tiles[7][7]);
		System.out.println(chair2.getTile());
		
		System.out.println("----");
		
		System.out.println(tiles[7][7].getObjects());
		
		System.out.println("----");
		int t = 0;
		System.out.println("Er rute " + t + " tom?");
		System.out.println(tiles[0][0].isEmpty());
		System.out.println("----");
		
		
		System.out.println(lot.getAvailableActions(human));
		
		human.goTo(tiles[5][9]);
		
	}
}
