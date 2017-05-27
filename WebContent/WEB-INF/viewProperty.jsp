<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="reset.css" media="screen" />
<link rel="stylesheet" href="master.css" media="screen">
<link rel="stylesheet" href="propPages.css" media="screen">
<title>View Property</title>
</head>
<body>
	<div class=container>
		<div class="bottom">
			<h1>${property.address}</h1>
		</div>
	</div>
	<div id="pics">
		<p><img src="${picture.picture}" alt="Smiley face" height="42" width="42"/></p>
	</div>
	<div id="rentAndCap">
		<table id="viewProp">
			<tr>
				<td>Rent: $${property.rent}</td>
				<td>Purchase Price: $${property.purchasePrice}</td>
				<td>Cap Rate: <fmt:formatNumber type="number" maxFractionDigits="2" value="${property.capRate.rate}" />%</td>
			</tr>
		</table>
	</div>
	 <div id="notes">
	 	<c:forEach var="line" items="${property.notes}">
	 	<p>${line}</p>
	 	</c:forEach>
	 </div>
<form action="removeProp.do" method= "post">
	<input type="hidden" name="propId" value="${property.id}"/>
	<input class="roundButton" type="submit" value="Remove"/>
</form>
<form action="edit.do" method= "get">
	<input type="hidden" name="propId" value="${property.id}"/>
	<input class="roundButton" type="submit" value="Edit"/>
</form>

</body>
</html>