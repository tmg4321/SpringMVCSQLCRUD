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
<h2>Property</h2>
Address: ${property.address} Rent: ${property.rent} 
	Purchase Price: ${property.purchasePrice} Cap Rate: ${property.capRate}
<form action="removeProp.do" method= "post">
	<input type="hidden" name="address" value="${property.address}"/>
	<input type="submit" value="Remove"/>
</form>
<form action="edit.do" method= "get">
	<input type="hidden" name="address" value="${property.address}"/>
	<input type="submit" value="Edit"/>
</form>

</body>
</html>