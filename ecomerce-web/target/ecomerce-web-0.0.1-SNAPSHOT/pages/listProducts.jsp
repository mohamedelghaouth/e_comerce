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
<title>list produits</title>
<sj:head jquerytheme="redmond" />
<link rel="stylesheet" type="text/css" media="screen,projection,print"
	href=<%out.print(request.getContextPath() + "/styles/displaytag.css");%> />

</head>
<body style="width: 60%; margin: auto;display: flex;flex-direction: column">
	
	<div >
		<s:url var="indexEN" namespace="/" action = "localelp" >
         	<s:param name = "request_locale" >en</s:param>
      	</s:url>
      	<s:url var="indexFR" namespace="/" action = "localelp" >
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
		<a href="toaddProduit">   <s:property value="getText('global.addProduit')"/></a>	
	</div>
	</div>
	<div id="divdt">
		
			<a href="monPanier"> <s:property value="getText('global.Panier')"/></a>
			
			<script type="text/javascript" language="javascript"
			src="http://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js">
			
		</script>
		<script type="text/javascript" language="javascript"
			src="http://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/pdfmake.min.js">
			
		</script>
		<script type="text/javascript" language="javascript"
			src="http://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/vfs_fonts.js">
			
		</script>	
				
			<sjdt:datatables datatablesTheme="jqueryui" buttons="true"
			dom="Blfrtip" lengthMenu="[5,10,15,20]" pageLength="15"
			responsive="true" style="width:100%;">
			<caption class="ui-widget-header"><s:property value="getText('global.titre')"/></caption>
			<thead>
				
			</thead>
			<tbody>
				<s:iterator value="listProduits">
					<tr>
						<td><img alt="photos du produit" src="<%=request.getServletContext().getRealPath("/").concat("img")%>/<s:property value="image"/>" width="200" height="100"/></td>
						<td>
							id : ${id}<br/>
							<s:property value="getText('global.name')"/>: <s:property value="nom"/><br/>
							<s:property value="getText('global.prix')"/>: <s:property value="prix"/><br/>
							<s:property value="getText('global.snote')"/>: <s:property value="snote"/><br/>
							<s:property value="getText('global.cat')"/>: <s:property value="categorie.label"/><br/>
							<a href="addProduitToPanier?idProduit=${id}"><s:property value="getText('global.addtopan')"/></a><br/>
							<a href="toProduitplusdinf?idProduit=${id}"><s:property value="getText('global.plusdinf')"/></a>		
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</sjdt:datatables>
			
	</div>
</body>
</html>