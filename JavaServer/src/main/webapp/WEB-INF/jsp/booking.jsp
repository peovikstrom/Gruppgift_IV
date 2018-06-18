<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="spring-form"
	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Biograf AB</title>
<link rel="stylesheet" type="text/css" href="/style.css" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<div class="header">
		<h1>Biograf AB</h1>
	</div>
	<div class="container">
		<div class="nav">
			<ul>
				<li><a href="/index">Hemsida</a></li>
				<li><a href="/addMovie">Ny film</a>
				<li><a href="/addShow">Ny Show</a>
			</ul>
		</div>
		<div class="main">
			<div class="movie">
				<div class="poster">
					<img src="${show.getMovie().getUriPoster()}" />
				</div>
				<div class="labelText">
					<div class="label">${show.getMovie().getTitle()}</div>
					<div class="text">${show.getMovie().getDescription()}</div>
					<br />
					<div class="text">${show.getStart()}-${show.getStop()}</div>
				</div>
				<%--
			<form action="addShowPost" method="post">
				<input type="text" name="movieId" placeholder="Movie ID"><br>
				<input type="text" name="TheatreID" placeholder="Theatre ID"><br>
				<input type="text" name="start" placeholder="Show Start"><br>
				<input type="text" name="stop" placeholder="Show End"><br>
				<a href="/index/${show.getId()}">Lägg till show</a>
			</form>
			
			${i}:${j}:${seats[i][j]}
			
			 --%>

				<<-- SEAT BOOKING -->>
				<c:forEach begin="0" end="9" var="i">
					<c:forEach begin="0" end="9" var="j">
					
						<c:choose>
							<c:when test="${seats[i][j] != 0 }">
							X
						</c:when>
							<c:otherwise>
							O
						</c:otherwise>
						</c:choose>
						
					</c:forEach>
					<br>
				</c:forEach>

			</div>
		</div>
</body>

<div class="footer">
	<div>Webmaster: Karl-Gustav, Jesper, Tommy</div>
	<div>Copyright &copy; 2018 Biograf AB</div>
	<div
		style="margin-top: 10px; margin-bottom: 5px; border-bottom: 1px solid white;">Contact
		information</div>
	<div style="padding-right: 5px;">
		Email: <a style="color: white;" href="mailto:info@me.com">info@me.com</a>
	</div>
	<div style="padding-right: 5px;">
		Phone: <a style="color: white;" href="tel:0701234567">070-123 45
			67</a>
	</div>
</div>

</html>