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
	<div class=container>
		<div class="bottom">
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
						<td><fmt:formatNumber type="number" maxFractionDigits="2" value="${property.capRate}" /> %</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="addB">
		<form action="add.do" method="get">
			<input class="roundButton" type="submit" value="Add Property" />
		</form>
	</div>
</body>
</html>


