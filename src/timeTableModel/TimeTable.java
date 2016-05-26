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
	
	public boolean addBooking(int bookID, String login, Date dateBegin, Date dateEnd, int roomID){
		
		if(BookingList.containsKey(bookID)){
			
			return false;
		}
		BookingList.put(bookID, new Booking(bookID,roomID,login, dateBegin, dateEnd));
		if(BookingList.containsKey(bookID)){
			
			return true;
		}
		else {
			return false;
		}
		
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
	
	public void getDateEnd(Hashtable<Integer, Date> dateEnd){
		Set<Integer> listKeys=BookingList.keySet();
		Iterator<Integer> iterateur= listKeys.iterator();
		while(iterateur.hasNext())
		{
			int key= iterateur.next();
			dateEnd.put(key, BookingList.get(key).getDate_fin());		
		}
	}
	
	public boolean removeBook(int bookID){
		if(BookingList.containsKey(bookID)){
			
			BookingList.remove(bookID);	
			if(BookingList.containsKey(bookID)){
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
	
	public int getBookMaxId(){
		int max=0;
		
		Set<Integer> listKeys=BookingList.keySet();
		Iterator<Integer> iterateur= listKeys.iterator();
		while(iterateur.hasNext())
		{
			int key= iterateur.next();
			if(key>max){
				max=key;
			}		
		}
		
		return max;
	}
	
	public String[] booksIDString(){
		String retour[]=new String[100]; int i=0;
		Set<Integer> listKeys=BookingList.keySet();
		Iterator<Integer> iterateur = listKeys.iterator();
		while(iterateur.hasNext())
		{
			int key= iterateur.next(); // passe direct au suivant non ?
			retour[i]=String.valueOf(key);
			i=i+1;
		}
		return retour;
		
	}
	
	public String getTeachLogin(int bookId){
		String login;
		login= BookingList.get(bookId).getTeacherLogin();
		
		return login;
	}
	
	
/*	public void getTeacherID (int BookID){
		((Booking)BookID).getTeacherLogin();
	}*/
	
	

}
