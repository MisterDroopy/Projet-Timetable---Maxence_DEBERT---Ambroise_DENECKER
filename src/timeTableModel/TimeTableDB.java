package timeTableModel;


import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import timeTableModel.Room;
import timeTableModel.TimeTable;




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
	private String file = "timeTableDB.xml";
	
	Map<Integer, TimeTable> TimeTableList = new HashMap<>();
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


///////////////////////////////////////////////////////////////////////////////////////////////////////
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
public boolean loadDB() {
			
	File xmlFile = new File(this.file);
	
	
	/*
     * Etape 1 : r�cup�ration d'une instance de la classe "DocumentBuilderFactory"
     */
    final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
    
    
    try {
        /*
         * Etape 2 : cr�ation d'un parseur
         */
        final DocumentBuilder builder = factory.newDocumentBuilder();
		
    /*
     * Etape 3 : cr�ation d'un Document
     */
        final Document document= builder.parse(xmlFile);
		
    /*
	 * Etape 4 : r�cup�ration de l'Element racine
	 */
	    final Element racine = document.getDocumentElement(); 
	    
        
        
        
	    /*
	     * Etape 5 : r�cup�ration des personnes
	     */
	    final NodeList NoeudsRoom = document.getElementsByTagName("Room");
	    final int nbNoeudsRoom = NoeudsRoom.getLength();
			
	    for (int i = 0; i<nbNoeudsRoom; i++) {
	    	
	    	Node noeud = NoeudsRoom.item(i);
	        if(noeud.getNodeType() == Node.ELEMENT_NODE) {
	            final Element room = (Element) noeud;
	            this.addRoom(Integer.parseInt(room.getAttribute("RoomId")),Integer.parseInt(room.getAttribute("Capacity")));
			}
	    
	    }
	    
	    
	    final NodeList NoeudsTimeTable = document.getElementsByTagName("TimeTable");
	    final int nbNoeudsTimeTable = NoeudsTimeTable.getLength();
	    
	    for(int i=0; i<nbNoeudsTimeTable;i++){//for1
	    	Node noeud = NoeudsTimeTable.item(i);
	    	if(noeud.getNodeType() == Node.ELEMENT_NODE) {//if1
	    		final Element timetable = (Element) noeud;
	    		this.addTimeTable(Integer.parseInt(timetable.getAttribute("GroupId")));
	    		
	    		 final NodeList NoeudsBook = document.getElementsByTagName("Book");
	    		 final int nbNoeudsBook = NoeudsBook.getLength();
	    		 for(int j=0; j<nbNoeudsBook; j++){//for2
	    			 Node noeud2 = NoeudsBook.item(j);
	    			 if(noeud2.getNodeType()==Node.ELEMENT_NODE){//if2
	    				 final Element book = (Element) noeud2;
	    				 this.addBooking(Integer.parseInt(timetable.getAttribute("GroupId")), Integer.parseInt(book.getAttribute("BookingId")), book.getAttribute("Login"), this.StringToDate(book.getAttribute("DateBegin")), this.StringToDate(book.getAttribute("DateEnd")), Integer.parseInt(book.getAttribute("RoomId")));
	    			 }//fin if2
	    		 }//fin for2
	    	}//fin if1
	    	
	    
	    }//fin for1
	    
	    }//fin try
    catch (Exception e){//catch
    	e.printStackTrace();
    	return false;
    }//fin catch
    return true;
}//fin loadDB
	



public Date StringToDate(String date){
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
Date fdate=null; // pas sur...
try {
	fdate = formatter.parse(date);
	return fdate;
}
catch(ParseException e) {
	e.printStackTrace();
}
return fdate;	
}



	
public String[] timeTableIDToString() {
	String retour[]=new String[100]; int i=0;
	Set<Integer> listKeys=TimeTableList.keySet();
	Iterator<Integer> iterateur = listKeys.iterator();
	while(iterateur.hasNext())
	{
		int key= iterateur.next(); // passe direct au suivant non ?
		retour[i]=String.valueOf(key);
		i=i+1;
	}
	return retour;
}

/**
 * Description of the method addRoom.
 * @param roomID 
 * @param capacity
 */
public boolean addRoom(int roomID, int capacity) {
	
	if(RoomList.containsKey(roomID)){
		
		return false;
	}
	RoomList.put(roomID, new Room(roomID, capacity) );
	if(RoomList.containsKey(roomID)){
		
		return true;
	}
	else {
		return false;
	}
}

/**
 * Description of the method removeRoom.
 * @param roomID 
 */
public boolean removeRoom(int roomID) {
	
	if(RoomList.containsKey(roomID)){
	
		RoomList.remove(roomID);	
		if(RoomList.containsKey(roomID)){
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
 * Description of the method getRoom.
 * @param timeTableID 
 * @param bookID 
 */
public int getRoom(int timeTableID, int bookID) {
	return TimeTableList.get(timeTableID).getRoom(bookID);
	
}

/**
 * Description of the method addTimeTable.
 * @param TimeTableID 
 */
public boolean addTimeTable(int TimeTableID) {
	
	if(TimeTableList.containsKey(TimeTableID)){
		
		return false;
	}
	TimeTableList.put(TimeTableID, new TimeTable(TimeTableID) );
	if(TimeTableList.containsKey(TimeTableID)){
		
		return true;
	}
	else {
		return false;
	}
	
}

/**
 * Description of the method removeTimeTableID.
 * @param timeTableID 
 */
public boolean removeTimeTableID(int timeTableID) {
	if(TimeTableList.containsKey(timeTableID)){
		
		TimeTableList.remove(timeTableID);	
		if(TimeTableList.containsKey(timeTableID)){
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
 * Description of the method addBooking.
 * @param tableTimeID 
 * @param bookID 
 * @param login 
 * @param dateBegin 
 * @param dateEnd 
 * @param roomID 
 */
public boolean addBooking(int tableTimeID, int bookID, String login, Date dateBegin, Date dateEnd, int roomID) {
	
	return TimeTableList.get(tableTimeID).addBooking(bookID, login, dateBegin, dateEnd, roomID);
}


/**
 * Description of the method getBookingsDate.
 * @param timeTableID 
 * @param dateBegin 
 * @param dateEnd 
 */
public void getBookingsDate(int timeTableID,  Hashtable<Integer, Date> dateBegin,  Hashtable<Integer, Date>  dateEnd) {
	TimeTableList.get(timeTableID).getDateBegin(dateBegin);
	TimeTableList.get(timeTableID).getDateEnd(dateEnd);
}

/**
 * Description of the method removeBook.
 * @param timeTableID 
 * @param bookID 
 */
public boolean removeBook(int timeTableID, int bookID) {
	return TimeTableList.get(timeTableID).removeBook(bookID);
}

/**
 * Description of the method roomsToString.
 */
public String[] roomsToString() {
	String retour[]= new String[100]; int i=0;
	Set<Integer> listKeys=RoomList.keySet();
	Iterator<Integer> iterateur = listKeys.iterator();
	while(iterateur.hasNext())
	{
		int key= iterateur.next();
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
	String retour[]=new String[100]; int i=0;
	Set<Integer> listKeys=RoomList.keySet();
	Iterator<Integer> iterateur = listKeys.iterator();
	while(iterateur.hasNext())
	{
		int key= iterateur.next(); // passe direct au suivant non ?
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


///**
// * Returns rooms.
// * @return rooms 
// */
//public HashSet<Room> getRooms() {
//	return this.rooms;
//}
//
///**
// * Returns timeTables.
// * @return timeTables 
// */
//public HashSet<TimeTable> getTimeTables() {
//	return this.timeTables;
//}

}

