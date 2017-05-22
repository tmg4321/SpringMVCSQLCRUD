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
<title>Edit Property</title>
</head>
<<body>
	<div class=container>
		<div class="bottom">
			<h1>EDIT PROPERTY INFO</h1>
		</div>
	</div>
<form action="editProperty.do" method="post">
	Address:			<input type="text" name="address" value="${property.address}"/><br>
	Monthly Rent: 	<input type="text" name="rent" value="${property.rent}"/><br>
	Purchase Price: 	<input type="text" name="purchasePrice" value="${property.purchasePrice}"/><br>
	CapRate: <span id="cap"><fmt:formatNumber type="number" maxFractionDigits="2" value="${property.capRate}" /></span><br>
	<input type="hidden" name="addressBeforeEdit" value="${property.address}"/>
	<input class="roundButton"type="submit" value="Save Updated Info"/>
</form>
</body>
</html>