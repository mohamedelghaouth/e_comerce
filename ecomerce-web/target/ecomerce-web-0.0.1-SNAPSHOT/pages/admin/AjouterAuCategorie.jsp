
<%@page import="com.bo.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<%@ taglib uri="http://displaytag.sf.net" prefix="d"%>

<jsp:include page="menu.jsp" />

<%@ taglib prefix="sjdt" uri="/struts-jquery-datatables-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>affecter categorie</title>
</head>
<body style="width: 60%; margin: auto;display: flex;flex-direction: column">
	
	<div >
		<s:url var="indexEN" namespace="/" action = "toaffectercategorie" >
         	<s:param name = "request_locale" >en</s:param>
         	<s:param name = "idProduit" ><s:property value="produit.id"/></s:param>
      	</s:url>
      	<s:url var="indexFR" namespace="/" action = "toaffectercategorie" >
         	<s:param name = "request_locale" >fr</s:param>
         	         	<s:param name = "idProduit" ><s:property value="produit.id"/></s:param>
      	</s:url>
      
       <s:a href="%{indexEN}" >English</s:a>
      <s:a href="%{indexFR}" >France</s:a>
      
      
  </div>
	
	
	<div>
          <h2><s:property value="getText('global.titreaddtoCat')"/></h2>
	</div>
<div style="display: flex;flex-direction: row">
<div>
<img alt="photos du produit" src="<%=request.getServletContext().getRealPath("/").concat("img")%>/<s:property value="produit.image"/>" width="200" height="100"/>
</div>
<div>
	<p>
		id: <s:property value="produit.id"/><br/>
		
		<s:property value="getText('global.name')"/>: <s:property value="produit.nom"/><br/>
		<s:property value="getText('global.prix')"/>: <s:property value="produit.prix"/><br/>
		<s:property value="getText('global.cat')"/>: <s:property value="produit.categorie.label"/><br/>
	</p>
</div>
</div>
<s:url action="affectercategorie" var="act">
  <s:param name="idProduit"><s:property value="produit.id"/></s:param>
</s:url>
<s:form action="%{act}" method="post">
<s:radio list="listlabels" name="plabel" label="categories"></s:radio>
<sj:submit value="%{getText('global.affectcat')}" />
</s:form>
</body>
</html>