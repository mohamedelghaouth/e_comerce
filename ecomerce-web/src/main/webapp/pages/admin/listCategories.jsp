<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<%@ taglib uri="http://displaytag.sf.net" prefix="d" %>



<%@ taglib prefix="sjdt" uri="/struts-jquery-datatables-tags"%>

<jsp:include page="menu.jsp" />

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
		<s:url var="indexEN" namespace="/" action = "getAllCategories" >
         	<s:param name = "request_locale" >en</s:param>
      	</s:url>
      	<s:url var="indexFR" namespace="/" action = "getAllCategories" >
         	<s:param name = "request_locale" >fr</s:param>
      	</s:url>
      
       <s:a href="%{indexEN}" >English</s:a>
      <s:a href="%{indexFR}" >France</s:a>
      
      
  </div>
	
	<div>
		<h2>Catalogue</h2>
	</div>
	
	<div id="divdt" >
	<s:iterator value="listCategories">
	<div>
	<h2><s:property value="getText('global.catlabel')"/>: <s:property value="label"/><br/></h2>
	<s:property value="getText('global.quantite')"/>: <s:property value="quantite"/><br/>
	<s:iterator value="produits">
			id : <s:property value="id"/><br/>
			<s:property value="getText('global.name')"/>: <s:property value="nom"/><br/>
			<s:property value="getText('global.prix')"/>: <s:property value="prix"/><br/>
			<s:url action="deleteProdFromCat" var="act">
 			 <s:param name="idProduit"><s:property value="id"/></s:param>
 			 <s:param name="idCategorie"><s:property value="categorie.id"/></s:param>
			</s:url>
			<a href="${act}"><s:property value="getText('global.SupProdcat')"/></a><br/>
	</s:iterator>
	</div>
	</s:iterator>
	</div>
</body>
</html>