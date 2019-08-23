package com.dao.impl;

import org.springframework.stereotype.Repository;

import com.bo.Client;
import com.dao.ClientDao;
import com.genericdao.impl.HibernateSpringGenericDaoImpl;

/**
 * Une impl�mentation du DAO pour l'entit� produit. Cette impl�mentation se base
 * sur Spring (h�ritage de HibernateSpringGenericDaoImpl)
 * 
 * @author T.BOUDAA
 *
 */

@Repository
public class ClientDaoImpl extends HibernateSpringGenericDaoImpl<Client, Long> implements ClientDao {

	public ClientDaoImpl() {
		super(Client.class);
	}

}
