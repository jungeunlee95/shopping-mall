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
						<div class="card-header text-center">회원가입 성공</div>
						<div class="card-body">
							환영합니다. 회원가입에 성공하셨습니다! 
							<hr>
							<div class="col-md-6 offset-md-4">
								<a href="${pageContext.servletContext.contextPath }/nonuser/login">
									<button class="btn btn-primary">로그인 하러가기</button>
								</a>
							</div> 
						</div> 
					</c:when>
					<c:otherwise>
						<div class="card-header text-center">회원가입 실패</div>
						<div class="card-body">
							죄송합니다. 회원가입에 실패하셨습니다.
							<hr>  
							<div class="col-md-6 offset-md-4">
								<button type="submit" class="btn btn-primary">회원가입 하러가기</button>
							</div> 
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