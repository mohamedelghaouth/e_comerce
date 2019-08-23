<%@page import="com.bo.Client"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="s" uri="/struts-tags" %> 
   <% 
		String lien =(String)request.getAttribute("lien");
		String msg =(String)request.getAttribute("msg");
   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring and Struts Integration Demo</title>
</head>
<body style="width: 60%; margin: auto;display: flex;flex-direction: column">
	<div style="display: flex;flex-direction: row">
	
	<div style="position: absolute;top: 20px;right: 200px ">
		<a href="Logout">se deconnecter</a>
	</div>
	</div>
	<p>
		<%out.println(msg);%>
	</p>
	<a href="<%out.println(lien);%>">cliquer pour retourner</a>
</body>
</html>