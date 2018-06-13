<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<%--
		<link href="styles.css" rel="stylesheet" />
		--%>
		<meta charset="UTF-8">
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<title>Library Management Screen</title>
	</head>
	<body>
	    <div align="center">
              <c:forEach items="${listshows}" var="show">
                  <tr>
                    <td>${show.getMovie()}</td>

                  </tr>
               	  </c:forEach>

	    </div>
	</body>
</html>