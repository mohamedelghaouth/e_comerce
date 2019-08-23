package com.actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;

import com.bo.Categorie;
import com.bo.Client;
import com.bo.Produit;
import com.services.GsCategorieService;
import com.services.GsClientService;
import com.services.GsProduitService;

@ResultPath("/pages/")
public class GsCategorieAction extends BaseAction {

	private Long idProduit;
	private Long idCategorie;
	private String  plabel;
	private List<String> listlabels=new ArrayList<String>();
	
	/**
	 * utilisée pour stocker la liste des produits destinés à afficher dans la
	 * vue
	 */
	private List<Categorie> listCategories;

	/** utilisé pour stocker les données du produit saisies dans la vue */
	private Categorie categorie;
	/** utilisé pour stocker les données du produit saisies dans la vue */
	private Produit produit;

	/** injection du service métier */
	@Autowired
	private GsCategorieService gsCategorieService;
	@Autowired
	private GsProduitService gsProduitService;

	
	@Action(value = "toaffectercategorie", results = { @Result(name = "success", location = "/pages/admin/AjouterAuCategorie.jsp") })
	public String toaffectercategorie() {

		produit=gsProduitService.getProduitById(idProduit);
		listCategories=gsCategorieService.getAllCategories();
		
		for(Categorie c: listCategories){
			listlabels.add(c.getLabel());
			}
		
		
		// On retoune la page associée à success
		return SUCCESS;

	}
	
	@Action(value = "deleteProdFromCat", results = { @Result(name = "success", type="redirectAction", location = "getAllCategories"),
			 @Result(name = "input", type="redirectAction", location = "getAllCategories")})
	public String deleteProdFromCat() {
		produit=gsProduitService.getProduitById(idProduit);
		listCategories=gsCategorieService.getAllCategories();
		
		for(Categorie c: listCategories){
			if(c.getId().equals(idCategorie)) {
				
				categorie=c;}
			}
		categorie.setQuantite(categorie.getQuantite()-1);
		categorie.getProduits().remove(produit);
		gsCategorieService.update(categorie);
		produit.setCategorie(null);
		gsProduitService.update(produit);
		return SUCCESS;

	}

	@Action(value = "affectercategorie", results = { @Result(name = "success", location = "/pages/admin/listCategories.jsp") })
	public String affectercategorie() {
		
		produit=gsProduitService.getProduitById(idProduit);
		listCategories=gsCategorieService.getAllCategories();
		for(Categorie c: listCategories){
			
			if(c.getLabel().equals(plabel)) {
				categorie=c;
			}
		}
		produit.setCategorie(categorie);
		categorie.getProduits().add(produit);
		gsCategorieService.addproduit(produit, categorie);;
		// On retoune la page associée à success
		return SUCCESS;

	}

	
	@Action(value = "toaddCategorie", results = { @Result(name = "success", location = "/pages/admin/addCategorie.jsp") })
	public String toaddCategorie() {

		
		return SUCCESS;

	}
	
	@Action(value = "addCategorie", results = { @Result(name = "success", location = "/pages/admin/listCategories.jsp") })
	public String addCategorie() {

		// On utilise le service métier pour sauvegarder en base de données le
		// produit
		// rempli par les données copiées automatiquement par struts de la vue
		// vers
		// l'objet produit
		gsCategorieService.addCategorie(categorie);
		listCategories=gsCategorieService.getAllCategories();
		// On retoune la page associée à success
		return SUCCESS;

	}

	@Action(value = "getAllCategories", results = { @Result(name = "success", location = "/pages/admin/listCategories.jsp") })
	public String getAllCategories() {

		// En utiliant le service métier on charge la liste des produit et on la
		// stocke
		// dans l'attribut qui sera lu depuis une vue
		listCategories = gsCategorieService.getAllCategories();

		for(Categorie c:listCategories) {
			if(c.getProduits().isEmpty())
					c.setQuantite(0);
			else c.setQuantite(c.getProduits().size());
		}
		listCategories = gsCategorieService.getAllCategories();
		// on redirige vers la vue associé à la clé sucess
		return SUCCESS;

	}

	public List<Categorie> getListCategories() {
		return listCategories;
	}

	public void setListCategories(List<Categorie> listCategories) {
		this.listCategories = listCategories;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public GsCategorieService getGsCategorieService() {
		return gsCategorieService;
	}

	public void setGsCategorieService(GsCategorieService gsCategorieService) {
		this.gsCategorieService = gsCategorieService;
	}


	public Long getIdProduit() {
		return idProduit;
	}


	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}



	public Produit getProduit() {
		return produit;
	}



	public void setProduit(Produit produit) {
		this.produit = produit;
	}



	public String getLabel() {
		return plabel;
	}



	public void setLabel(String label) {
		this.plabel = label;
	}



	public GsProduitService getGsProduitService() {
		return gsProduitService;
	}



	public void setGsProduitService(GsProduitService gsProduitService) {
		this.gsProduitService = gsProduitService;
	}



	public String getPlabel() {
		return plabel;
	}



	public void setPlabel(String plabel) {
		this.plabel = plabel;
	}



	public List<String> getListlabels() {
		return listlabels;
	}



	public void setListlabels(List<String> listlabels) {
		this.listlabels = listlabels;
	}

	public Long getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}



}
