package abstractFactory;

public class FoodProduct extends Product
{
	

	public FoodProduct() {
		super();
	}

	public FoodProduct(String name, Double price, boolean imported, int quantity) {
		super(name, price, imported, quantity);
	}

	@Override
	public Product getProduct(String name, double price, int quantity, boolean imported) {
		return new FoodProduct(name, price, imported, quantity);
	}

	@Override
	public double getvaluetax(boolean imported) {
		if(imported)
	    	  return 5;
			return 0;
	}

}
