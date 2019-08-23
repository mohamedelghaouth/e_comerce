package com.actions; 

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.bo.Client;
import com.bo.Comentaire;
import com.bo.Produit;
import com.opensymphony.xwork2.ActionContext;
import com.services.GsComentaireService;
import com.services.GsProduitService;
import com.services.impl.FilesUtil;

@ResultPath("/pages/")
public class GsProduitAction extends BaseAction implements ServletContextAware {

	
	private Long idProduit;
	private String comcont;
	public final String local="localelp";
	
	private File file;
	private String fileContentType;
	private String fileFileName;
	private String filesPath;
	private ServletContext context;
	
	/**
	 * utilisée pour stocker la liste des produits destinés à afficher dans la vue
	 */
	private List<Produit> listProduits;

	/** utilisé pour stocker les données du produit saisies dans la vue */
	private Produit produit;

	/** injection du service métier */
	@Autowired
	private GsProduitService gsProduitService; 
	
	
	@Action(value = "toaddProduit", results = { @Result(name = "success", location = "addProduit.jsp"),
			@Result(name = "root", location = "/pages/admin/addProduit.jsp") })
	public String toaddProduit() {

		Client c= (Client)ServletActionContext.getRequest().getSession().getAttribute("client");
		
		if("root".equals(c.getType())) {
			
			return "root";
		}
		else
		return SUCCESS;

	}
	@Action(value = "addCommentaire", results = {
			@Result(name = "success", location = "Produitplusdinf.jsp")})
	public String addCommentaire() {
		produit=gsProduitService.getProduitById(idProduit);
		Comentaire c=new Comentaire();
		System.out.println(comcont);
		c.setContenue(comcont);
		c.setProduits(produit);
		gsProduitService.addComentaire(c); 
	
		return SUCCESS;

	}
	
	
	@Action(value = "toProduitplusdinf", results = { @Result(name = "success", location = "Produitplusdinf.jsp"),
	 })
		public String toProduitplusdinf() {
			produit=gsProduitService.getProduitById(idProduit);


				return SUCCESS;

		}
	
	
	@Action(value = "addProduit", results = { @Result(name = "success", location = "listProducts.jsp") })
	public String addProduit() {
 
		try {
			String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("img");  
            
	        System.out.println("Image Location:" + filePath);//see the server console for actual location  
	        File fileToCreate = new File(filePath,fileFileName);  
	        FileUtils.copyFile(file, fileToCreate);//copying source file to new file  
			produit.setImage(fileFileName);


		} catch (IOException e) {

			e.printStackTrace();
			String lien="toaddProduit";
			String msg="il y a eu error";
			
			ServletActionContext.getRequest().setAttribute("lien", lien);
			ServletActionContext.getRequest().setAttribute("msg", msg);
						return ERROR;
		}
		
		
		
		// On utilise le service métier pour sauvegarder en base de données le produit
		// rempli par les données copiées automatiquement par struts de la vue vers
		// l'objet produit
		gsProduitService.addProduit(produit);
		listProduits=gsProduitService.getAllProducts();

		// On retoune la page associée à success
		return SUCCESS;
		
	}

	@Action(value = "getAllProducts", results = { @Result(name = "success", location = "listProducts.jsp"),
			@Result(name = "root", location = "/pages/admin/listProducts.jsp") })
	public String getAllProducts() {

		// En utiliant le service métier on charge la liste des produit et on la stocke
		// dans l'attribut qui sera lu depuis une vue
		listProduits = gsProduitService.getAllProducts();
		Client c= (Client)ServletActionContext.getRequest().getSession().getAttribute("client");
		
		if("root".equals(c.getType())) {
			
			return "root";
		}
		else
		return SUCCESS;

	}
	@Action(value = "localelp", results = { @Result(name = "success", type="redirectAction", location = "getAllProducts") })
	public String localelp() {

		return SUCCESS;

	}

	public Produit getProduit() {
		return produit;    
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public GsProduitService getGsProduitService() {
		return gsProduitService;
	}

	public void setGsProduitService(GsProduitService gsProduitService) {
		this.gsProduitService = gsProduitService;
	}

	public List<Produit> getListProduits() {
		return listProduits;
	}

	public void setListProduits(List<Produit> listProduits) {
		this.listProduits = listProduits;
	}

	

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
	}

	@Override
	public void setServletContext(ServletContext ctx) {
		this.context=ctx;
	}
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getComcont() {
		return comcont;
	}
	public void setComcont(String comcont) {
		this.comcont = comcont;
	}
	
	
	
	
}
