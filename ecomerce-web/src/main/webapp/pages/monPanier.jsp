<%@page import="com.bo.Client"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<%@ taglib uri="http://displaytag.sf.net" prefix="d"%>


<%@ taglib prefix="sjdt" uri="/struts-jquery-datatables-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring and Struts Integration Demo</title>
<sj:head jquerytheme="redmond" />
<link rel="stylesheet" type="text/css" media="screen,projection,print"
	href=<%out.print(request.getContextPath() + "/styles/displaytag.css");%> />

</head>
<body style="width: 60%; margin: auto;display: flex;flex-direction: column">
	<div >
		<s:url var="indexEN" namespace="/" action = "monPanier" >
         	<s:param name = "request_locale" >en</s:param>
      	</s:url>
      	<s:url var="indexFR" namespace="/" action = "monPanier" >
         	<s:param name = "request_locale" >fr</s:param>
      	</s:url>
      
       <s:a href="%{indexEN}" >English</s:a>
      <s:a href="%{indexFR}" >France</s:a>
      
      
  </div>
	<div style="display: flex;flex-direction: row">
	<div>
		<h2><s:property value="getText('global.titre')"/></h2>
	</div>
	<div style="position: absolute;top: 20px;right: 300px ">
		<a href="Logout"><s:property value="getText('global.dec')"/></a>
	</div>
	<div style="position: absolute;top: 20px;right: 100px ">
		<a href="getAllProducts"><s:property value="getText('global.lpback')"/></a>
	</div>
	</div>
	<div id="divdt">

		<d:table name="panier.lignePanierList" export="true"
			requestURI="/monPanier"
			decorator="com.decorators.PanierActionsDecorator" pagesize="20">
			<d:column property="produit.id" title="ID"  />
			<d:column property="produit.nom" title="Nom" sortable="true" />
			<d:column property="quantite" title="Quantite" />
			<d:column property="montant" title="Montant" />

			<%--<d:column property="addToPanierLink" title="Action" media="html" /> --%>
	</d:table>

		<a href="validerPanier"><s:property value="getText('global.valid')"/></a>
	</div>
</body>
</html>