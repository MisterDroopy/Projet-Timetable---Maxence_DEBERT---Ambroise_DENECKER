/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package timeTableModel;

// Start of user code (user defined imports)

// End of user code

/**
 * Cette classe permet de g�rer les salles.
 * 
 * @author Maxence Debert - Ambroise Denecker
 * @version 06/2016
 */
public class Room {
	/**
	 * Num�ro d'identification de la salle
	 */
	protected int ID_Room = 0;

	/**
	 * Capacit� de la salle
	 */
	protected int capacity = 0;


	/**
	 * Constructeur de la salle cr�ant la salle associ�e � une capacit�.
	 * 
	 * @param ID_Room
	 * 		Num�ro d'identification de la salle
	 * @param capacity
	 * 		Capacit� de la salle
	 */
	public Room(int ID_Room, int capacity) {
		this.ID_Room = ID_Room;
		this.capacity = capacity;
	}

	/**
	 * Renvoie le num�ro d'identification et la capacit� de la salle dans une chaine de caract�re
	 * 
	 * @return "Num�ro d'identification de la salle" + "Capacity" en chaine de caract�re
	 */
	public String infoToString() {
		return (String.valueOf(this.ID_Room) + " : " + String.valueOf(this.capacity));
	}

	
	/**
	 * Retourne le num�ro d'identification de la salle
	 * 
	 * @return le num�ro d'identification de la salle
	 */
	public int getID_Room() {
		return this.ID_Room;
	}

	
	
	/**
	 * Retourne la capacit� de la salle
	 * 
	 * @return la capacit� de la salle 
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Renvoie la capacit� de la salle dans une chaine de caract�re
	 * 
	 * @return "Capacity" en chaine de caract�re
	 */
	public String getCapacityToString() {
		return String.valueOf(this.capacity);
	}

}
