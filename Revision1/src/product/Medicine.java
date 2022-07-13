package product;
import control.*;
import vat.*;

public class Medicine extends Product{
	
	private boolean needsPrescription;
	
	public Medicine() {
		super();
		this.needsPrescription = Import.importNeedsPrescription();
		setTax(Tax.meiomenoVAT);
		
	}
	
	public Medicine(String name, int barCode, double netPrice, boolean needsPrescription) {
		super(name,barCode,netPrice);
		this.needsPrescription = needsPrescription;
		setTax(Tax.meiomenoVAT);
	}

	protected boolean isNeedsPrescription() {
		return needsPrescription;
	}
	
	protected double findFinalPrice() {
		setFinalPrice(getNetPrice()*(1+getTax()));
		return getFinalPrice();
	}
	
	protected String printDetails() {
		String st="";
		if(this.isNeedsPrescription()) {
			st =  "\n* Doctor's prescription required";
		}
		return("Medicine description:\n" + super.printDetails()+ "\n" + st);

	}
}