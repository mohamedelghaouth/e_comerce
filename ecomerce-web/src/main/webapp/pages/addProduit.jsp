<%@page import="com.bo.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="s" uri="/struts-tags"%>




<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>



<%@ taglib prefix="sjdt" uri="/struts-jquery-datatables-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajout produit</title>
<sj:head jquerytheme="redmond" />

</head>
<body style="display: flex;flex-direction: column">
<div >
		<s:url var="indexEN" namespace="/" action = "toaddProduit" >
         	<s:param name = "request_locale" >en</s:param>
      	</s:url>
      	<s:url var="indexFR" namespace="/" action = "toaddProduit" >
         	<s:param name = "request_locale" >fr</s:param>
      	</s:url>
      
       <s:a href="%{indexEN}" >English</s:a>
      <s:a href="%{indexFR}" >France</s:a>
      
      
  </div>
	<div style="display: flex;flex-direction: row">
	<div>
		<h1><s:property value="getText('global.addprodt1')"/></h1>
		<h2><s:property value="getText('global.addprodt2')"/></h2>	</div>
	<div style="position: absolute;top: 20px;right: 400px ">
		<a href="Logout"><s:property value="getText('global.dec')"/></a>
	</div>
	<div style="position: absolute;top: 20px;right: 100px ">
		<a href="getAllProducts"><s:property value="getText('global.Allprod')"/></a>
	</div>
	</div>
	<div align="center">
		

		<s:form action="addProduit" method="post" enctype="multipart/form-data">

			<div class="type-text">
				<s:textfield label="%{getText('global.name')}" name="produit.nom" />
			</div>
			<div class="type-text">
				<s:textfield label="%{getText('global.prix')}" name="produit.prix" />
			</div>
			<div>
			<s:file label="%{getText('global.image')}" name="file"></s:file>
			</div>
		<sj:submit value="%{getText('global.saveprod')}" />

		</s:form>

	</div>
</body>
</html>