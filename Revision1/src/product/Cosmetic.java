package product;
import control.*;
import vat.*;

public class Cosmetic extends Product{

	private String brand;
	
	public Cosmetic() {
		super();
		brand = Import.importBrand();
		setTax(Tax.kanonikoVAT);
	}
	
	public Cosmetic(String name , int barCode, double netPrice, String brand) {
		super(name, barCode, netPrice);
		this.brand = Control.checkName(brand);
		setTax(Tax.kanonikoVAT);
	}
	
	public double findFinalPrice() {
		setFinalPrice(getNetPrice()*(1+getTax()));
		return getFinalPrice();
	}
	
	public String getBrand() {
		return brand;
	}
	
	public String printDetails() {
		return("Cosmetic description:\n" + "Your favorite "+ this.getBrand() + " cosmetic!\n" + super.printDetails());
	}
	
}
