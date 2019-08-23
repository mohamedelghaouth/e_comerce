package com.services;

import java.util.List;

import com.bo.Client;

/**
 * interface du service metier permettant d'impl�menter la logique m�tier et
 * applicative li�es � la gestion des produits
 * 
 * @author T.BOUDAA
 *
 */
public interface GsClientService {

	/** implemente le service m�tier permettant de sauvgarder un produit */
	void addClient(Client p);

	/** impl�mente le service m�tier permettant de r�cup�rer tous les produits */
	List<Client> getAllClients();
	
	public Client getClientByMail(String mail);
	
	Client   getClientById(Long pId);
	
	String  ValidReigtrationClient(Client c, String ConfPw);
	
	String  ValidLoginClient(Client c);

}