<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="reset.css" media="screen" />
<link rel="stylesheet" href="master.css" media="screen" />
<link href="https://fonts.googleapis.com/css?family=Oswald"
	rel="stylesheet">
<title>List of Properties</title>
</head>
<body>
	<div id=container>
		<div id="bottom">
			<h1>PROPERTIES</h1>
		</div>
	</div>
	<div id=body>
		<table>
			<thead>
				<tr>
					<th>ADDRESS</th>
					<th>RENT</th>
					<th>PRICE</th>
					<th>CAP RATE</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="property" items="${properties}">
					<tr>
						
						<td>
							<form action="viewProperty.do" method="get">
								<button id="addressButton" type="submit" name="address" value="${property.address}">
								${property.address}</button>
							</form>
						</td>
						<td>${property.rent}</td>
						<td>${property.purchasePrice}</td>
						<td>${property.capRate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="addB">
		<form action="add.do" method="get">
			<input id="addButton" type="submit" value="Add Property" />
		</form>
	</div>
</body>
</html>

<!-- <form name="TrainerMenu" action="TrainerMenu" method="get">

<h1>Benvenuto in LESSON! Scegli l'operazione da effettuare:</h1>
<a href="Page2.jsp" id="CreateCourse" >Creazione Nuovo Corso</a>&nbsp;
<a href="Page3.jsp" id="AuthorizationManager">Gestione Autorizzazioni</a>
<input type="button" value="" name="AuthorizationManager" />
</form> -->
