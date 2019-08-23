package com.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bo.Client;
import com.bo.Produit;
import com.dao.ClientDao;
import com.dao.ProduitDao;
import com.services.GsClientService;
import com.services.GsProduitService;

/**
 * Classe qui implemente les méthodes metiers de gestion de produits
 * 
 * @author T.Boudaa
 *
 */

@Service
@Transactional
public class GsClientServiceImpl implements GsClientService {

	@Autowired
	private ClientDao clientDao;

	public void addClient(Client p) {

		// TODO: ajout des regles metier s'elles existent

		clientDao.create(p);

	}

	public List<Client> getAllClients() {
		return clientDao.getAll();
	}

	public Client getClientById(Long pId) {
		return clientDao.findById(pId);
	}

	public Client getClientByMail(String mail) {
		List<Client>l=new ArrayList<Client>();
		l=clientDao.getEntityByColValue("Client", "email",mail);
		return l.get(0);
	}

	public String ValidReigtrationClient(Client c, String ConfPw) {
		
		String s="success";
		if(c!=null) {
		if(("".equals(c.getEmail()))||(c.getEmail()==null)) {
			return "l'email est obligatoire";
		}
		if(("".equals(c.getPassword()))||(c.getPassword()==null)) {
			return "le mot de passe  est obligatoire";
		}
		if(("".equals(ConfPw))||(ConfPw==null)) {
			return "la confirmation du  mot de passe  est obligatoire";
		}
		if(!c.getPassword().equals(ConfPw)) {
			return "le mot de passe n'a pas etais confirmer";
		}
		
		for(Client t : getAllClients()) {
			if(t.getEmail().equals(c.getEmail())) 
				return "ce mail existe déja, essayer avec un autre";
		}
		
		addClient(c);
		return s;
		}
		else return "rien";
	}

	
	public String ValidLoginClient(Client c) {

		String s="success";

		if((c.getEmail().equals(""))||(c.getEmail()==null)) {
			return "l'email est obligatoire";
		}
		if((c.getPassword().equals(""))||(c.getPassword()==null)) {
			return "le mot de passe  est obligatoire";
		}
		
		ArrayList<Client>l= (ArrayList<Client>) clientDao.getEntityByColValue("Client","email", c.getEmail());
		
		if((l.isEmpty())||(!l.get(0).getPassword().equals(c.getPassword())))
			return "le mot de passe ou l'email est incorrecte";
		
		
		 return s;
		
		
	}

	

}
