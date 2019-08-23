<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring and Struts Integration Demo</title>
</head>
<body>

<div >
		<s:url var="indexEN" namespace="/" action = "toLogin" >
         	<s:param name = "request_locale" >en</s:param>
      	</s:url>
      	<s:url var="indexFR" namespace="/" action = "toLogin" >
         	<s:param name = "request_locale" >fr</s:param>
      	</s:url>
      
       <s:a href="%{indexEN}" >English</s:a>
      <s:a href="%{indexFR}" >France</s:a>
      
      
  </div>
    <div align="center">
        <!-- <h1>Spring and Struts Integration Demo</h1>-->
          <h2>Users Login</h2>
        <s:form action="doLogin" method="post">
            <s:textfield label="email" name="client.email" />
            <s:password label="Password" name="client.password" />
            <s:submit value="%{getText('global.login')}" />
        </s:form>     
       <a href="toregister"><s:property value="getText('global.creerCompte')"/></a>   
    </div> 
</body>
</html>