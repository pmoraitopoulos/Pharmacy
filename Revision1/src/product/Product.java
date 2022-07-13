package product;
import control.Control;
import control.Import;

public abstract class Product {
	
	private String name;
	private int barCode;
	private double netPrice;
	private double tax;
	private double finalPrice;
	
	protected Product() {
		name = Import.importName();
		barCode = Import.importBarCode();
		netPrice = Import.importNetPrice();
	}
	protected Product(String name, int barCode, double netPrice) {
		this.name = Control.checkName(name);
		this.barCode = Control.checkBarCode(barCode);
		this.netPrice = Control.checkDoubleAboveZero(netPrice);
		
	}
	protected String getName() {
		return name;
	}

	protected int getBarCode() {
		return barCode;
	}

	protected double getNetPrice() {
		return netPrice;
	}

	protected void setNetPrice(double netPrice) {
		this.netPrice = Control.checkDoubleAboveZero(netPrice);
	}
	
	protected abstract double findFinalPrice();
	
	protected void setTax(double tax) {
		this.tax = tax;
	}
	
	protected void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}
	protected double getTax() {
		return tax;
	}
	protected double getFinalPrice() {
		return finalPrice;
	}
	
	protected String printDetails() {
		return(name+", <"+barCode+">, "+this.findFinalPrice() + " Euro");
	}
	
}
