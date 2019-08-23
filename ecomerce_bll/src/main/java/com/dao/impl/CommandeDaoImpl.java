package com.dao.impl;

import org.springframework.stereotype.Repository;

import com.bo.Commande;
import com.dao.CommandeDao;
import com.genericdao.impl.HibernateSpringGenericDaoImpl;

/**
 * Une impl�mentation du DAO pour l'entit� produit. Cette impl�mentation se base
 * sur Spring (h�ritage de HibernateSpringGenericDaoImpl)
 * 
 * @author T.BOUDAA
 *
 */

@Repository
public class CommandeDaoImpl extends HibernateSpringGenericDaoImpl<Commande, Long> implements CommandeDao {

	public CommandeDaoImpl() {
		super(Commande.class);
	}

}
