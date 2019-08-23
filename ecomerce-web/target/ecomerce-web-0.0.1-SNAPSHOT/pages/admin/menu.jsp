<%@ taglib prefix="s" uri="/struts-tags"%>
<div style="display: flex;flex-direction: row">
	
	<div style="position: absolute;top: 20px;right: 100px ">
		<a href="Logout"><s:property value="getText('global.dec')"/></a>
		</div>
		<div style="position: absolute;top: 20px;right: 200px ">
		<a href="getAllCategories"> <s:property value="getText('global.getallcat')"/></a>
		</div>
		<div style="position: absolute;top: 20px;right: 350px ">
		
		<a href="toaddCategorie">  <s:property value="getText('global.addcat')"/></a>
		</div>
		<div style="position: absolute;top: 20px;right: 470px ">
		
		<a href="getAllClients"><s:property value="getText('global.Clientlist')"/></a>
		</div>
		<div style="position: absolute;top: 20px;right: 570px ">
		
		<a href="getAllProducts"> <s:property value="getText('global.Allprod')"/></a>
		</div>		
	
	</div>