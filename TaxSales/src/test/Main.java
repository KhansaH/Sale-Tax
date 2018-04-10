package test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import abstractFactory.AbstractFactory;
import abstractFactory.BookProductFactory;
import abstractFactory.FoodProductFactory;
import abstractFactory.MedicalProductFactory;
import abstractFactory.OtherProductFactory;
import abstractFactory.Product;
import tax.ItaxCalculator;
import tax.TaxCalculator;




public class Main {
	
	public  static void main (String[] args)
	{

	List<Product> listproducts=new ArrayList<Product>();
	// read the input From the console
	Scanner scanner= new Scanner(System.in);
	boolean more=true;
	String name="";
	double price;
	boolean imported;
	int quantity;
	
	while (more==true)// more= false if we finish entering all the product
	{
		AbstractFactory ab = null;
	
		name="";
		price=0.0;
		imported=false;
		quantity=0;
		
	System.out.println("Can you please enter the product name");
	name=scanner.nextLine();
	if(name.isEmpty())
    {
      System.out.println("name can not be empty");
  	  System.out.println("Can you please enter the product name");
  	  name=scanner.nextLine();

    }
	
	System.out.println("Can you please enter the price of the product");
	while (scanner.hasNextDouble()==false) // check if the value is double if not we ask another time for the value
	{
		 System.out.println("Invalid input");
		 System.out.println("Can you please enter the price of the product");
		 scanner.next();

	}
	try 
	{
	price=scanner.nextDouble();
	}
	catch(Exception e)
	{
		 System.out.println("Invalid input");

	}

	scanner.nextLine();
	boolean ok=false;
	while(ok==false)// the value need to be yes or no 
	{
	System.out.println("Is your product imported or not [yes/no]");
	String input=scanner.nextLine();
	if(input.toLowerCase().equals("yes"))
	{
		imported=true;
		ok=true;
	}
	else
	{
		if(input.toLowerCase().equals("no"))
		{
          imported=false;
          ok=true;
		}
		
	}
	}
	System.out.println("Can you please enter the quantity of the product");

	while (scanner.hasNextInt()==false)// check if the value is integer
	{
		 System.out.println("Invalid input");
		 System.out.println("Can you please enter the quantity of the product");
		 scanner.next();

	}
	try
	{
		quantity=scanner.nextInt(4);// exception
	}
	catch(Exception e)
	{
		 System.out.println("Invalid input");

	}
	scanner.nextLine();
    ok=false;
	Product P = null;

    while(ok==false)//the value need to be book or medical food or other
    {
	System.out.println("Is your product a Book , Medical , Food or Other [ book/food/medical/other] ")		;
	String input2= scanner.nextLine();
    // I used the design pattern Abstract Factory
	// Since we have for 4 object type Food/ medical/book/other 
	
	if(input2.toLowerCase().equals("food"))
	{
		ab=new FoodProductFactory();
		P=ab.createProduct(name, price, imported, quantity,"food");
		ok=true;
	}
	else
	{
		if(input2.toLowerCase().equals("medical"))
		{
			ab=new MedicalProductFactory();
		    P=ab.createProduct(name, price, imported, quantity,"medical");
		    ok=true;
		}
		else
		{
			if(input2.toLowerCase().equals("book"))
			{
				 ab= new BookProductFactory();
				 P=ab.createProduct(name, price, imported, quantity,"book");
				 ok=true;
			}
			else
			{
				if(input2.toLowerCase().equals("other"))
				{
					ab= new OtherProductFactory();
					P=ab.createProduct(name, price, imported, quantity,"other");
					ok=true;
				}
			}
			
		}
	}
	}
	
	
	
	listproducts.add(P)	;
	ok= false;
	while(ok==false)
	{
	System.out.println("Do you have other products [yes/no]");
	String input3=scanner.nextLine();
	if(input3.toLowerCase().equals("no")) 
	{
       more= false;
       ok=true;
	}
	else
	{
		if(input3.toLowerCase().equals("yes")) 
		{
			ok=true;	
		}
		
	}

	}
	 
	 
	}
	System.out.println();
	System.out.println();
	System.out.println();
	// display the inputs in the console
	System.out.println("Input ");

	
	for(int i=0;i<listproducts.size();i++)
	{
		int produitquantity=listproducts.get(i).getQuantity();
		if(produitquantity>1)
		{
			for (int j=0;j<produitquantity;j++)
			{
				System.out.println(listproducts.get(i).toString(1));
	
			}
		}
		else
		{
		System.out.println(listproducts.get(i).toString(listproducts.get(i).getQuantity()));
		}

	}
	
	
	System.out.println("_________________________");
	
	System.out.println("Output ");
	// Before display the outputs I calculate the sales  Tax
	ItaxCalculator tax= new TaxCalculator();
	List<Product>productaftertax= tax.taxproducts(listproducts);
	double salestax=0.0;
	double total=0.0;
	for(int i=0;i<productaftertax.size();i++)
	{
		
		System.out.println(listproducts.get(i).outputdisplay());
		salestax=productaftertax.get(i).getTax()+salestax;
		total=productaftertax.get(i).getPrice()+total;
		

	}
	DecimalFormat df = new DecimalFormat("##.##");

	System.out.println("Sales Taxes : "+df.format(salestax));
	System.out.println("Total : "+df.format(total));

	
	}

}
