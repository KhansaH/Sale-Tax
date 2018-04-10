package abstractFactory;

public class OtherProductFactory implements AbstractFactory{

	@Override
	public Product createProduct(String name, double price, boolean imported, int quantity,String type) {
		return(Product) new OtherProduct(name, price, imported, quantity);
	}

}
