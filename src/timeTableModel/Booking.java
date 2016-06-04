/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package timeTableModel;

import java.util.Date;

/**
 * Cette classe permet de g�rer les r�servations.
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
	 * Num�ro d'identification de la r�servation
	 */
	protected int ID_Books = 0;
	/**
	 * Num�ro d'identification de la salle
	 */
	protected int ID_Room = 0;
	/**
	 * Date de d�but de la r�servation
	 */
	protected Date date_fin = new Date();
	/**
	 * Date de fin de la r�servation
	 */
	protected Date date_debut = new Date();


	/**
	 * Le constructeur cr�ant la r�servation en initialisant toutes les informations
	 * 
	 * @param ID_Books
	 * 		le num�ro d'identification de la r�servation
	 * @param ID_Room
	 * 		le num�ro d'identification de la salle
	 * @param login
	 * 		le nom du professeur
	 * @param date_debut
	 * 		la date de d�but de la r�servation
	 * @param date_fin
	 * 		la date de fin de la r�servation
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
	 * Retourne le num�ro d'identification de salle r�serv�e
	 * 
	 * @return le num�ro de salle de la r�servation
	 */
	public int getRoom() {
		return this.ID_Room;
	}


	/**
	 * Retourne le num�ro d'identification de la r�servation
	 * 
	 * @return le num�ro d'identication de la r�servation
	 */
	public int getID_Books() {
		return this.ID_Books;
	}

	
	/**
	 * Retourne la date de fin de la r�servation
	 * 
	 * @return la date de fin de la r�servation
	 */
	public Date getDate_fin() {
		return this.date_fin;
	}


	/**
	 * Retourne la date de d�but de la r�servation
	 * 
	 * @return la date de d�but de la r�servation
	 */
	public Date getDate_debut() {
		return this.date_debut;
	}


}
