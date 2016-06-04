/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package timeTableModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * Cette classe gère les emplois du temps des différents groupes.
 * 
 * @author Maxence Debert - Ambroise Denecker
 * @version 06/2016
 */
public class TimeTable {
	/**
	 * Numéro d'identification de l'emploi du temps
	 */
	protected int ID_Timetable = 0;
	
	/**
	 * Couple de numéro d'identification et d'objet réservation 
	 */
	Map<Integer, Booking> BookingList = new HashMap<>();

	/**
	 * Le constructeur créant l'emploi du temps
	 * 
	 *  @param ID_Timetable
	 *  	numéro d'identification de l'emploi du temps
	 */
	public TimeTable(int ID_Timetable) {
		this.ID_Timetable = ID_Timetable;
	}

	
	/**
	 * Retourne le numéro d'identification de la salle
	 * 
	 * @param bookID
	 * 		le numéro d'identification de la réservation
	 * 
	 * @return le numéro d'identification de la salle
	 */
	public int getRoom(int bookID) {
		int id;
		id = BookingList.get(bookID).getRoom();
		return id;
	}
	
	
	/**
	 * Ajoute une réservation
	 * 
	 * @param bookID
	 * 		le numéro d'identification de la réservation
	 * @param login
	 * 		le nom du professeur
	 * @param dateBegin
	 * 		la date de début
	 * @param dateEnd
	 * 		la date de fin
	 * @param roomID
	 * 		le numéro de la salle
	 * 
	 * @return
	 * 		Vrai si ajoutée
	 * 		Faux sinon
	 */
	public boolean addBooking(int bookID, String login, Date dateBegin, Date dateEnd, int roomID) {
		if (BookingList.containsKey(bookID)) {
			return false;
		}
		BookingList.put(bookID, new Booking(bookID, roomID, login, dateBegin, dateEnd));
		if (BookingList.containsKey(bookID)) {
			return true;
		} else {
			return false;
		}
		
	}

	
	/**
	 * Complète la Hashtable contenant les date de début passé en paramètre
	 * 
	 * @param dateBegin
	 * 		Un couple numéro d'identification de la réservation et la date de début
	 */
	public void getDateBegin(Hashtable<Integer, Date> dateBegin) {
		Set<Integer> listKeys = BookingList.keySet();
		Iterator<Integer> iterateur = listKeys.iterator();
		while (iterateur.hasNext()) {
			int key = iterateur.next();
			dateBegin.put(key, BookingList.get(key).getDate_debut());
		}
	}

	
	/**
	 * Complète une Hashtable contenant les date de fin passé en paramètre
	 * 
	 * @param dateEnd
	 * 		Un couple numéro d'identification de la réservation et la date de fin
	 */
	public void getDateEnd(Hashtable<Integer, Date> dateEnd) {
		Set<Integer> listKeys = BookingList.keySet();
		Iterator<Integer> iterateur = listKeys.iterator();
		while (iterateur.hasNext()) {
			int key = iterateur.next();
			dateEnd.put(key, BookingList.get(key).getDate_fin());
		}
	}

	
	/**
	 * Supprime la réservation passée en entrée
	 * 
	 * @param bookID
	 * 		le numéro de la réservation
	 * 
	 * @return
	 * 		Vrai Si réussi
	 * 		Faux Sinon
	 */
	public boolean removeBook(int bookID) {
		if (BookingList.containsKey(bookID)) {
			BookingList.remove(bookID);
			if (BookingList.containsKey(bookID)) {
				return false;
			} 
			else {
				return true;
			}
		} 
		else {
			return false;
		}
	}

	
	/**
	 * Retourne le numéro de la réservation le plus élevé et ajoute 1
	 * 
	 * @return le numéro de la réservation maximum +1
	 */
	public int getBookMaxId() {
		int max = 0;
		Set<Integer> listKeys = BookingList.keySet();
		Iterator<Integer> iterateur = listKeys.iterator();
		while (iterateur.hasNext()) {
			int key = iterateur.next();
			if (key > max) {
				max = key;
			}
		}
		return max + 1;
	}

	
	/**
	 * Retourne un tableau de chaines de caractères contenant tout les numéros de réservation
	 * 
	 * @return un tableau de chaines de caractères contenant tout les numéros de réservation
	 */
	public String[] booksIDString() {
		String retour[] = new String[100];
		int i = 0;
		Set<Integer> listKeys = BookingList.keySet();
		Iterator<Integer> iterateur = listKeys.iterator();
		while (iterateur.hasNext()) {
			int key = iterateur.next();
			retour[i] = String.valueOf(key);
			i = i + 1;
		}
		return retour;

	}

	
	/**
	 * Retourne le nom du professeur
	 * 
	 * @param bookId
	 * 		le numéro de la réservation
	 * 
	 * @return le login du professeur
	 */
	public String getTeachLogin(int bookId) {
		String login;
		login = BookingList.get(bookId).getTeacherLogin();
		return login;
	}
	

	/**
	 * Retourne le date de début en chaine de caractères
	 * 
	 * @param bookId
	 * 		le numéro de la réservation
	 * 
	 * @return la chaine de caractère contenant la date de début
	 */
	public String getDateDebu(int bookId) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return formatter.format(BookingList.get(bookId).getDate_debut());

	}

	
	/**
	 * Retourne le date de fin en chaine de caractères
	 * 
	 * @param bookId
	 * 		le numéro de la réservation
	 * 
	 * @return la chaine de caractère contenant la date de fin
	 */
	public String getDateFi(int bookId) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return formatter.format(BookingList.get(bookId).getDate_fin());
	}

	
	/**
	 * Retounre la liste des réservations 
	 * 
	 * @return la liste des réservations
	 */
	public Map<Integer, Booking> bookingTable() {
		return BookingList;

	}
	
}
