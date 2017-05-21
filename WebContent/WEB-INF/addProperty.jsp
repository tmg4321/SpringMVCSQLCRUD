<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="master.css" media="screen">
<title>Add Property</title>
</head>
<body>
<h2>Enter new property's information:</h2>
<form action="addProperty.do" method="post">
	Address:			<input type="text" name="address"/><br>
	Monthly Rent: 	<input type="text" name="rent"/><br>
	Purchase Price: 	<input type="text" name="purchasePrice"/><br>
	CapRate: 		<input type="text" name="capRate"/>
	<input type="submit" value="Add Property"/>
</form>
</body>
</html>