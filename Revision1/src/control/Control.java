/**
 * The control class is contained within the control package. 
 * It contains static (helper) methods that control the data 
 * input to the program for its smooth execution.
 * @project Agent
 * @package control
 * @author Moraitopoulos, Panagiotis
 * @version 2022.06.19
 * @class MIS2022
 */
package control;
import java.util.*;
import javax.swing.*;

public class Control {
	
	/*Create an "in" object for entering data from the keyboard*/
	public static Scanner in = new Scanner(System.in);
	
	/*Checks that the String contains only letters and spaces.*/
	public static String checkName(String name) {
		while(!name.matches("[a-zA-Z]+( +[a-zA-Z]+)*") || name.isBlank()) {
			name = JOptionPane.showInputDialog("Εισάγατε Λάθος Όνομα. Το όνομα πρέπει να περιλαμβάνει μόνο γράμματα.");
		}
		 return name;
	}
	
	public static int checkBarCode(int barCode) {
		while(String.valueOf(barCode).length()>9 ||String.valueOf(barCode).length()<=3) {
			barCode = Integer.parseInt(JOptionPane.showInputDialog("Λάθος BarCode. Το BarCode πρέπει να έχει από 3 έως 8 ψηφία"));
		}
		return barCode;
	}
	
	/*Check that the double is positive and no zero*/
	public static double checkDoubleAboveZero(double ammount) {
		while(ammount<=0) {
			ammount = Integer.parseInt(JOptionPane.showInputDialog("Λάθος Αριθμός. Ο αριθμός πρέπει να είναι δεκαδικός μεγαλύτερος του μηδενός."));
		}
		return ammount;
	}
	
	/*Check that the integer is positive and no zero*/
	public static int checkIntAboveZero (int ammount) {
		while(ammount<=0) {
			System.out.println("Lathos Timi. I timi prepei na einai akeraia megaliteri toy midenos");
			ammount = in.nextInt();
			in.nextLine();
		}
		return ammount;
	}
	/*Check that the integer is positive*/	
	public static int checkIntAboveOrEqualZero (int ammount) {
		while(ammount<0) {
			System.out.println("Orisate lathos timi. i timi prepei na einai dekadiki megaliteri i isi tou midenos");
			ammount = in.nextInt();
			in.nextLine();
		}
		return ammount;
	}
	/*Check that the integer is 1 or 0*/
	public static int checkDigitalInt(int ammount) {
		while(ammount!=1 || ammount!=0) {
			System.out.println("Lathos Timi. I timi prepei na einai akeraia megaliteri i isi toy midenos.");
			ammount = in.nextInt();
			in.nextLine();
		}
		return ammount;
	}
	/*Check for double to be between or equal to 0 and 1*/
	public static double checkDoubleBelowOrEqualOne(double ammount) {
		while(ammount>=1 || ammount <0) {
			ammount = Double.parseDouble(JOptionPane.showInputDialog(null,"Λάθος Τιμή. Η τιμή πρέπει να ειναι μεταξύ 1 και 0."));
		}
		return ammount;
	}
}
