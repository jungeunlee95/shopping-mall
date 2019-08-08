<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
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
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!-- Custom styles for this template -->   
<link
	href="${pageContext.servletContext.contextPath }/assets/css/shop-item.css"
	rel="stylesheet"> 
<!------ Include the above in your HEAD tag ----------> 
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
	
</head>
<sec:authentication property="principal.no" var="userNo"/>
<body>
	<!-- Navigation -->
	<c:import url='/WEB-INF/views/includes/navigation.jsp'>
		<c:param name="active" value="cart" />
	</c:import>
	<!-- /.Navigation -->

	<!-- Page Content -->
	<div class="container">

		<div class="row">
			<div class="col-lg-3"> 
				<h1 class="my-4">JEMall</h1>  
				<div class="list-group">
					<c:forEach items='${categoryList }' var='vo' varStatus='status'>
						<c:choose>
							<c:when test="${vo.depth == 1 }"> 
								<a href="#" class="list-group-item">${vo.name }</a>
							</c:when>
							<c:otherwise>
								<a href="#" class="list-group-item">
								<img style="width: 20px; height: 20px;" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQAlvidkOcAC0HIFOB9vrrixTdq4GrJ2EtskdHJ9vw7qfKez8Eq2g">
									${vo.name }
								</a> 
							</c:otherwise> 
						</c:choose>
					</c:forEach> 
				</div>
			</div>
			<!-- /.col-lg-3 -->
 
			<div class="card">
				<div class="card-header bg-dark text-light">
					<i class="fa fa-shopping-cart" aria-hidden="true"></i> 장바구니 목록 
					<a href="" class="btn btn-outline-info btn-sm pull-right">새로고침</a>
					<div class="clearfix"></div>
				</div>
				<div class="card-body">

					<div class="row"> 
						<div class="col-xs-2 col-md-2">
							<img class="img-responsive" style="width: 110px; height: 80px;" 
								src="https://static.thenounproject.com/png/340719-200.png" alt="prewiew">
						</div>
						<div class="col-xs-4 col-md-6">
							<h4 class="product-name">
								<strong>Product name</strong>
							</h4>
							<h4>
								<small>Product description</small>
							</h4>
						</div>
						<div class="col-xs-6 col-md-4 row">
							<div class="col-xs-6 col-md-6 text-right"
								style="padding-top: 5px">
								<h6>
									<strong>25.00 <span class="text-muted">x</span></strong>
								</h6>
							</div>
							<div class="col-xs-4 col-md-4">
								<input type="text" class="form-control input-sm" value="1">
							</div>
							<div class="col-xs-2 col-md-2">
								<button type="button" class="btn btn-outline-danger btn-xs">
									<i class="fa fa-trash" aria-hidden="true"></i>
								</button>
							</div>
						</div>
					</div>
					<hr>
					<div class="row">
						<div class="col-xs-2 col-md-2">
							<img class="img-responsive" src="http://placehold.it/120x80"
								alt="prewiew">
						</div>
						<div class="col-xs-4 col-md-6">
							<h4 class="product-name">
								<strong>Product name</strong>
							</h4>
							<h4>
								<small>Product description</small>
							</h4>
						</div>
						<div class="col-xs-6 col-md-4 row">
							<div class="col-xs-6 col-md-6 text-right"
								style="padding-top: 5px">
								<h6>
									<strong>25.00 <span class="text-muted">x</span></strong>
								</h6>
							</div>
							<div class="col-xs-4 col-md-4"> 
								<input type="text" class="form-control input-sm" value="1">
							</div>
							<div class="col-xs-2 col-md-2">
								<button type="button" class="btn btn-outline-danger btn-xs">
									<i class="fa fa-trash" aria-hidden="true"></i>
								</button>
							</div>
						</div>
					</div>

					<hr> 
					<div class="pull-right">
						<a href="{{route("
							product.home")}}" class="btn btn-outline-secondary pull-right">Aktualizovať
							košík</a>
					</div> 
				</div> 
				<div class="card-footer">
					<a href="{{route("
						product.home")}}" class="btn btn-success pull-right">Objednať</a>
					<div class="pull-right" style="margin: 5px">
						Celková cena: <b>50.00€</b>
					</div>
				</div>
			</div>
			<!-- row  -->

		</div>

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<c:import url='/WEB-INF/views/includes/footer.jsp' />
	<!-- /.Footer -->
</body>
<script type="text/javascript">
	$(document).ready(function() {
		//-- Click on detail
		$("ul.menu-items > li").on("click", function() {
			$("ul.menu-items > li").removeClass("active");
			$(this).addClass("active");
		})

		$(".attr,.attr2").on("click", function() {
			var clase = $(this).attr("class");

			$("." + clase).removeClass("active");
			$(this).addClass("active");
		})

		//-- Click on QUANTITY
		$(".btn-minus").on("click", function() {
			var now = $(".section > div > input").val();
			if ($.isNumeric(now)) {
				if (parseInt(now) - 1 > 0) {
					now--;
				}
				$(".section > div > input").val(now);
			} else {
				$(".section > div > input").val("1");
			}
		})
		$(".btn-plus").on("click", function() {
			var now = $(".section > div > input").val();
			if ($.isNumeric(now)) {
				$(".section > div > input").val(parseInt(now) + 1);
			} else {
				$(".section > div > input").val("1");
			}
		})
	})
</script>
</html>