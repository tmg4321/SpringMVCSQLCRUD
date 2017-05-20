<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of Properties</title>
</head>
<body>
<h2>Properties</h2>
<c:forEach var="property" items="${properties}">
	<form action="viewProperty.do" method="get">
Address: ${property.address} Rent: ${property.rent} 
	Purchase Price: ${property.purchasePrice} Cap Rate: ${property.capRate}
	<input type="hidden" name="address" value="${property.address}"/>
	<input type="submit" value="see more"/><br>
	</form>
</c:forEach>
<form action="add.do" method="get">
	<input type="submit" value="Add Property"/>
</form>
</body>
</html>

<!-- <form name="TrainerMenu" action="TrainerMenu" method="get">

<h1>Benvenuto in LESSON! Scegli l'operazione da effettuare:</h1>
<a href="Page2.jsp" id="CreateCourse" >Creazione Nuovo Corso</a>&nbsp;
<a href="Page3.jsp" id="AuthorizationManager">Gestione Autorizzazioni</a>
<input type="button" value="" name="AuthorizationManager" />
</form> -->