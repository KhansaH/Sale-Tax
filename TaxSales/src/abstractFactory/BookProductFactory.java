package abstractFactory;

public class BookProductFactory implements AbstractFactory{

	@Override
	public Product createProduct(String name, double price, boolean imported, int quantity,String type) {
		return(Product) new BookProduct(name, price, imported, quantity);
	}

}
