package pgdp;

public class FruitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FruitBasket f1 = new FruitBasket();
		f1.addFruit(new Apple());
		f1.addFruit(new Banana());
		f1.addFruit(new Pineapple());
		f1.addFruit(new PinkLady());
		f1.addFruit(new GrannySmith());		
		f1.addFruit(null);

		System.out.println(f1.getEqualOrLongerShelfLife(-1));
		System.out.println(f1.getApples());
		System.out.println(f1.getEqualOrLongerShelfLife(21));
	}

}
