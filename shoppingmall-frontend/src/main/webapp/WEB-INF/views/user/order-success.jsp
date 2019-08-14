<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Shop Homepage - Start Bootstrap Template</title>
<!-- Bootstrap core CSS -->
<link
	href="${pageContext.servletContext.contextPath }/assets/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link
	href="${pageContext.servletContext.contextPath }/assets/css/shop-login.css"
	rel="stylesheet">
</head>
<body>
	<!-- Navigation -->
	<c:import url='/WEB-INF/views/includes/navigation.jsp'>
		<c:param name="active" value="join" />
	</c:import>
	<!-- /.Navigation --> 

	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<div class="card">
				<c:choose>
					<c:when test="${result == 'true'}"> 
						<div class="card-header text-center">주문 성공</div>
						<div class="card-body">
							주문에 성공하셨습니다! 
							<hr>
						</div> 
					</c:when> 
					<c:otherwise>
						<div class="card-header text-center">주문 성공</div>
						<div class="card-body">
							주문에 성공하셨습니다! 
							<hr>
						</div>
					</c:otherwise>
				</c:choose>
				</div>  
			</div>
		</div> 
	</div>
	<!-- /.container -->

	<!-- Footer -->
	<c:import url='/WEB-INF/views/includes/footer.jsp' />
	<!-- /.Footer -->
</body>
</html>