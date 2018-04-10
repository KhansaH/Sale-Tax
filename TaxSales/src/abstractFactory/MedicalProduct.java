package abstractFactory;

public class MedicalProduct extends Product {

	public MedicalProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MedicalProduct(String name, Double price, boolean imported, int quantity) {
		super(name, price, imported, quantity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Product getProduct(String name, double price, int quantity, boolean imported) {
		return new MedicalProduct(name,price,imported,quantity);
	}

	@Override
	public double getvaluetax(boolean imported) {
		if(imported)
	    	  return 5;
			return 0;
	}

	

	

}
