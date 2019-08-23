<%@page import="com.bo.Client"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>




<%@ taglib prefix="sjdt" uri="/struts-jquery-datatables-tags"%>

<jsp:include page="menu.jsp" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des Clients</title>
<sj:head jquerytheme="redmond" />

</head>
<body style="width: 60%; margin: auto;display: flex;flex-direction: column">
	
	<div >
		<s:url var="indexEN" namespace="/" action = "getAllClients" >
         	<s:param name = "request_locale" >en</s:param>
      	</s:url>
      	<s:url var="indexFR" namespace="/" action = "getAllClients" >
         	<s:param name = "request_locale" >fr</s:param>
      	</s:url>
      
       <s:a href="%{indexEN}" >English</s:a>
      <s:a href="%{indexFR}" >France</s:a>
      
      
  </div>
	
	<div>
		<h2><s:property value="getText('global.titreLC')"/></h2>
	</div>
	
	<div>
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
			<caption class="ui-widget-header"><s:property value="getText('global.titreLC')"/></caption>
			<thead>
				<tr>
					<th>ID</th>
					<th><s:property value="getText('global.name')"/></th>
					<th><s:property value="getText('global.prename')"/></th>
					<th>Type</th>

				</tr>
			</thead>
			<tbody>
				<s:iterator value="listClients">
					<tr>
						<td>${id}</td>
						<td>${nom}</td>
						<td>${prenom}</td>
						<td>${type}</td>	
					</tr>
				</s:iterator>
			</tbody>
		</sjdt:datatables>

	</div>
</body>
</html>