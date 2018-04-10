package abstractFactory;

public class BookProduct extends Product {

	public BookProduct() {
		super();
	}

	public BookProduct(String name, Double price, boolean imported, int quantity) {
		super(name, price, imported, quantity);
	}

	
	@Override
	public double getvaluetax(boolean imported) {
      if(imported)
    	  return 5;
		return 0;
	}

	@Override
	public Product getProduct(String name, double price, int quantity, boolean imported) {
		
		return new BookProduct(name,price,imported,quantity);
	}

}
