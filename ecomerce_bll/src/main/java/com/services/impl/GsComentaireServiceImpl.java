package com.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bo.Comentaire;
import com.bo.Produit;
import com.dao.CategorieDao;
import com.dao.CommentaireDao;
import com.services.GsComentaireService;


public class GsComentaireServiceImpl  implements GsComentaireService{

	@Autowired
	private CommentaireDao commentaireDao;
	
	
	@Override
	public void addComentaier(Comentaire c) {
			
		commentaireDao.create(c);
	}

	
}
