<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/mileage-result" class="formPage">

		<h3>Mileage(MPG)</h3><input type="number" name="MPG" step=".01"/>
		<h3>Gallons left in tank</h3><input type="number" name="gallons" step=".01"/>
		<h3>Price of Gas</h3><input type="number" name="price" step=".01"/>
		<h3>Distance Driven Per Year</h3><input type="number" name="distYear" step=".01"/>
		<p><button type="submit" id="resultButton">Get Result</button></p>
	</form>
</body>
</html>