package abstractFactory;

public class MedicalProductFactory implements AbstractFactory{

	@Override
	public Product createProduct(String name, double price, boolean imported, int quantity,String type) {
		return(Product) new MedicalProduct(name, price, imported, quantity);
	}
}
