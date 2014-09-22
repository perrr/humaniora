package object;

public class Test {

	public static void main(String[] args) {
		Lot lot = new Lot(10, 10);
		Human human = new Human("Audun", "Lysbakken", Gender.MALE);
		Chair chair1 = new Chair("Stol1", 140, 1, 1);
		Chair chair2 = new Chair("Stol2", 140, 1, 1);
		Chair chair3 = new Chair("Stol3", 140, 1, 1);
		Chair chair4 = new Chair("Stol4", 140, 1, 1);
		lot.placeObjectOnLot(4, chair1);
		lot.placeObjectOnLot(10, chair2);
		lot.placeObjectOnLot(17, chair3);
		lot.placeObjectOnLot(4, chair4);
		System.out.println(chair1.getName());
		lot.placeHumanOnLot(13, human);
		System.out.println(lot.getHumanOnTile(13));
		System.out.println(lot.getAllObjectsOnLot());
		lot.removeObjectFromLot(chair1);
		System.out.println(lot.getAllObjectsOnLot());
		
		System.out.println("----");
		
		System.out.println(chair2.getTile());
		lot.moveObject(chair2, 17);
		System.out.println(chair2.getTile());
		
		System.out.println("----");
		
		System.out.println(lot.getObjectsOnTile(17));
		
		System.out.println("----");
		int t = 10;
		System.out.println("Er rute " + t + " tom?");
		System.out.println(lot.tileIsEmpty(t));
		System.out.println("----");
		
		
		System.out.println(lot.getAvailableActions(human));
		
		
		
	}
}
