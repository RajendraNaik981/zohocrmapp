<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Lead</title>
</head>
<body>
<h1>Create New Lead</h1>
<form action="post" method="post">
	<pre>
			First Name<input type="text" name="firstName"/>
			Last Name<input type="text" name="lastName"/>
			Email<input type="text" name="email"/>
			Mobile <input type="text" name="mobile"/>
			Source : 
				<select name="source" >
				  <option value="radio">Radio</option>
				  <option value="NewsPaper">NewsPaper</option>
				  <option value="Concert">Show/Movie</option>
				  <option value="Social Media">Social Media</option>
				</select>
			<input type="submit" value="save"/>
	</pre>
</form>
</body>
</html>