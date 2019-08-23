package com.services;

import java.util.List;

import com.bo.Categorie;
import com.bo.Produit;

/**
 * interface du service metier permettant d'implémenter la logique métier et
 * applicative liées à la gestion des produits
 * 
 * @author T.BOUDAA
 *
 */
public interface GsCategorieService {

	/** implemente le service métier permettant de sauvgarder un produit */
	void addCategorie(Categorie p);
	void update(Categorie p);
	void addproduit(Produit p,Categorie c);
	void deleteProduit(Produit p,Categorie c);
	/** implémente le service métier permettant de récupérer tous les produits */
	List<Categorie> getAllCategories();

}