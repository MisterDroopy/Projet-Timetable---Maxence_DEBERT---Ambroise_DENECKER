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
 * Cette classe g�re les emplois du temps des diff�rents groupes.
 * 
 * @author Maxence Debert - Ambroise Denecker
 * @version 06/2016
 */
public class TimeTable {
	/**
	 * Num�ro d'identification de l'emploi du temps
	 */
	protected int ID_Timetable = 0;
	
	/**
	 * Couple de num�ro d'identification et d'objet r�servation 
	 */
	Map<Integer, Booking> BookingList = new HashMap<>();

	/**
	 * Le constructeur cr�ant l'emploi du temps
	 * 
	 *  @param ID_Timetable
	 *  	num�ro d'identification de l'emploi du temps
	 */
	public TimeTable(int ID_Timetable) {
		this.ID_Timetable = ID_Timetable;
	}

	
	/**
	 * Retourne le num�ro d'identification de la salle
	 * 
	 * @param bookID
	 * 		le num�ro d'identification de la r�servation
	 * 
	 * @return le num�ro d'identification de la salle
	 */
	public int getRoom(int bookID) {
		int id;
		id = BookingList.get(bookID).getRoom();
		return id;
	}
	
	
	/**
	 * Ajoute une r�servation
	 * 
	 * @param bookID
	 * 		le num�ro d'identification de la r�servation
	 * @param login
	 * 		le nom du professeur
	 * @param dateBegin
	 * 		la date de d�but
	 * @param dateEnd
	 * 		la date de fin
	 * @param roomID
	 * 		le num�ro de la salle
	 * 
	 * @return
	 * 		Vrai si ajout�e
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
	 * Compl�te la Hashtable contenant les date de d�but pass� en param�tre
	 * 
	 * @param dateBegin
	 * 		Un couple num�ro d'identification de la r�servation et la date de d�but
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
	 * Compl�te une Hashtable contenant les date de fin pass� en param�tre
	 * 
	 * @param dateEnd
	 * 		Un couple num�ro d'identification de la r�servation et la date de fin
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
	 * Supprime la r�servation pass�e en entr�e
	 * 
	 * @param bookID
	 * 		le num�ro de la r�servation
	 * 
	 * @return
	 * 		Vrai Si r�ussi
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
	 * Retourne le num�ro de la r�servation le plus �lev� et ajoute 1
	 * 
	 * @return le num�ro de la r�servation maximum +1
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
	 * Retourne un tableau de chaines de caract�res contenant tout les num�ros de r�servation
	 * 
	 * @return un tableau de chaines de caract�res contenant tout les num�ros de r�servation
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
	 * 		le num�ro de la r�servation
	 * 
	 * @return le login du professeur
	 */
	public String getTeachLogin(int bookId) {
		String login;
		login = BookingList.get(bookId).getTeacherLogin();
		return login;
	}
	

	/**
	 * Retourne le date de d�but en chaine de caract�res
	 * 
	 * @param bookId
	 * 		le num�ro de la r�servation
	 * 
	 * @return la chaine de caract�re contenant la date de d�but
	 */
	public String getDateDebu(int bookId) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return formatter.format(BookingList.get(bookId).getDate_debut());

	}

	
	/**
	 * Retourne le date de fin en chaine de caract�res
	 * 
	 * @param bookId
	 * 		le num�ro de la r�servation
	 * 
	 * @return la chaine de caract�re contenant la date de fin
	 */
	public String getDateFi(int bookId) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return formatter.format(BookingList.get(bookId).getDate_fin());
	}

	
	/**
	 * Retounre la liste des r�servations 
	 * 
	 * @return la liste des r�servations
	 */
	public Map<Integer, Booking> bookingTable() {
		return BookingList;

	}
	
}
