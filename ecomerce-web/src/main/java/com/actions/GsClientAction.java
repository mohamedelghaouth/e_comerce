package com.actions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;

import com.bo.Client;
import com.services.GsClientService;

@ResultPath("/pages/")
public class GsClientAction extends BaseAction implements SessionAware {

	
	private String ConfPw;
	
	
	/**
	 * utilisée pour stocker la liste des produits destinés à afficher dans la
	 * vue
	 */
	private List<Client> listClients;

	/** utilisé pour stocker les données du produit saisies dans la vue */
	private Client client;

	private Map<String, Object> session;

	/** injection du service métier */
	@Autowired
	private GsClientService gsClientService;

	@Action(value = "/", results = { @Result(name = "success", location = "home.jsp") })
	public String AtionParDefaut() {
		// On retoune la page associée à success
				return SUCCESS;
	}
	
	@Action(value = "Logout", results = { @Result(name = "success",type="redirectAction", location = "toLogin"),
			@Result(name = "error", location = "erreur.jsp") })
	public String Logout() {
					session.clear();
					return SUCCESS;
					
		}
	
	@Action(value = "doLogin", results = { @Result(name = "success",type="redirectAction", location = "getAllProducts"),
			@Result(name = "error", location = "erreur.jsp") })
	public String Login() {
		
		HttpServletRequest r=ServletActionContext.getRequest();
		
		String lien="toLogin";
		String msg=gsClientService.ValidLoginClient(client);
		
		if(msg.equals(SUCCESS)) {
			
			client=gsClientService.getClientByMail(client.getEmail());
			
			session.put("client", client);
				// On retoune la page associée à success
					return SUCCESS;
					
		}
		
		else  { 
			r.setAttribute("lien", lien);
			r.setAttribute("msg", msg);
			return ERROR;
			}
	}
	
	@Action(value = "toLogin", results = { @Result(name = "success", location = "home.jsp") })
	public String toLogin() {
		// On retoune la page associée à success
				return SUCCESS;
	}
	
	@Action(value = "toregister", results = { @Result(name = "success", location = "CreerCompte.jsp") })
	public String toregister() {
		// On retoune la page associée à success
				return SUCCESS;
	}
	
	@Action(value = "doregister", results = { @Result(name = "success", location = "home.jsp"),
	@Result(name = "error", location = "erreur.jsp")})
	public String doregister() {
			
		HttpServletRequest r=ServletActionContext.getRequest();
			
		String lien="toregister";
		String msg=gsClientService.ValidReigtrationClient(client, ConfPw);
			if(msg.equals(SUCCESS))
					// On retoune la page associée à success
						return SUCCESS;
			else  { 
				r.setAttribute("lien", lien);
				r.setAttribute("msg", msg);
				return ERROR;
				}
	}
	
	

	@Action(value = "getAllClients", results = { @Result(name = "success", location = "/pages/admin/listClients.jsp") })
	public String getAllClients() {

		// En utiliant le service métier on charge la liste des produit et on la
		// stocke
		// dans l'attribut qui sera lu depuis une vue
		listClients = gsClientService.getAllClients();

		// on redirige vers la vue associé à la clé sucess
		return SUCCESS;

	}

	public List<Client> getListClients() {
		return listClients;
	}

	public void setListClients(List<Client> listClients) {
		this.listClients = listClients;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public GsClientService getGsClientService() {
		return gsClientService;
	}

	public void setGsClientService(GsClientService gsClientService) {
		this.gsClientService = gsClientService;
	}

	public void setSession(Map<String, Object> pSession) {
		session = pSession;

	}

	
	public String getConfPw() {
		return ConfPw;
	}

	public void setConfPw(String confPw) {
		ConfPw = confPw;
	}

	

}
