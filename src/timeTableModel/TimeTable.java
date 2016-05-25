/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package timeTableModel;

import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of TimeTable.
 * 
 * @author ambroise
 */
public class TimeTable {
	/**
	 * Description of the property groupId.
	 */
	
	protected int ID_Timetable =0;
	Map<Integer, Booking> BookingList = new HashMap<>();

	/**
	 * The constructor.
	 */
	public TimeTable(int ID_Timetable) {
		this.ID_Timetable = ID_Timetable;
	}


	public int getRoom(int bookID){
	int id;
	id=BookingList.get(bookID).getRoom();
	return id;	
	}
	
	public void addBooking(int bookID, String login, Date dateBegin, Date dateEnd, int roomID){
		BookingList.put(bookID, new Booking(bookID,roomID,login, dateBegin, dateEnd));
	}
	
	public void getDateBegin(Hashtable<Integer, Date> dateBegin){
		Set<Integer> listKeys=BookingList.keySet();
		Iterator<Integer> iterateur= listKeys.iterator();
		while(iterateur.hasNext())
		{
			int key= iterateur.next();
			dateBegin.put(key, BookingList.get(key).getDate_debut());		
		}
	}
/*	public void getTeacherID (int BookID){
		((Booking)BookID).getTeacherLogin();
	}*/
	
	

}
