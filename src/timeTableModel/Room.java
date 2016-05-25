/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package timeTableModel;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Room.
 * 
 * @author ambroise
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

	// Start of user code (user defined attributes for Room)

	// End of user code

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
		return (String.valueOf(this.ID_Room)+ " : "+ String.valueOf(this.capacity));
	}

	/**
	 * Description of the method roomIDToString.
	 */
	/*public String roomIDToString() {
		return String.valueOf(this.ID_Room);
	}
	
	* Inutile car juste besoin de récupérer les ID, à prendre directement dans la HashMap dans DB
	*/ 

	// Start of user code (user defined methods for Room)

	// End of user code
	/**
	 * Returns ID_Room.
	 * @return ID_Room 
	 */
	public int getID_Room() {
		return this.ID_Room;
	}

	/**
	 * Sets a value to attribute ID_Room. 
	 * @param newID_Room 
	 */
	public void setID_Room(int newID_Room) {
		this.ID_Room = newID_Room;
	}

	/**
	 * Returns capacity.
	 * @return capacity 
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Sets a value to attribute capacity. 
	 * @param newCapacity 
	 */
	public void setCapacity(int newCapacity) {
		this.capacity = newCapacity;
	}

}
