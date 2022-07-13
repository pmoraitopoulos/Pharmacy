package product;
import java.util.*;
import javax.swing.JOptionPane;

import control.Import;

public class ProductDB {
	
	private ArrayList<Product> products;
	
	public ProductDB() {
		products = new ArrayList<>();
	}
	
	public void storeProduct(Product aProduct) {
		products.add(aProduct);
	}
	
	public void printProducts() {
		int i=1;
		for(Product product : products) {
			JOptionPane.showMessageDialog(null, i+"/"+products.size()+"\n"+product.printDetails(),"Λίστα Ειδών",JOptionPane.INFORMATION_MESSAGE);
			i++;
		}
	}
	
	public void searchProduct() {
		String searchName = JOptionPane.showInputDialog(null,"Δώστε όνομα για να κάνετε αναζήτηση");
		boolean found = false;
		JOptionPane.showMessageDialog(null,"Anazitisi gia Ergazomeno: " + searchName);
		for(Product product : products) {
			if (product.getName().equals(searchName)) {
				JOptionPane.showMessageDialog(null,"Βρέθηκε Εγγραφή\n"+ product.printDetails());
				found = true;
				break;
			}
		}
		if(!found)
			JOptionPane.showMessageDialog(null,"The pharmacy does not have any product called "+searchName);
	}
	
	public void priceReduction () {
		String brand = Import.importBrand();
		double percentage = Double.parseDouble(JOptionPane.showInputDialog("Εισάγετε ποσοστό έκπτωσης."));
		
		int count = 0;
		 for(Product p: products)
	        {
	            if ( p instanceof Cosmetic )
	            {
	            	Cosmetic aCosmetic = (Cosmetic)p;
	                if ( aCosmetic.getBrand().equals(brand) )
	                {                    
	                    double newPrice = p.getNetPrice()*(1- percentage);
	                    p.setNetPrice(newPrice);
	                    count++;
	                }                
	            }
	        }
	       JOptionPane.showMessageDialog(null,"********** Look for " + count + " cosmetics by " + brand + " with reduced prices!!**********\n");
	    }
	}