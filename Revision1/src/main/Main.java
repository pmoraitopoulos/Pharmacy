package main;
import javax.swing.*;
import product.*;
import control.*;

public class Main {

	public static void main(String[] args) {
	    if(JOptionPane.showConfirmDialog(null, "Να γίνει η εκτέλεση του προγράμματος;") == 0) {
	    	
	    	switch(JOptionPane.showConfirmDialog(null, "Να δημιουργηθεί βάση δεδομένων; \n Είναι απαραίτητο για τη συνέχεια του προγράμματος.")) {
	    		case 0 : {
	    			ProductDB ProductsDB = new ProductDB();
	    			String isDefaultProducts = "";
	    			if(JOptionPane.showConfirmDialog(null, "Θέλετε να περαστούν τα πρότυπα προϊόντα στη βάση;")==0) {
	    				Medicine med1 = new Medicine("DEPON",1234567,1.5975, false);
	    				Medicine med2 = new Medicine("Tetravac",7654321,22.365,true);
	    				Cosmetic cos1 = new Cosmetic("Body Lotion Roses", 568923, 24.6,"KORRES");
	    				Cosmetic cos2 = new Cosmetic("Shower Gel Afrika", 24680, 15.375, "Apivita");
	    				
	    				ProductsDB.storeProduct(med1);
	    				ProductsDB.storeProduct(med2);
	    				ProductsDB.storeProduct(cos1);
	    				ProductsDB.storeProduct(cos2);
	    				isDefaultProducts = "Έχουν δημιουργηθεί τα πρότυπα είδη.";
	    				JOptionPane.showMessageDialog(null, isDefaultProducts, "Εντάξει",JOptionPane.INFORMATION_MESSAGE);
	    			}
	    			int task = Import.taskChoose();
	    			while(task!= -1) {
	    				switch(task) {
	    				case 0: 
	    					do{
	    					
	    						switch(Import.productChoose("Medicine", "Cosmetic", "Ακύρωση", "Τι είδος θέλετε να δημιουργήσετε;","Δημιουργία είδους")) {
	    							case 0:
	    								ProductsDB.storeProduct(new Medicine());
	    								break;
	    							case 1:
	    								ProductsDB.storeProduct(new Cosmetic());
	    								break;
	    							case 2: JOptionPane.showMessageDialog(null, "Ακυρώθηκε η διαδικασία δημιουργίας του είδους.", "Έξοδος",JOptionPane.INFORMATION_MESSAGE);
	    								break;
	    						}
	    					} while(JOptionPane.showConfirmDialog(null, "Να δημιουργηθεί νέο προϊόν;"+"\n"+isDefaultProducts)==0);
	    					break;
	    				case 1: ProductsDB.printProducts();
	    						break;
	    						
	    				case 2: do{
	    						ProductsDB.searchProduct();
	    					}while(JOptionPane.showConfirmDialog(null, "Να γίνει αναζήτηση νέου είδους;")==0);
	    						break;
	    				case 3: ProductsDB.priceReduction();
	    						break;
	    					
	    				}
			    		task = Import.taskChoose(); 
			    			
			    		}
	    			break;
	    			}
	    		default: JOptionPane.showMessageDialog(null, "Ακυρώθηκε η εκτέλεση του προγράμματος.\n Αποτυχία δημιουργίας βάσης δεδομένων.", "Έξοδος",JOptionPane.INFORMATION_MESSAGE);
	    				break;
	    		}
	    	}
	    else {
	    	JOptionPane.showMessageDialog(null, "Ακυρώθηκε η εκτέλεση του προγράμματος από το χρήστη.", "Έξοδος",JOptionPane.INFORMATION_MESSAGE);
	    }
	}
}
