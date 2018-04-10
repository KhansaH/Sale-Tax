package abstractFactory;

public class OtherProduct extends Product {
	
	

	public OtherProduct() {
		super();
	}

	public OtherProduct(String name, Double price, boolean imported, int quantity) {
		super(name, price, imported, quantity);
	}

	@Override
	public Product getProduct(String name, double price, int quantity, boolean imported) {
		return new OtherProduct(name, price, imported, quantity);
	}

	@Override
	public double getvaluetax(boolean imported) {
		if(imported)
	    	  return 5;
			return 0;
	}

}
