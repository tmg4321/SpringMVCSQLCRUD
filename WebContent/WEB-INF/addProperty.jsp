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
<title>Add Property</title>
</head>
<body>
	<div class=container>
		<div class="bottom">
			<h1>ENTER PROPERTY INFO</h1>
		</div>
	</div>
	
	<form action="addProp.do" method="post">
		Address: <input type="text" name="address" /><br><br>
		Monthly Rent: <input type="text" name="rent" /><br><br>
		Purchase Price: <input type="text" name="purchasePrice" /><br><br>
		<input class="roundButton" type="submit" value="Save" />
	</form>

</body>
</html>