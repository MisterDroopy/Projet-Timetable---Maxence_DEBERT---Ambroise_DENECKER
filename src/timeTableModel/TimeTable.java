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
	 * Description of the property groupId.
	 */

	protected int ID_Timetable = 0;
	Map<Integer, Booking> BookingList = new HashMap<>();

	/**
	 * The constructor.
	 */
	public TimeTable(int ID_Timetable) {
		this.ID_Timetable = ID_Timetable;
	}

	public int getRoom(int bookID) {
		int id;
		id = BookingList.get(bookID).getRoom();
		return id;
	}

	public boolean addBooking(int bookID, String login, Date dateBegin, Date dateEnd, int roomID) {
		BookingList.put(bookID, new Booking(bookID, roomID, login, dateBegin, dateEnd));
		return true;
		
	}

	public void getDateBegin(Hashtable<Integer, Date> dateBegin) {
		Set<Integer> listKeys = BookingList.keySet();
		Iterator<Integer> iterateur = listKeys.iterator();
		while (iterateur.hasNext()) {
			int key = iterateur.next();
			dateBegin.put(key, BookingList.get(key).getDate_debut());
		}
	}

	public void getDateEnd(Hashtable<Integer, Date> dateEnd) {
		Set<Integer> listKeys = BookingList.keySet();
		Iterator<Integer> iterateur = listKeys.iterator();
		while (iterateur.hasNext()) {
			int key = iterateur.next();
			dateEnd.put(key, BookingList.get(key).getDate_fin());
		}
	}

	public boolean removeBook(int bookID) {
		if (BookingList.containsKey(bookID)) {

			BookingList.remove(bookID);
			if (BookingList.containsKey(bookID)) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

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

	public String getTeachLogin(int bookId) {
		String login;
		login = BookingList.get(bookId).getTeacherLogin();

		return login;
	}

	public String getDateDebu(int bookId) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return formatter.format(BookingList.get(bookId).getDate_debut());

	}

	public String getDateFi(int bookId) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return formatter.format(BookingList.get(bookId).getDate_fin());
	}

	public Map<Integer, Booking> bookingTable() {
		return BookingList;

	}
	
}
