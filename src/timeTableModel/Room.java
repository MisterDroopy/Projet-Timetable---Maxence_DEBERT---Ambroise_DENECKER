/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package timeTableModel;

// Start of user code (user defined imports)

// End of user code

/**
 * Cette classe permet de gérer les salles.
 * 
 * @author Maxence Debert - Ambroise Denecker
 * @version 06/2016
 */
public class Room {
	/**
	 * Numéro d'identification de la salle
	 */
	protected int ID_Room = 0;

	/**
	 * Capacité de la salle
	 */
	protected int capacity = 0;


	/**
	 * Constructeur de la salle créant la salle associée à une capacité.
	 * 
	 * @param ID_Room
	 * 		Numéro d'identification de la salle
	 * @param capacity
	 * 		Capacité de la salle
	 */
	public Room(int ID_Room, int capacity) {
		this.ID_Room = ID_Room;
		this.capacity = capacity;
	}

	/**
	 * Renvoie le numéro d'identification et la capacité de la salle dans une chaine de caractère
	 * 
	 * @return "Numéro d'identification de la salle" + "Capacity" en chaine de caractère
	 */
	public String infoToString() {
		return (String.valueOf(this.ID_Room) + " : " + String.valueOf(this.capacity));
	}

	
	/**
	 * Retourne le numéro d'identification de la salle
	 * 
	 * @return le numéro d'identification de la salle
	 */
	public int getID_Room() {
		return this.ID_Room;
	}

	
	
	/**
	 * Retourne la capacité de la salle
	 * 
	 * @return la capacité de la salle 
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Renvoie la capacité de la salle dans une chaine de caractère
	 * 
	 * @return "Capacity" en chaine de caractère
	 */
	public String getCapacityToString() {
		return String.valueOf(this.capacity);
	}

}
