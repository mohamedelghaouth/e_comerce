# e_comerce
 Application e-Commerce basique en y ajoutant les fonctionnalités:<br/>
  a- Gestion des commentaires : Un utilisateur peut ajouter un commentaire textuel sur un produit. 
  ces commentaires s'affiche devant les produits. <br/>
 b- L'application calcule une note  automatiquement (rating automatique) en analysant la polarité des commentaires.
 Ceci sous forme d'une tâche planifiée.<br/>
 c- mise en place de l’internationalisation (Localization, internationalization (i18n)).<br/>

## Architecture 
Ce projet est composé de deux sous modules : <br/>
	ecommerce-Web : contenant les actions et les pages JSP.<br/>
	ecommerce-bll :<br/>
 <pre>
      o	 contient la partie logique : les services ; les classe BO ; la partie DAO<br/>
      o	Ce module à son tour utilise le projet basejee (https://github.com/mohamedelghaouth/basejee )<br/>
 </pre>   

Travaille Fait
==============
•	internationalisation (i18n)<br/>
•	Localisation<br/>
•	Gestion des commentaires<br/>
•	fonctionnalités   basiques<br/>
 <pre>  
        - Gestion du panier<br/>
        - Gestion des produits<br/>
        - Gestion des clients<br/>
    </pre>        
•	rating automatique.   <br/>
•	validation des formulaires.   <br/>
•	envoie du facture par mail au client.<br/>   

Travaille reste à faire
==============
•	améliorer l’interface graphique<br/>



Outils:
==============
Maven, Struts 2, Spring, Hibernate , MySQL

Pour Utiliser on a besoin de:
======================
	l‘API JavaMail-1.4.4 <br/>
	une table contenant les mots en anglais(ou français) pour le traitement des commentaires  <br/>
 

