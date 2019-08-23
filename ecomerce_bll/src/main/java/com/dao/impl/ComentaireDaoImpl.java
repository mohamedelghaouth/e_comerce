package com.dao.impl;

import org.springframework.stereotype.Repository;

import com.bo.Comentaire;
import com.dao.CommentaireDao;
import com.genericdao.impl.HibernateSpringGenericDaoImpl;

@Repository
public class ComentaireDaoImpl extends HibernateSpringGenericDaoImpl<Comentaire, Long> implements CommentaireDao {

	public ComentaireDaoImpl() {
		super(Comentaire.class);
	}

}
