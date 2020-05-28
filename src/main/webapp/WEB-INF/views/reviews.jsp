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
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="/home">Parties<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/home/vote/${party.id}">Options and Votes</a>
        </li>
    </ul>
  </div>
</nav>

<div class = container>
<h1>Pizza Options for Party: </h1>
<h1><c:out value = "${party.name}" /></h1>
<table class = table>
  <thead>
<tr>
<th>Name</th>
<th>Description</th>
<th>Votes</th>
</tr>
</thead>
<tbody>
<c:forEach var ="partyOption" items="${partyOptionList}">
<c:if test="${partyOption.votes > 0}">
<tr>
<td><c:out value="${partyOption.name}"></c:out></td>
<td><c:out value="${partyOption.description}"></c:out></td>
<td><c:out value="${partyOption.votes}"></c:out></td>
</tr>
</c:if>
</c:forEach>
</tbody>
</table>
</div>