package pgdp;
import java.util.LinkedList;

public class FruitBasket {

	private LinkedList<Fruit> fruits = new LinkedList<Fruit>();
	
	public void addFruit(Fruit f) {
		if(f == null) {
			return;
		}
		fruits.add(f);
	}
	
	public LinkedList<Apple> getApples() {
		LinkedList<Apple> apples = new LinkedList<Apple>();
		for(Fruit f : fruits) {
			if(f.isApple() == true) {
				apples.add((Apple) f);
			}
		}
		return apples;
	}
	
	public LinkedList<Fruit> getEqualOrLongerShelfLife(int n) {
		LinkedList<Fruit> shelfLifeFruits = new LinkedList<Fruit>();
		for(Fruit f : fruits) {
			if(f.shelfLife() >= n) {
				shelfLifeFruits.add(f);
			}
		}
		return shelfLifeFruits;
	}

}
