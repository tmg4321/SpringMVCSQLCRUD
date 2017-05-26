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
		Street Address: <input type="text" name="streetAddress" /><br><br>
		City: <input type="text" name="city" /><br><br>
		State Abbr.(e.g. FL or CO): <input type="text" name="stateAbbreviation" /><br><br>
		Zip Code (5 digits): <input type="number" name="zipCode" /><br><br>
		<input class="roundButton" type="submit" value="Save" />
	</form>

</body>
</html>