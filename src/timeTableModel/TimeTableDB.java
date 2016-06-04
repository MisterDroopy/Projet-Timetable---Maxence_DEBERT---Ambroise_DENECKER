package timeTableModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import timeTableModel.Room;
import timeTableModel.TimeTable;
import org.jdom2.*;
import org.jdom2.input.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import java.util.List;

/**
 * 
 * Cette classe gére la base de données d'emplois du temps. Elle doit
 * permettre de sauvegarder et charger les emplois du temps ainsi que les salles
 * à partir d'un fichier XML. La structure du fichier XML devra être la même
 * que celle du fichier TimeTableDB.xml.
 * 
 * @see <a href="../../TimeTableDB.xml">TimeTableDB.xml</a>
 * 
 * @author Maxence Debert - Ambroise Denecker
 * @version 06/2016
 * 
 */

// TODO Classe à modifier

public class TimeTableDB {
	/**
	 * 
	 * Le fichier contenant la base de données.
	 * 
	 */
	private String file;

	/**
	 * Couple de num�ro d'identification associ� � l'objet emploi du temps 
	 */
	Map<Integer, TimeTable> TimeTableList = new HashMap<>();
	
	/**
	 * Couple de num�ro de salle et de l'objet
	 */
	Map<Integer, Room> RoomList = new HashMap<>();

	/**
	 * D�claration du document, c'est � la base de donn�es de l'emploi du temps
	 */
	static org.jdom2.Document document;
	
	/**
	 * Racine du document
	 */
	static Element racine;

	
	/**
	 * Le constructeur du controller de la base de donn�e de l'emploi du temps
	 * 
	 * @param file
	 *  	Le nom du fichier qui contient la base de données.
	 */
	public TimeTableDB(String file) {
		// TODO À modifier
		super();
		this.setFile(file);
	}

	/**
	 * Getter de file
	 * 
	 * @return Le nom du fichier qui contient la base de données.
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
	 * Sauvegarde les donn�es des objets dans la base de donn�es
	 * 
	 * @return 
	 * 		A COMPLETER
	 */
	public boolean saveDB() {
		System.out.println("Entr�e saveDB");
		Set<Integer> listKeysTimeTable = TimeTableList.keySet();
		Set<Integer> listKeysRoom = RoomList.keySet();
		SAXBuilder sax = new SAXBuilder();
		Document document = null;
		Element racine = new Element("TImeTablesDB");
		Element racine_timetables = new Element("TimeTables");
		Element racine_rooms = new Element("Rooms");
		racine.addContent((Content) racine_timetables);
		racine.addContent((Content) racine_rooms);
		try {
			document = sax.build(new File(this.file));

		} catch (Exception v0) {
		}
		if (document != null) {
			Iterator<Integer> iterateur_timetables = listKeysTimeTable.iterator();
			while (iterateur_timetables.hasNext()) {
				String cle = String.valueOf(iterateur_timetables.next());
				Element timetable = new Element("TimeTable");
				Element groupId = new Element("GroupId");
				groupId.setText(cle);
				timetable.addContent((Content) groupId);
				Set<Integer> listKeysBooking = TimeTableList.get(Integer.parseInt(cle)).bookingTable().keySet();
				Element racine_books = new Element("Books");
				timetable.addContent((Content) racine_books);
				Iterator<Integer> iterateur_books = listKeysBooking.iterator();
				while (iterateur_books.hasNext()) {
					String clebook = String.valueOf(iterateur_books.next());
					Element book = new Element("Book");
					Element bookId = new Element("BookingId");
					bookId.setText(clebook);
					book.addContent((Content) bookId);
					Element login = new Element("Login");
					Element dateDebut = new Element("DateBegin");
					Element dateFin = new Element("DateEnd");
					Element roomId = new Element("RoomId");
					login.setText(TimeTableList.get(Integer.parseInt(cle)).getTeachLogin(Integer.parseInt(clebook)));
					book.addContent((Content) login);
					dateDebut.setText(TimeTableList.get(Integer.parseInt(cle)).getDateDebu(Integer.parseInt(clebook)));
					book.addContent((Content) dateDebut);
					dateFin.setText(TimeTableList.get(Integer.parseInt(cle)).getDateFi(Integer.parseInt(clebook)));
					book.addContent((Content) dateFin);
					roomId.setText(String
							.valueOf(TimeTableList.get(Integer.parseInt(cle)).getRoom(Integer.parseInt(clebook))));
					book.addContent((Content) roomId);
					racine_books.addContent((Content) book);
				}
				racine_timetables.addContent((Content) timetable);
			}
			Iterator<Integer> iterateur_rooms = listKeysRoom.iterator();
			while (iterateur_rooms.hasNext()) {
				String cleroom = String.valueOf(iterateur_rooms.next());
				Element room = new Element("Room");
				Element roomId = new Element("RoomId");
				roomId.setText(cleroom);
				room.addContent((Content) roomId);
				Element capacity = new Element("Capacity");
				capacity.setText(RoomList.get(Integer.parseInt(cleroom)).getCapacityToString());
				room.addContent((Content) capacity);
				racine_rooms.addContent((Content) room);
			}
			document.setRootElement(racine);
			try {
				XMLOutputter object = new XMLOutputter(Format.getPrettyFormat());
				object.output(document, (OutputStream) new FileOutputStream(this.file));
			} catch (IOException v0) {
				return false;
			}
			return true;
		}
		return true;
	}

	
	/**
	 * Charge les objets � partir des valeurs dans la base de donn�es
	 * 
	 * @return
	 * 		A COMPLETER
	 */
	public boolean loadDB() {
		System.out.println("Entr�e load");

		SAXBuilder sxb = new SAXBuilder();
		try {
			document = sxb.build(new File(this.file));
		} catch (Exception e) {
		}
		racine = document.getRootElement();
		Load_Rooms(racine);
		Load_TimeTable(racine);
		return true;
	}

	
	/**
	 * Charge les donn�es dans les objets correspondant aux salles
	 * 
	 * @param racine
	 * 		Racine de la base de donn�es
	 */
	public void Load_Rooms(Element racine) {
		String id, capacity;
		Element racine2 = racine.getChild("Rooms");
		List<Element> room = racine2.getChildren("Room");
		int i;
		for (i = 0; i < room.size(); i++) {
			List<Element> room1 = room.get(i).getChildren();
			id = room1.get(0).getText();
			capacity = room1.get(1).getText();
			this.addRoom(Integer.parseInt(id), Integer.parseInt(capacity));
		}
	}

	
	/**
	 * Charge les emplois du temps
	 * 
	 * @param racine
	 * 		Racine de la base de donn�es
	 */
	public void Load_TimeTable(Element racine) {
		String id, bookid, login, datedebut, datefin, roomid;
		Element racine2 = racine.getChild("TimeTables");
		List<Element> timetable = racine2.getChildren("TimeTable");
		int i;
		for (i = 0; i < timetable.size(); i++) {
			id = timetable.get(i).getChild("GroupId").getText();
			this.addTimeTable(Integer.parseInt(id));
			Element racinebook = timetable.get(i).getChild("Books");
			List<Element> book = racinebook.getChildren("Book");
			int j;
			for (j = 0; j < book.size(); j++) {
				List<Element> book1 = book.get(j).getChildren();
				bookid = book1.get(0).getText();
				login = book1.get(1).getText();
				datedebut = book1.get(2).getText();
				datefin = book1.get(3).getText();
				roomid = book1.get(4).getText();
				this.addBooking(Integer.parseInt(id), Integer.parseInt(bookid), login, StringToDate(datedebut),
						StringToDate(datefin), Integer.parseInt(roomid));

			}

		}

	}

	
	/**
	 * Retourne une date en format date � partir d'un format String
	 * 
	 * @param date
	 * 		Date � changer de type
	 * 
	 * @return la date en chaine de caract�res
	 */
	public Date StringToDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date fdate = null; // pas sur...
		try {
			fdate = formatter.parse(date);
			return fdate;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fdate;
	}

	
	/**
	 * Renvoie un tableau contenant la liste des identifiants des emplois du temps en chaine de caract�res
	 * 
	 * @return un tableau contenant la liste des identifiants des emplois du temps en chaine de caract�res 
	 */
	public String[] timeTableIDToString() {
		String retour[] = new String[100];
		int i = 0;
		Set<Integer> listKeys = TimeTableList.keySet();
		Iterator<Integer> iterateur = listKeys.iterator();
		while (iterateur.hasNext()) {
			int key = iterateur.next();
			retour[i] = String.valueOf(key);
			i = i + 1;
		}
		return retour;
	}
	

	/**
	 * Ajoute une salle 
	 * 
	 * @param roomID
	 * 		Num�ro de la salle
	 * @param capacity
	 * 		Capacit� de la salle
	 * 
	 * @return	
	 * 		Vrai si ajout�
	 * 		Faux sinon
	 */
	public boolean addRoom(int roomID, int capacity) {
		System.out.println("Entr�e addroom");
		if (RoomList.containsKey(roomID)) {
			return false;
		}
		RoomList.put(roomID, new Room(roomID, capacity));
		if (RoomList.containsKey(roomID)) {
			return this.saveDB();
		} else {
			return false;
		}
	}
	

	/**
	 * Supprime une salle
	 *  
	 * @param roomID
	 * 		Num�ro de la salle
	 * 
	 * @return	
	 * 		Vrai si supprim�
	 * 		Faux sinon
	 */
	public boolean removeRoom(int roomID) {
		if (RoomList.containsKey(roomID)) {
			RoomList.remove(roomID);
			if (RoomList.containsKey(roomID)) {
				return false;
			} else {
				return this.saveDB();
			}
		} else {
			return false;
		}
	}

	
	/**
	 * Renvoie le num�ro de la salle
	 * 
	 * @param timeTableID
	 * 		Num�ro d'identification de l'emploi du temps
	 * @param bookID
	 * 		Num�ro de la r�servation
	 * 
	 * @return le num�ro de la salle
	 */
	public int getRoom(int timeTableID, int bookID) {
		return TimeTableList.get(timeTableID).getRoom(bookID);
	}

	
	/**
	 * Ajoute un emploi du temps
	 * 
	 * @param TimeTableID
	 * 		Num�ro d'identification de l'emploi du temps
	 * 
	 * @return 
	 * 		Vrai si ajout�
	 * 		Faux sinon
	 */
	public boolean addTimeTable(int TimeTableID) {
		if (TimeTableList.containsKey(TimeTableID)) {
			return false;
		}
		TimeTableList.put(TimeTableID, new TimeTable(TimeTableID));
		if (TimeTableList.containsKey(TimeTableID)) {
			return this.saveDB();
		} else {
			return false;
		}
	}

	
	/**
	 * Supprime un emploi du temps	
	 *  
	 * @param timeTableID
	 * 
	 * @return	
	 * 		Vrai si supprim�
	 * 		Faux sinon
	 */
	public boolean removeTimeTableID(int timeTableID) {
		if (TimeTableList.containsKey(timeTableID)) {
			TimeTableList.remove(timeTableID);
			if (TimeTableList.containsKey(timeTableID)) {
				return false;
			} else {
				return this.saveDB();
			}
		} else {
			return false;
		}
	}

	
	/**
	 * Ajoute une r�servation
	 *  
	 * @param tableTimeID
	 * 		Num�ro de l'emploi du temps
	 * @param bookID
	 * 		Num�ro de la r�servation
	 * @param login
	 * 		Nom du professeur
	 * @param dateBegin
	 * 		Date de d�but
	 * @param dateEnd
	 * 		Date de fin
	 * @param roomID
	 * 		Num�ro de la salle
	 * 
	 * @return	
	 * 		Vrai si ajout�
	 * 		Faux sinon
	 */
	public boolean addBooking(int tableTimeID, int bookID, String login, Date dateBegin, Date dateEnd, int roomID) {
		return TimeTableList.get(tableTimeID).addBooking(bookID, login, dateBegin, dateEnd, roomID) && this.saveDB();
	}

	
	/**
	 * Remplie les Hashtable de couple de num�ro de r�servation et date
	 * 
	 * @param timeTableID
	 * 		Num�ro d'identification d'emploi du temps
	 * @param dateBegin
	 * 		Hashtable de couple num�ro de r�servation et date de d�but
	 * @param dateEnd
	 * 		Hashtable de couple num�ro de r�servation et date de fin
	 */
	public void getBookingsDate(int timeTableID, Hashtable<Integer, Date> dateBegin, Hashtable<Integer, Date> dateEnd) {
		TimeTableList.get(timeTableID).getDateBegin(dateBegin);
		TimeTableList.get(timeTableID).getDateEnd(dateEnd);
	}

	
	/**
	 * Supprime une r�servation
	 * 
	 * @param timeTableID
	 * 		Num�ro d'identification de l'emploi du temps
	 * @param bookID
	 * 		Num�ro de r�servation
	 * 
	 * @return 
	 * 		Vrai si supprim�
	 * 		Faux sinon
	 */
	public boolean removeBook(int timeTableID, int bookID) {
		return TimeTableList.get(timeTableID).removeBook(bookID) && this.saveDB();
	}

	
	/**
	 * Renvoie un tableau contenant la liste des num�ro des salles en chaine de caract�res
	 * 
	 * @return un tableau contenant la liste des num�ro des salles en chaine de caract�res
	 */
	public String[] roomsToString() {
		String retour[] = new String[100];
		int i = 0;
		Set<Integer> listKeys = RoomList.keySet();
		Iterator<Integer> iterateur = listKeys.iterator();
		while (iterateur.hasNext()) {
			int key = iterateur.next();
			retour[i] = RoomList.get(key).infoToString();
			i = i + 1;
		}
		return retour;
	}

	
	/**
	 * Retourne le num�ro de la r�servation le plus �lev�
	 * 
	 * @param timeTableID
	 * 		Num�ro d'identification de l'emploi du temps
	 * 
	 * @return le num�ro de la r�servation maximum
	 */
	public int getBookingMaxID(int timeTableID) {
		int max;
		max = TimeTableList.get(timeTableID).getBookMaxId();
		System.out.println("Max :" + max);
		return max;

	}


	/**
	 * Renvoie un tableau de num�ros de r�servation de l'emploi du temps en chaine de caract�res
	 * 
	 * @param timeTableID
	 * 		Num�ro d'identification de l'emploi du temps
	 * 
	 * @return un tableau de num�ros de r�servation en chaine de caract�res
	 */
	public String[] booksIDToString(int timeTableID) {
		String retour[];
		retour = TimeTableList.get(timeTableID).booksIDString();
		return retour;

	}
	

	/**
	 * Renvoi un tableau des num�ros des salles en chaine de caract�res
	 *
	 * @return un tableau des num�ros des salles en chaine de caract�res
	 */
	public String[] roomsIDToString() {
		String retour[] = new String[100];
		int i = 0;
		Set<Integer> listKeys = RoomList.keySet();
		Iterator<Integer> iterateur = listKeys.iterator();
		while (iterateur.hasNext()) {
			int key = iterateur.next();
			retour[i] = String.valueOf(key);
			i = i + 1;
		}
		return retour;
	}


	/**
	 * Fonction permettant de r�cup�rer le login du professeur qui a r�alis� la r�servation dont l'identifiant est bookId dans l'emploi du temps dont l'identifiant est timeTableId.
	 * 
	 * @param timeTableID
	 * 		Num�ro d'identification de l'emploi du temps
	 * @param bookID
	 * 		Num�ro de la r�servation
	 * 
	 * @return le nom du professeur
	 */
	public String getTeacherLogin(int timeTableID, int bookID) {
		String login = TimeTableList.get(timeTableID).getTeachLogin(bookID);
		return login;
	}
}
