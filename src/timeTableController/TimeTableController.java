package timeTableController;

import java.util.Date;
import java.util.Hashtable;

import timeTableModel.TimeTableDB;

/**
 * Cette classe est le contrôleur d'emplois du temps que vous devez implémenter. 
 * Elle contient un attribut correspondant à la base de données d'emplois du temps que vous allez créer.
 * Elle contient toutes les fonctions de l'interface ITimeTableController que vous devez implémenter.
 * 
 * @author Jose Mennesson (Mettre à jour)
 * @version 04/2016 (Mettre à jour)
 * 
 */

//TODO Classe à modifier

public class TimeTableController implements ITimeTableController {

	/**
	 * Contient une instance de base de données d'emplois du temps
	 * 
	 */
	TimeTableDB tTDB;

	/**
	 * Constructeur de controleur d'emplois du temps créant la base de données d'emplois du temps
	 * 
	 * @param tTfile
	 * 		Fichier XML contenant la base de données d'emplois du temps
	 */
	public TimeTableController(String tTfile) {
		TimeTableDB tTDB = new TimeTableDB(tTfile);
		this.tTDB = tTDB;
	}

	@Override
	public String getTeacherLogin(int timeTableId, int bookId) {
		return tTDB.getTeacherLogin(timeTableId, bookId);
		
	}

	@Override
	public String[] roomsIdToString() {
		return tTDB.roomsIDToString();
		
	}

	@Override
	public String[] roomsToString() {
		return tTDB.roomsToString();
		
	}

	@Override
	public String[] timeTablesIDToString() {
		return tTDB.timeTableIDToString();
		
	}

	@Override
	public String[] booksIdToString(int timeTableId) {
		return tTDB.booksIDToString(timeTableId);
	}

	@Override
	public boolean addRoom(int roomId, int capacity) {
		return tTDB.addRoom(roomId, capacity);
		
	}

	@Override
	public boolean removeRoom(int roomId) {
		return tTDB.removeRoom(roomId);
	}

	@Override
	public int getRoom(int timeTableId, int bookId) {
		return tTDB.getRoom(timeTableId, bookId);
	}

	@Override
	public boolean addTimeTable(int timeTableId) {
		return tTDB.addTimeTable(timeTableId);
	}

	@Override
	public boolean removeTimeTable(int timeTableId) {
		return tTDB.removeTimeTableID(timeTableId);
	}

	@Override
	public boolean addBooking(int timeTableId, int bookingId, String login, Date dateBegin, Date dateEnd, int roomId) {
		return tTDB.addBooking(timeTableId, bookingId, login, dateBegin, dateEnd, roomId);
	}

	@Override
	public void getBookingsDate(int timeTableId, Hashtable<Integer, Date> dateBegin, Hashtable<Integer, Date> dateEnd) {
		tTDB.getBookingsDate(timeTableId, dateBegin, dateEnd);
	}

	@Override
	public boolean removeBook(int timeTableId, int bookId) {
		return tTDB.removeBook(timeTableId,bookId);
	}

	@Override
	public int getBookingsMaxId(int timeTableId) {
		return tTDB.getBookingMaxID(timeTableId);
	}

	@Override
	public boolean saveDB() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean loadDB() {
		// TODO Auto-generated method stub
		return false;
	}

}
