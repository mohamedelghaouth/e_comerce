package com.dao.impl;

import org.springframework.stereotype.Repository;

import com.bo.Produit;
import com.dao.ProduitDao;
import com.genericdao.impl.HibernateSpringGenericDaoImpl;

/**
 * Une impl�mentation du DAO pour l'entit� produit. Cette impl�mentation se base
 * sur Spring (h�ritage de HibernateSpringGenericDaoImpl)
 * 
 * @author T.BOUDAA
 *
 */

@Repository
public class ProduitDaoImpl extends HibernateSpringGenericDaoImpl<Produit, Long> implements ProduitDao {

	public ProduitDaoImpl() {
		super(Produit.class);
	}

}
