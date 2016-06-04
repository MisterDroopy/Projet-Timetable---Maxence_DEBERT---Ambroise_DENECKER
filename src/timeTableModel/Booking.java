/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package timeTableModel;

import java.util.Date;

/**
 * Cette classe permet de gérer les réservations.
 * 
 * @author Maxence Debert - Ambroise Denecker
 * @version 06/2016
 */
public class Booking {

	/**
	 * Nom du professeur
	 */
	protected String login = "";
	
	/**
	 * Numéro d'identification de la réservation
	 */
	protected int ID_Books = 0;
	/**
	 * Numéro d'identification de la salle
	 */
	protected int ID_Room = 0;
	/**
	 * Date de début de la réservation
	 */
	protected Date date_fin = new Date();
	/**
	 * Date de fin de la réservation
	 */
	protected Date date_debut = new Date();


	/**
	 * Le constructeur créant la réservation en initialisant toutes les informations
	 * 
	 * @param ID_Books
	 * 		le numéro d'identification de la réservation
	 * @param ID_Room
	 * 		le numéro d'identification de la salle
	 * @param login
	 * 		le nom du professeur
	 * @param date_debut
	 * 		la date de début de la réservation
	 * @param date_fin
	 * 		la date de fin de la réservation
	 */
	public Booking(int ID_Books, int ID_Room, String login, Date date_debut, Date date_fin) {
		this.ID_Books = ID_Books;
		this.ID_Room = ID_Room;
		this.login = login;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}

	/**
	 * Retourne le nom du professeur
	 * 
	 * @return le login du professeur
	 */
	public String getTeacherLogin() {
		return this.login;
	}

	/**
	 * Retourne le numéro d'identification de salle réservée
	 * 
	 * @return le numéro de salle de la réservation
	 */
	public int getRoom() {
		return this.ID_Room;
	}


	/**
	 * Retourne le numéro d'identification de la réservation
	 * 
	 * @return le numéro d'identication de la réservation
	 */
	public int getID_Books() {
		return this.ID_Books;
	}

	
	/**
	 * Retourne la date de fin de la réservation
	 * 
	 * @return la date de fin de la réservation
	 */
	public Date getDate_fin() {
		return this.date_fin;
	}


	/**
	 * Retourne la date de début de la réservation
	 * 
	 * @return la date de début de la réservation
	 */
	public Date getDate_debut() {
		return this.date_debut;
	}


}
