package tax;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import abstractFactory.OtherProduct;
import abstractFactory.Product;


public class TaxCalculator  implements ItaxCalculator{

	@Override
	public List<Product> taxproducts(List<Product> list) {
		List<Product> aftertax= new ArrayList<Product>();
		for (int i=0; i<list.size();i++)
		{
			float tax=0;
			float t=0;
			
			Product p= list.get(i);
			double pricet=0;

			for (int j=0;j<p.getQuantity();j++)
			{
				tax=0;
				pricet=p.getPrice()+pricet;
				
			float taxpercentage;
			if(p instanceof OtherProduct )
			{
				taxpercentage= (float) (p.getvaluetax(p.isImported())+10);

				tax=taxcalulation( new BigDecimal (taxpercentage) ,  p);

				
				
			}
			else
			{

				tax=taxcalulation( new BigDecimal (p.getvaluetax(p.isImported())) ,  p);

			}
			
			pricet=pricet+tax;

			t=t+tax;
			
			
			}
			
			p.setTax((double) t);
			p.setPrice((double)pricet);
			aftertax.add(i, p);
		}
		return aftertax;
	}
	
	public float taxcalulation(BigDecimal taxpercentage , Product p)
	{
		BigDecimal bigprice=new BigDecimal(p.getPrice());	

		BigDecimal salestax= bigprice.multiply(taxpercentage).divide(new BigDecimal("100"));
		
		salestax= salestax.divide(new BigDecimal("0.05"));
		salestax= new BigDecimal(Math.ceil(salestax.doubleValue()));
		salestax=salestax.multiply(new BigDecimal("0.05"));
		
		float tx= salestax.floatValue();	
		

		return tx;
	}


	
}
