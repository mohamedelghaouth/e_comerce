package com.services.impl;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.bo.Client;
import com.bo.Commande;
import com.bo.Panier;


public class Emailer  {

   private static final String SUCCESS = "success";
private static final String ERROR = "erreur d'envoi d'email";


   static Properties properties = new Properties();
   static {
      properties.put("mail.smtp.host", "smtp.gmail.com");
      properties.put("mail.smtp.socketFactory.port", "465");
      properties.put("mail.smtp.socketFactory.class",
         "javax.net.ssl.SSLSocketFactory");
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.smtp.port", "465");
   }

   public static String execute(Panier panier, Client client){
	   Commande C =new Commande(panier, client);
	   C.setTotal(panier.getTotal());
	   
      String ret = SUCCESS;
      try {
         Session session = Session.getDefaultInstance(properties,  
            new Authenticator() {
               protected PasswordAuthentication 
               getPasswordAuthentication() {
                  return new 
                  PasswordAuthentication("mohamedelghaouth7991@gmail.com", "med36293519");
               }
            }
         );

         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress("mohamedelghaouth7991@gmail.com"));
         message.setRecipients(Message.RecipientType.TO, 
            InternetAddress.parse(C.getClient().getEmail()));
         message.setSubject("validation de la commande");

         String s="";
         s+="Totale du Commande : "+C.getTotal()+"\n";
         s+="Panier: " + "\n" + "nombre d'article:  " +panier.getNbrArticle()+"  "+"Total :"+panier.getTotal()+ "\n";
         s+=panier.getLignePanierList()+"\n";
         s+="Client " + client.getNom()+" "+client.getPrenom()+"   "+client.getEmail()+"\n";
         s+="vous pouvez payer par virement banquaire sur le Compte: 6048511001289187" +"\n";
         s+="merci; on vous attend pour la prochaine fois";
         
         message.setText(s);
         Transport.send(message);
      } catch(Exception e) {
         ret = ERROR;
         e.printStackTrace();
      }
      return ret;
   }

  
}
