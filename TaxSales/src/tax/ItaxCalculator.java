package tax;

import java.util.List;

import abstractFactory.Product;


public interface ItaxCalculator {
	
	List<Product> taxproducts(List<Product> list);

}
