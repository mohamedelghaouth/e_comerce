package com.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comentaire")
public class Comentaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String contenue;
	
	@ManyToOne
    @JoinColumn(name="Comentaire_Produit_fk")
	private Produit produit;

	public Comentaire() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContenue() {
		return contenue;
	}

	public void setContenue(String contenue) {
		this.contenue = contenue;
	}

	public Produit getProduits() {
		return produit;
	}

	public void setProduits(Produit produits) {
		this.produit = produits;
	}
	
	
}
