package com.services;

import java.util.List;

import com.bo.Comentaire;
import com.bo.Produit;

/**
 * interface du service metier permettant d'impl�menter la logique m�tier et
 * applicative li�es � la gestion des produits
 * 
 * @author T.BOUDAA
 *
 */
public interface GsProduitService {

	/** implemente le service m�tier permettant de sauvgarder un produit */
	void addProduit(Produit p);

	/**
	 * impl�mente le service m�tier permettant de r�cup�rer tous les produits
	 */
	List<Produit> getAllProducts();
	
	void update(Produit p);

	Produit getProduitById(Long pId);

	void addComentaire(Comentaire c);
	
}