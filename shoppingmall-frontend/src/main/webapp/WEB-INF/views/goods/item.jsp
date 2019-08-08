<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</head>

<body>
	<!-- Navigation -->
	<c:import url='/WEB-INF/views/includes/navigation.jsp'>
		<c:param name="active" value="shopping" />
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

			<div class="col-lg-9">

				<div class="row">
					<div class="col-md-6 item-photo">   
						<img style="width: 380px;"    
							src="${pageContext.servletContext.contextPath }/assets/${product.mainImg }" />
					</div>
					<div class="col-md-6" style="border: 0px solid gray"> 
					<br><br><br> 
						<!-- Datos del vendedor y titulo del producto -->
						<h3>${product.name }</h3>

						<!-- Precios -->
						<h6 class="title-price">
							<small>상품가격</small>
						</h6>
						<hr> 
						<h3 style="margin-top: 0px;">
							<img alt="" style="width: 30px; height: 30px;"
								src="data:image/png;base64,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">
							${product.price }
						</h3>
 						<hr>
						<!-- Detalles especificos del producto -->
						<div class="section">
							<h6 class="title-attr" style="margin-top: 15px;">
								<small>배송비</small> : <small>${product.shippingFee }</small><br>
							</h6>  
							<div> 
								<small>50,000이상 주문시 무료배송 ! </small>
							</div> 
						</div>
						<hr>
						<div class="section">
							<h6 class="title-attr" style="margin-top: 15px;">
								<small>옵션</small> 
							</h6>
							<br> 
							<div>
								<select id="password_question" class="form-control" name="passwordQuestion" path="passwordQuestion">
								    <option value="">옵션 선택</option> 
									<c:forEach items='${product.optionNameList }' var='vo' varStatus='status'>
									    <option value="${vo.no }">${vo.productOptionName }</option>
									</c:forEach> 
								</select>  
							</div> 
						</div>
						<br> 
						<div class="section" style="padding-bottom: 20px;">
							<h6 class="title-attr">
								<small>수량</small> 
							</h6>  
							<div>
								<div class="btn-minus">
									<span class="glyphicon glyphicon-minus"></span>
								</div>
								<input value="1" />
								<div class="btn-plus">
									<span class="glyphicon glyphicon-plus"></span>
								</div> 
							</div>
						</div> 

						<hr>
						<!-- Botones de compra -->
						<div class="section" style="padding-bottom: 20px;">
							<button class="btn btn-success">
								<span style="margin-right: 20px"
									class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
								장바구니 담기 
							</button>  
							<hr>
							<button class="btn btn-success">
								<span style="margin-right: 20px"
									class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
								바로 구매하기
							</button>
						</div>
					</div>

					<div class="col-xs-9">
						<ul class="menu-items">
							<li class="active">상품 상세 사진</li>
							<li>주의사항</li>
							<li>리뷰</li>
							<li>Q&A</li>
						</ul>
						<div style="width: 100%; border-top: 1px solid silver">
							<p style="padding: 15px;">
								<small>
									${product.contents } 
								</small>
							</p>
							
						</div>
					</div>
				</div>

			</div>
			<!-- /.col-lg-9 -->

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