package abstractFactory;

public interface  AbstractFactory {
	
	 Product createProduct(String name,double price, boolean imported, int quantity, String Type);

}
