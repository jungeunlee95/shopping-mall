<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<title>Admin main page!</title>   
<!-- Bootstrap core CSS -->
<link
	href="${pageContext.servletContext.contextPath }/assets/bootstrap/css/bootstrap.min.css"
	rel="stylesheet"> 
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath }/assets/css/admin-main.css" rel="stylesheet" type="text/css">   
	
<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>
<link href="/your-path-to-fontawesome/css/all.css" rel="stylesheet">
<script>
$('.a-disabled').click(function () {return false;});
</script>	
</head> 
<body> 
	<!-- Navigation -->
	<c:import url='/WEB-INF/views/includes/navigation.jsp'>
		<c:param name="active" value="admin" /> 
	</c:import>
	<!-- /.Navigation --> 

	<div class="container" style="margin-bottom: 60px;">
		<div class="mail-box">
		
			<c:import url="/WEB-INF/views/includes/inbox-nav.jsp"> </c:import>
			
			<aside class="lg-side">
				<div class="inbox-head">
					<h3>회원 상세</h3>
					<form action="#" class="pull-right position">
						<div class="input-append">
							<input type="text" class="sr-input" placeholder="Search">
							<button class="btn sr-btn" type="button">
								<i class="fa fa-search"></i>
							</button>
						</div>
					</form>
				</div>
				<div class="inbox-body">
					<div class="col-lg-9">

				<div class="row"> 
					<div class="col-md-12" style="border: 0px solid gray"> 
					<br><br><br>
						<!-- Datos del vendedor y titulo del producto --> 
						<h4>회원 이름  : ${user.name }</h4>  
						<hr> 
						<h4>아이디  : ${user.id }</h4>  
						<hr> 
						<h4>핸드폰번호  : ${user.phoneNumber }</h4>  
						<hr> 
						<h4>이메일  : ${user.email }</h4>  
						<hr> 
						<h4>생일  : ${user.birthDate }</h4>  
						<hr>  
						<h4>성별  :  
							<c:choose>
								<c:when test="${user.gender eq 'F' }">
									여자
								</c:when>
								<c:otherwise>  
									남자
								</c:otherwise> 
							</c:choose>  
						</h4> 
						<hr>  
						<h4>포인트 : ${user.point }</h4>  
						<hr> 
						
					</div> 
					<div class="col-xs-9">
					<hr> <hr>
						<ul class="menu-items"> 
						<h3>장바구니 정보</h3> <hr> 
							<hr>    
							<c:forEach items='${cartList }' var='vo' varStatus='status'>
								<div class="product">
									<div class="row"> 
										<div class="col-md-6">
											<a href="${pageContext.servletContext.contextPath }/product/${vo.productNo }">
												<img src="${pageContext.servletContext.contextPath }/assets/${vo.mainImg }"
													style="width: 100px;">
											</a>    
										</div>
										<div class="col-md-6"> 
											<a href="${pageContext.servletContext.contextPath }/product/${vo.productNo }">
												${vo.productName } 
											</a>
											<p class="product-description" style="min-width: 30%;">
											옵션 : ${vo.optionName }</p>
											${vo.quantity } 개
										</div>  
									</div> 
								</div> 
								<hr> 
							</c:forEach> 
						</ul>
					</div>
				</div>   
				</div> 
			</aside>
		</div>
	</div>
	<!-- /.container -->

	<!-- Footer -->
	<c:import url='/WEB-INF/views/includes/footer.jsp' />
	<!-- /.Footer -->
</body>
</html>