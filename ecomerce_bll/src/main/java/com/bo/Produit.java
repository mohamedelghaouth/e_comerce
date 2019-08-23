package com.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Produit")
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Produit_Id")
	private Long id;

	private String nom;

	private double prix;
	
	private double note=0;
	
	private String snote="medium";
	
	private String image;
	
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="categorie_Produit_fk")
	private Categorie categorie;

	@OneToMany(mappedBy = "produit",fetch=FetchType.EAGER)
	private List<Comentaire> commentaires=new ArrayList<Comentaire>();

	public void addComentaire(Comentaire p) {
		commentaires.add(p);
		p.setProduits(this);
	}
	public void removeComentaire(Comentaire p) {
		commentaires.remove(p);
		p.setProduits(null);
	}
	
	
	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + ", image=" + image + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<Comentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Comentaire> commentaires) {
		this.commentaires = commentaires;
	}
	public double getNote() {
		return note;
	}
	public void setNote(double note) {
		this.note = note;
	}
	public String getSnote() {
		return snote;
	}
	public void setSnote(String snote) {
		this.snote = snote;
	}


	
	
}
