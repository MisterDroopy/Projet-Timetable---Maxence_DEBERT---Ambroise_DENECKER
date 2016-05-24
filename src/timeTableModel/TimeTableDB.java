package timeTableModel;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
 * Cette classe gÃ©re la base de donnÃ©es d'emplois du temps. Elle doit permettre de sauvegarder et charger les emplois du temps ainsi que les salles Ã  partir d'un fichier XML. 
 * La structure du fichier XML devra Ãªtre la mÃªme que celle du fichier TimeTableDB.xml.
 * @see <a href="../../TimeTableDB.xml">TimeTableDB.xml</a> 
 * 
 * @author Jose Mennesson (Mettre Ã  jour)
 * @version 04/2016 (Mettre Ã  jour)
 * 
 */

//TODO Classe Ã  modifier

public class TimeTableDB {
	/**
	 * 
	 * Le fichier contenant la base de donnÃ©es.
	 * 
	 */
	private String file;
	
	Map<Integer, TimeTable> TimeTableList = new HashMap<>();
	Map<Integer, Booking> BookingList = new HashMap<>();
	Map<Integer, Room> RoomList = new HashMap<>();

	
//	    public static void main(final String[] args) {
//	        /*
//	         * Etape 1 : récupération d'une instance de la classe "DocumentBuilderFactory"
//	         */
//	        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//	            	
//	        try {
//	            /*
//	             * Etape 2 : création d'un parseur
//	             */
//	            final DocumentBuilder builder = factory.newDocumentBuilder();
//				
//		    /*
//		     * Etape 3 : création d'un Document
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
//		     * Etape 4 : récupération de l'Element racine
//		     */
//		    final Element racine = document.getDocumentElement();
//			
//		    //Affichage de l'élément racine
//		    System.out.println("\n*************RACINE************");
//		    System.out.println(racine.getNodeName());
//			
//		    /*
//		     * Etape 5 : récupération des personnes
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
//			     * Etape 6 : récupération du nom et du prénom
//			     */
//			    final Element nom = (Element) personne.getElementsByTagName("nom").item(0);
//			    final Element prenom = (Element) personne.getElementsByTagName("prenom").item(0);
//						
//			    //Affichage du nom et du prénom
//			    System.out.println("nom : " + nom.getTextContent());
//			    System.out.println("prénom : " + prenom.getTextContent());
//						
//			    /*
//			     * Etape 7 : récupération des numéros de téléphone
//			     */
//			    final NodeList telephones = personne.getElementsByTagName("telephone");
//			    final int nbTelephonesElements = telephones.getLength();
//						
//			    for(int j = 0; j<nbTelephonesElements; j++) {
//			        final Element telephone = (Element) telephones.item(j);
//			    
//	                        //Affichage du téléphone
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
	 * 		Le nom du fichier qui contient la base de donnÃ©es.
	 */
	public TimeTableDB(String file) {
		//TODO	Ã€ modifier
		super();
		this.setFile(file);
	}

	/**
	 * Getter de file
	 * 
	 * @return 
	 * 		Le nom du fichier qui contient la base de donnÃ©es.
	 */
	public String getFile() {
		return file;
	}

	/**
	 * Setter de file
	 * 
	 * @param file
	 * 		Le nom du fichier qui contient la base de donnÃ©es.
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
	BookingList.put(bookID, TimeTableList.get(tableTimeID).addBooking(bookID, login, dateBegin, dateEnd, roomID));	
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

