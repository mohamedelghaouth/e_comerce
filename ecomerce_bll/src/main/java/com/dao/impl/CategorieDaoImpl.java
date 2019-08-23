package com.dao.impl;

import org.springframework.stereotype.Repository;

import com.bo.Categorie;

import com.dao.CategorieDao;
import com.genericdao.impl.HibernateSpringGenericDaoImpl;

/**
 * Une impl�mentation du DAO pour l'entit� produit. Cette impl�mentation se base
 * sur Spring (h�ritage de HibernateSpringGenericDaoImpl)
 * 
 * @author T.BOUDAA
 *
 */

@Repository
public class CategorieDaoImpl extends HibernateSpringGenericDaoImpl<Categorie, Long> implements CategorieDao {

	public CategorieDaoImpl() {
		super(Categorie.class);
	}

}
