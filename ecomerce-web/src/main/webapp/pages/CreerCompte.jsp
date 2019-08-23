<%@page import="com.bo.Client"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Creer Compte</title>
</head>
<body style="width: 60%; margin: auto;display: flex;flex-direction: column">
<div >
		<s:url var="indexEN" namespace="/" action = "toregister" >
         	<s:param name = "request_locale" >en</s:param>
      	</s:url>
      	<s:url var="indexFR" namespace="/" action = "toregister" >
         	<s:param name = "request_locale" >fr</s:param>
      	</s:url>
      
       <s:a href="%{indexEN}" >English</s:a>
      <s:a href="%{indexFR}" >France</s:a>
      
      
  </div>
	<div style="display: flex;flex-direction: row">
	<div>
          <h2><s:property value="getText('global.titre')"/></h2>
	</div>
	
	</div>
<div align="center">
        <s:form action="doregister" method="post">
        	<s:textfield name="client.nom" label="%{getText('global.name')}"></s:textfield>  
			<s:textfield name="client.prenom" label="%{getText('global.prename')}"></s:textfield>  
			<s:textfield name="client.email" label="%{getText('global.email')}"></s:textfield>  
            <s:password label="%{getText('global.password')}" name="client.password" />
            <s:password label="%{getText('global.Conpassword')}" name="ConfPw" />         
            <s:submit value="%{getText('global.Creer')}" />
        </s:form>     
             
    </div> 
</body>
</html>