/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package timeTableModel;

import java.util.Date;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of TimeTableDB.
 * 
 * @author ambroise
 */
public class TimeTableDB {
	/**
	 * Description of the property file.
	 */
	private Object file = ;

	/**
	 * Description of the property rooms.
	 */
	public HashSet<Room> rooms = new HashSet<Room>();

	/**
	 * Description of the property timeTables.
	 */
	public HashSet<TimeTable> timeTables = new HashSet<TimeTable>();
	
	protected TimeTable 

	// Start of user code (user defined attributes for TimeTableDB)

	// End of user code

	/**
	 * The constructor.
	 */
	public TimeTableDB() {
		// Start of user code constructor for TimeTableDB)
		super();
		// End of user code
	}

	/**
	 * Description of the method saveDB.
	 */
	public void saveDB() {
		// Start of user code for method saveDB
		// End of user code
	}

	/**
	 * Description of the method loadDB.
	 */
	public void loadDB() {
		// Start of user code for method loadDB
		// End of user code
	}

	/**
	 * Description of the method timeTableIDToString.
	 */
	public void timeTableIDToString() {
		// Start of user code for method timeTableIDToString
		// End of user code
	}

	/**
	 * Description of the method addRoom.
	 * @param roomID 
	 * @param capacity 
	 */
	public void addRoom(int roomID, int capacity) {
		// Start of user code for method addRoom
		// End of user code
	}

	/**
	 * Description of the method removeRoom.
	 * @param roomID 
	 */
	public void removeRoom(int roomID) {
		// Start of user code for method removeRoom
		// End of user code
	}

	/**
	 * Description of the method getRoom.
	 * @param timeTableID 
	 * @param bookID 
	 */
	public void getRoom(int timeTableID, int bookID) {
		// Start of user code for method getRoom
		// End of user code
	}

	/**
	 * Description of the method addTimeTable.
	 * @param TimeTableID 
	 */
	public void addTimeTable(int TimeTableID) {
		// Start of user code for method addTimeTable
		// End of user code
	}

	/**
	 * Description of the method removeTimeTableID.
	 * @param timeTableID 
	 */
	public void removeTimeTableID(int timeTableID) {
		// Start of user code for method removeTimeTableID
		// End of user code
	}

	/**
	 * Description of the method addBooking.
	 * @param tableTimeID 
	 * @param bookID 
	 * @param login 
	 * @param dateBegin 
	 * @param dateEnd 
	 * @param roomID 
	 */
	public void addBooking(int tableTimeID, int bookID, String login, Date dateBegin, Date dateEnd, int roomID) {
		
		tableTimeID.addBooking(bookID, login, dateBegin, dateEnd, roomID )
	}

	/**
	 * Description of the method getBookingsDate.
	 * @param timeTableID 
	 * @param dateBegin 
	 * @param dateEnd 
	 */
	public void getBookingsDate(int timeTableID, Date dateBegin, Date dateEnd) {
		// Start of user code for method getBookingsDate
		// End of user code
	}

	/**
	 * Description of the method removeBook.
	 * @param timeTableID 
	 * @param bookID 
	 */
	public void removeBook(int timeTableID, int bookID) {
		// Start of user code for method removeBook
		// End of user code
	}

	/**
	 * Description of the method roomsToString.
	 */
	public void roomsToString() {
		// Start of user code for method roomsToString
		// End of user code
	}

	/**
	 * Description of the method getBookingMaxID.
	 * @param timeTableID 
	 */
	public void getBookingMaxID(int timeTableID) {
		// Start of user code for method getBookingMaxID
		// End of user code
	}

	/**
	 * Description of the method booksIDToString.
	 * @param timeTableID 
	 */
	public void booksIDToString(int timeTableID) {
		// Start of user code for method booksIDToString
		// End of user code
	}

	/**
	 * Description of the method roomsIDToString.
	 */
	public void roomsIDToString() {
		// Start of user code for method roomsIDToString
		// End of user code
	}

	/**
	 * Description of the method getTeacherLogin.
	 * @param timeTableID 
	 * @param bookID 
	 */
	public void getTeacherLogin(int timeTableID, int bookID) {
		// Start of user code for method getTeacherLogin
		// End of user code
	}

	// Start of user code (user defined methods for TimeTableDB)

	// End of user code
	/**
	 * Returns file.
	 * @return file 
	 */
	public Object getFile() {
		return this.file;
	}

	/**
	 * Sets a value to attribute file. 
	 * @param newFile 
	 */
	public void setFile(Object newFile) {
		this.file = newFile;
	}

	/**
	 * Returns rooms.
	 * @return rooms 
	 */
	public HashSet<Room> getRooms() {
		return this.rooms;
	}

	/**
	 * Returns timeTables.
	 * @return timeTables 
	 */
	public HashSet<TimeTable> getTimeTables() {
		return this.timeTables;
	}

}
