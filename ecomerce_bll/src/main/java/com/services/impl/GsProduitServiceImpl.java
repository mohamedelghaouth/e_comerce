package com.services.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bo.Comentaire;
import com.bo.Produit;
import com.bo.WordPolarity;
import com.dao.CommentaireDao;
import com.dao.ProduitDao;
import com.dao.WordPolarityDao;
import com.dao.impl.WordPolarityDaoImpl;
import com.services.GsProduitService;

/**
 * Classe qui implemente les méthodes metiers de gestion de produits
 * 
 * @author T.Boudaa
 *
 */

@Service
@Transactional
public class GsProduitServiceImpl implements GsProduitService {

	
	@Autowired
	private CommentaireDao commentaireDao;
	
	@Autowired
	private WordPolarityDao wd;
	
	
	@Autowired
	private ProduitDao produitDao;

	public void addProduit(Produit p) {


		produitDao.create(p);

	}

	public List<Produit> getAllProducts() {
		return produitDao.getAll();
	}

	public Produit getProduitById(Long pId) {
		return produitDao.findById(pId);
	}

	@Override
	public void update(Produit p) {
		produitDao.update(p);
	}

	
	public void addComentaire(Comentaire c) {
		
		double note=getTextPolarity(c.getContenue());
		note+=c.getProduits().getNote();
		
		if(note<0) {
			c.getProduits().setSnote("bad");
			c.getProduits().setNote(note);
		}
		if(note>0) {
			c.getProduits().setSnote("good");
			c.getProduits().setNote(note);
		}
		if(note==0) {
			c.getProduits().setSnote("meduim");
			c.getProduits().setNote(note);
		}
		produitDao.update(c.getProduits());
		commentaireDao.create(c);
		
	}
	
	
	public double getTextPolarity(String ptext) {

		// tockenize

		String[] tokens = ptext.split(" ");

		if (tokens.length == 0) {
			return 0;
		}

		double moy = 0.0;

		for (String it : tokens) {
			moy += getWordPolarity(it);
		}

		return moy / tokens.length;
	}

	private double getWordPolarity(String pWord) {

		
		List<WordPolarity> words = wd.getAll();

		for (WordPolarity it : words) {

			if (it.getWord().equals(pWord)) {
				return it.getPolarity();
			}
		}

		return 0;
	}
		

	
	

}
