<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="s" uri="/struts-tags"%>




<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<jsp:include page="menu.jsp" />

<%@ taglib prefix="sjdt" uri="/struts-jquery-datatables-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajouter Categorie</title>
<sj:head jquerytheme="redmond" />

</head>
<body style="display: flex;flex-direction: column">
	
	<div >
		<s:url var="indexEN" namespace="/" action = "toaddCategorie" >
         	<s:param name = "request_locale" >en</s:param>
      	</s:url>
      	<s:url var="indexFR" namespace="/" action = "toaddCategorie" >
         	<s:param name = "request_locale" >fr</s:param>
      	</s:url>
      
       <s:a href="%{indexEN}" >English</s:a>
      <s:a href="%{indexFR}" >France</s:a>
      
      
  </div>
	
	<div >
		<h1><s:property value="getText('global.titre1')"/></h1>
		<h2><s:property value="getText('global.titreaddCat')"/></h2>

		<s:form action="addCategorie" method="post">

			<div class="type-text">
				<s:textfield label="%{getText('global.catlabel')}" name="categorie.label" />
			</div>
			
			<sj:submit value="%{getText('global.SaveCat')}" />

		</s:form>

	</div>
</body>
</html>