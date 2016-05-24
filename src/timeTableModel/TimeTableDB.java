package timeTableModel;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import main.java.timeTableModel.HashSet;
import main.java.timeTableModel.Room;
import main.java.timeTableModel.TimeTable;




/**
 * 
 * Cette classe gére la base de données d'emplois du temps. Elle doit permettre de sauvegarder et charger les emplois du temps ainsi que les salles à partir d'un fichier XML. 
 * La structure du fichier XML devra être la même que celle du fichier TimeTableDB.xml.
 * @see <a href="../../TimeTableDB.xml">TimeTableDB.xml</a> 
 * 
 * @author Jose Mennesson (Mettre à jour)
 * @version 04/2016 (Mettre à jour)
 * 
 */

//TODO Classe à modifier

public class TimeTableDB {
	/**
	 * 
	 * Le fichier contenant la base de données.
	 * 
	 */
	private String file;
	
	Map<Integer, TimeTable> TimeTableList = new HashMap<>();
	Map<Integer, Booking> BookingList = new HashMap<>();
	Map<Integer, Room> RoomList = new HashMap<>();

	
//	    public static void main(final String[] args) {
//	        /*
//	         * Etape 1 : r�cup�ration d'une instance de la classe "DocumentBuilderFactory"
//	         */
//	        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//	            	
//	        try {
//	            /*
//	             * Etape 2 : cr�ation d'un parseur
//	             */
//	            final DocumentBuilder builder = factory.newDocumentBuilder();
//				
//		    /*
//		     * Etape 3 : cr�ation d'un Document
//		     */
//		    final Document document= builder.parse(new File("repertoire.xml"));
//				
//		    //Affiche du prologue
//		    System.out.println("*************PROLOGUE************");
//		    System.out.println("version : " + document.getXmlVersion());
//		    System.out.println("encodage : " + document.getXmlEncoding());		
//	            System.out.println("standalone : " + document.getXmlStandalone());
//						
//		    /*
//		     * Etape 4 : r�cup�ration de l'Element racine
//		     */
//		    final Element racine = document.getDocumentElement();
//			
//		    //Affichage de l'�l�ment racine
//		    System.out.println("\n*************RACINE************");
//		    System.out.println(racine.getNodeName());
//			
//		    /*
//		     * Etape 5 : r�cup�ration des personnes
//		     */
//		    final NodeList racineNoeuds = racine.getChildNodes();
//		    final int nbRacineNoeuds = racineNoeuds.getLength();
//				
//		    for (int i = 0; i<nbRacineNoeuds; i++) {
//		        if(racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
//		            final Element personne = (Element) racineNoeuds.item(i);
//					
//			    //Affichage d'une personne
//			    System.out.println("\n*************PERSONNE************");
//			    System.out.println("sexe : " + personne.getAttribute("sexe"));
//				
//		    	    /*
//			     * Etape 6 : r�cup�ration du nom et du pr�nom
//			     */
//			    final Element nom = (Element) personne.getElementsByTagName("nom").item(0);
//			    final Element prenom = (Element) personne.getElementsByTagName("prenom").item(0);
//						
//			    //Affichage du nom et du pr�nom
//			    System.out.println("nom : " + nom.getTextContent());
//			    System.out.println("pr�nom : " + prenom.getTextContent());
//						
//			    /*
//			     * Etape 7 : r�cup�ration des num�ros de t�l�phone
//			     */
//			    final NodeList telephones = personne.getElementsByTagName("telephone");
//			    final int nbTelephonesElements = telephones.getLength();
//						
//			    for(int j = 0; j<nbTelephonesElements; j++) {
//			        final Element telephone = (Element) telephones.item(j);
//			    
//	                        //Affichage du t�l�phone
//	                        System.out.println(telephone.getAttribute("type") + " : " + telephone.getTextContent());
//			    }
//		        }				
//		    }			
//	        }
//	        catch (final ParserConfigurationException e) {
//	            e.printStackTrace();
//	        }
//	        catch (final SAXException e) {
//	            e.printStackTrace();
//	        }
//	        catch (final IOException e) {
//	            e.printStackTrace();
//	        }		
//	    }
//	}

	/**
	 * 
	 */


	/**
	 * 
	 * Constructeur de TimeTableDB. 
	 * 
	 * @param file
	 * 		Le nom du fichier qui contient la base de données.
	 */
	public TimeTableDB(String file) {
		//TODO	À modifier
		super();
		this.setFile(file);
	}

	/**
	 * Getter de file
	 * 
	 * @return 
	 * 		Le nom du fichier qui contient la base de données.
	 */
	public String getFile() {
		return file;
	}

	/**
	 * Setter de file
	 * 
	 * @param file
	 * 		Le nom du fichier qui contient la base de données.
	 */
	public void setFile(String file) {
		this.file = file;
	}
}

///////////////////////////////////////////////////////////////////////////////////////////////////////

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
	//Room nom_room = new Room(roomID, capacity); 
	RoomList.put(roomID, new Room(roomID, capacity) );
}

/**
 * Description of the method removeRoom.
 * @param roomID 
 */
public void removeRoom(int roomID) {
	RoomList.remove(roomID);
}

/**
 * Description of the method getRoom.
 * @param timeTableID 
 * @param bookID 
 */
public Room getRoom(int timeTableID, int bookID) {
	int roomID = TimeTableList.get(timeTableID).getRoom(bookID);
	return RoomList.get(roomID);
}

/**
 * Description of the method addTimeTable.
 * @param TimeTableID 
 */
public void addTimeTable(int TimeTableID) {
	TimeTableList.put(TimeTableID, new TimeTable(TimeTableID));
}

/**
 * Description of the method removeTimeTableID.
 * @param timeTableID 
 */
public void removeTimeTableID(int timeTableID) {
	TimeTableList.remove(timeTableID);
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
	//BookingList.put(bookID, TimeTableList.get(tableTimeID).addBooking(bookID, login, dateBegin, dateEnd, roomID));
	TimeTableList.get(tableTimeID).addBooking(bookID, login, dateBegin, dateEnd, roomID);
}


/**
 * Description of the method getBookingsDate.
 * @param timeTableID 
 * @param dateBegin 
 * @param dateEnd 
 */
public void getBookingsDate(int timeTableID,  Hashtable<Integer, Date> dateBegin,  Hashtable<Integer, Date>  dateEnd) {
	// Start of user code for method getBookingsDate
	// End of user code
	TimeTableList.get(timeTableID).getDateBegin(dateBegin);
	TimeTableList.get(timeTableID).getDateEnd(dateEnd);
}

/**
 * Description of the method removeBook.
 * @param timeTableID 
 * @param bookID 
 */
public void removeBook(int timeTableID, int bookID) {
	// Start of user code for method removeBook
	// End of user code
	TimeTableList.get(timeTableID).removeBook(bookID);
}

/**
 * Description of the method roomsToString.
 */
public String[] roomsToString() {
	String retour[]; int i=0;
	Set listKeys=RoomList.keySet();
	Iterator iterateur = listKeys.iterator();
	while(iterateur.hasNext())
	{
		Object key= iterateur.next();
		retour[i]=RoomList.get(key).infoToString();
		i=i+1;
	}
	return retour;
}

/**
 * Description of the method getBookingMaxID.
 * @param timeTableID 
 */
public int getBookingMaxID(int timeTableID) {
	int max;
	max = TimeTableList.get(timeTableID).getBookMaxId();
	return max;
	
}

/**
 * Description of the method booksIDToString.
 * @param timeTableID 
 */
public String[] booksIDToString(int timeTableID) {
	String retour[];
	retour=TimeTableList.get(timeTableID).booksIDString();
	return retour;
	
}

/**
 * Description of the method roomsIDToString.
 */
public String[] roomsIDToString() {
	String retour[]; int i=0;
	Set listKeys=RoomList.keySet();
	Iterator iterateur = listKeys.iterator();
	while(iterateur.hasNext())
	{
		Object key= iterateur.next(); // passe direct au suivant non ?
		retour[i]=String.valueOf(key);
		i=i+1;
	}
	return retour;
}

/**
 * Description of the method getTeacherLogin.
 * @param timeTableID 
 * @param bookID 
 */
public String getTeacherLogin(int timeTableID, int bookID) {
	String login = TimeTableList.get(timeTableID).getTeachLogin(bookID);
	return login;
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

