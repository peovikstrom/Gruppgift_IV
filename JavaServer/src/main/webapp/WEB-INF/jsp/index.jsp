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
				<c:forEach items="${theatres}" var="theatre">
					<li><a href="/index/${theatre.getId()}">${theatre.getName()}</a></li>
				</c:forEach>
				<li><a href="/addMovie">Ny film</a>
				<li><a href="/addShow">Ny Show</a>
			</ul>
		</div>
		<div class="main">
			
			<c:forEach items="${shows}" var="show">

				<div class="movie">
					<div class="poster">
						<img src="${show.getMovie().getUriPoster()}" />
					</div>
					<div class="labelText">
						<div class="label">${show.getMovie().getTitle()}</div>
						<div class="text">${show.getMovie().getDescription()}</div>
						<br />
						<div class="text">${show.getStart()}- ${show.getStop()}</div>
					</div>
					<div class="book">

						<form action="booking" method="post">
							Antal platser <input type="text" name="seats" value="1"><br>
							<button name="movie" value="${show.getMovie().getId()}">Boka</button>
							<div class="text">Lediga platser: #</div>
							<div class="text">Pris: 120kr</div>
							
						</form>

					</div>
				</div>
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