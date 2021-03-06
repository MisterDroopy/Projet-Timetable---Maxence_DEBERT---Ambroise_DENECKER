package timeTableModel;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import timeTableController.TimeTableController;

/**
 * Cette classe permet de tester les fonctions du contrôleur d'emplois du temps.
 * Elle crée une base de données de 3 salles et de 4 réservations d'emplois du temps et les sauvegarde dans le fichier "timeTableDB.xml". 
 * 
 * @author Jose Mennesson
 * @version 04/2016 
 * 
 */

//TODO Classe pouvant être modifiée suivant vos besoins

public class Main {
	/**
	 * Fonction principale 
	 * 
	 * @param args
	 * 			Les arguments donnés en entrée du programme.
	 * 
	 */
	public static void main(String[] args) {

		final String file = "timeTableDB.xml";
		
		TimeTableController UC = new TimeTableController(file);
		UC.loadDB();
		UC.addRoom(1, 50);
		UC.addRoom(2, 100);
		UC.addRoom(3, 150);

		Calendar dbeg1 = new GregorianCalendar(2016, 3, 6, 8, 00);
		Calendar dend1 = new GregorianCalendar(2016, 3, 6, 10, 00);
		Date dated1 = dbeg1.getTime();
		Date datee1 = dend1.getTime();

		Calendar dbeg2 = new GregorianCalendar(2016, 3, 6, 13, 00);
		Calendar dend2 = new GregorianCalendar(2016, 3, 6, 17, 00);
	Date dated2 = dbeg2.getTime();
		Date datee2 = dend2.getTime();
//
Calendar dbeg3 = new GregorianCalendar(2016, 3, 7, 8, 15);
Calendar dend3 = new GregorianCalendar(2016, 3, 7, 11, 45);
Date dated3 = dbeg3.getTime();
Date datee3 = dend3.getTime();
//
Calendar dbeg4 = new GregorianCalendar(2016, 3, 8, 16, 00);
Calendar dend4 = new GregorianCalendar(2016, 3, 8, 18, 00);
Date dated4 = dbeg4.getTime();
Date datee4 = dend4.getTime();

		UC.addTimeTable(1);
		UC.addBooking(1, 0, "GS", dated1, datee1, 1);
		UC.addBooking(1, 1, "MF", dated2, datee2, 1);
		UC.addBooking(1, 2, "GS", dated3, datee3, 2);
		UC.addBooking(1, 3, "MF", dated4, datee4, 3);
		UC.saveDB();
		
		
		TimeTableDB NotreDB = new TimeTableDB("ok");
		
		NotreDB.addTimeTable(1); //test addTimeTable
		
		NotreDB.addRoom(1, 10);
		NotreDB.addBooking(1, 2, "ambroise", dated4, datee4, 1);
		String books[] = new String[100];
		books=NotreDB.booksIDToString(1);
		int i;
		for(i=0; i<100;i++){
			System.out.println(books[i]);
			
		}
		System.out.println("------------------");
		
		NotreDB.addBooking(1, 2, "casimir", dated2, datee2, 1);
		System.out.println(NotreDB.getTeacherLogin(1, 2));
		books=NotreDB.booksIDToString(1);
		for(i=0; i<100;i++){
			System.out.println(books[i]);
			
		}
		
		
		
		
		
	}
}
