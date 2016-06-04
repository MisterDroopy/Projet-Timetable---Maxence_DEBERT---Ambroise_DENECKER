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
	 * Description of the property ID_Room.
	 */
	protected int ID_Room = 0;

	/**
	 * Description of the property capacity.
	 */
	protected int capacity = 0;


	/**
	 * The constructor.
	 */
	public Room(int ID_Room, int capacity) {
		this.ID_Room = ID_Room;
		this.capacity = capacity;
	}

	/**
	 * Description of the method infoToString.
	 */
	public String infoToString() {
		return (String.valueOf(this.ID_Room) + " : " + String.valueOf(this.capacity));
	}

	
	/**
	 * Returns ID_Room.
	 * 
	 * @return ID_Room
	 */
	public int getID_Room() {
		return this.ID_Room;
	}

	
	
	/**
	 * Returns capacity.
	 * 
	 * @return capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}

	public String getCapacityToString() {
		return String.valueOf(this.capacity);
	}

}
