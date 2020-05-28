<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<title>Parties</title>
</head>


<body>
<div class = container>
<h1>Parties</h1>
<table class = table>
  <thead>
<tr>
<th>Name</th>
<th>Date</th>
<th></th>
<th></th>
</tr>
</thead>
<tbody>
<c:forEach var ="party" items="${partyList}">
<tr>
<td><c:out value="${party.name}"></c:out></td>
<td><c:out value="${party.date}"></c:out></td>
<td>  <a class="btn" href="/home/vote/${party.id}">Voting</a></td>
<td>  <a class="btn" href="/home/review/${party.id}">Review</a></td>
</tr>
</c:forEach>
</tbody>
</table>






</div>
</body>
</html>