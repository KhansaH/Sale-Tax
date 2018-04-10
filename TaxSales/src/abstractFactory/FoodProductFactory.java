package abstractFactory;

public class FoodProductFactory implements AbstractFactory{

	@Override
	public Product createProduct(String name, double price, boolean imported, int quantity,String type) {
		return(Product) new FoodProduct(name, price, imported, quantity);
	}

}
