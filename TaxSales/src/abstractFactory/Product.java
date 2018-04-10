package abstractFactory;

import java.text.DecimalFormat;

public abstract class Product {
	
	 protected String name;
	 protected Double price;
	 protected boolean imported;
	 protected int quantity;
	 protected Double tax;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public boolean isImported() {
		return imported;
	}
	public void setImported(boolean imported) {
		this.imported = imported;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}
	public Product(String name, Double price, boolean imported, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.imported = imported;
		this.quantity = quantity;
	}
	public Product() {
		this.name="";
		this.price=0.0;
		this.imported=false;
		this.quantity=0;
		this.tax=0.0;
		
	}
	public abstract Product getProduct(String name,double price,int quantity,boolean imported);
	public abstract double getvaluetax(boolean imported);
	
	public String toString(int quantity) {
		DecimalFormat df = new DecimalFormat("##.##");
        
		return quantity +" "+ name+" at  "+ df.format(price);
	}
	
	public String outputdisplay()
	{
		double priceall=0;
		double pricebyquantity=0.0; 
		String result;
		DecimalFormat df = new DecimalFormat("##.##");

		
		if(quantity>1)
		{
			priceall=price;
			pricebyquantity=price/quantity;
			result= name +": "+ df.format(priceall)+" ( "+quantity +" @ "+df.format(pricebyquantity)+ ")";
		}
		else
		{
			result= name +": "+ df.format(price);
		}
		return result;
	}
	
	 

}
