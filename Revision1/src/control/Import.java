package control;
import java.util.*;
import javax.swing.*;

import product.Product;

public class Import {
	
	public static String importName() {
		String name = JOptionPane.showInputDialog("Εισάγετε το όνομα του είδους.","Όνομα Είδος");
		name = Control.checkName(name);
		return name;
	}
	
	public static int importBarCode() {
		int barCode = Integer.parseInt(JOptionPane.showInputDialog("Εισάγετε το BarCode του είδους","99999999"));
		barCode = Control.checkBarCode(barCode);
		return barCode;
	}
	
	public static double importNetPrice() {
		double netPrice = Double.parseDouble(JOptionPane.showInputDialog("Εισάγετε τιμή Είδους","99.99"));
		netPrice = Control.checkDoubleAboveZero(netPrice);
		return netPrice;
	}
	
	public static boolean importNeedsPrescription() {
		boolean needsPrescription = false;
		int answer = JOptionPane.showConfirmDialog(null,"Χρειάζεται το είδος συνταγή από γιατρό");
		switch (answer) {
			case 0: needsPrescription = true;
					break;
			case 1: break;
			case 2: break;
		}
		return needsPrescription;
	}
	
	public static String importBrand() {
		String brand = JOptionPane.showInputDialog("Εισάγετε τη μάρκα του καλλυντικού.","Μάρκα Καλλυντικού");
		brand = Control.checkName(brand);
		return brand;
	}
	
	public static int productChoose(String yes_choice, String no_choice, String cancel_choice, String message, String title) {
		Object[] options = {yes_choice,no_choice,cancel_choice};
		int i = JOptionPane.showOptionDialog(null,message,
			title,
			JOptionPane.YES_NO_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,
			options,
			options[0]);
		return i ;
	}
	
	public static int taskChoose() {
		Object[] options = {"Δημιοργία Είδος","Εκτύπωση Στοιχείων Εϊδους","Αναζήτηση Είδους","Προσθήκη Έκπτωσης"};
		int i = JOptionPane.showOptionDialog(null,"Επιλέξτε την εργασία που θέλετε να κάνετε ή \nκλείστε το παράθυρο διαλόγου για να τερματίσετε το πρόγραμμα.",
			"Οδηγός Εργασιών",
			JOptionPane.YES_NO_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,
			options,
			options[0]);
		return i ;
	}

}
