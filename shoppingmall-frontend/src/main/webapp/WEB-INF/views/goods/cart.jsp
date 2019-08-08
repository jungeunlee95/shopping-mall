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
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>   
<!-- Custom styles for this template -->   
<link
	href="${pageContext.servletContext.contextPath }/assets/css/shop-cart.css"
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
 			<br><br><br><br><br> 
			<div class="shopping-cart" style="width: 75%;padding-bottom: 50px;">      
				<h3>장바구니 목록</h3>  
				<div class="column-labels"> 
					<label class="product-image">Image</label> <label 
						class="product-details">Product</label> <label
						class="product-price">Price</label> <label
						class="product-quantity">Quantity</label> <label
						class="product-removal">Remove</label> <label
						class="product-line-price">Total</label>
				</div>
				
				<c:forEach items='${cartList }' var='vo' varStatus='status'>
					<div class="product">
						<div class="product-image">
							<img src="${pageContext.servletContext.contextPath }/assets/${vo.mainImg }">
						</div>
						<div class="product-details">
							<div class="product-title">${vo.productName }</div>
							<p class="product-description" style="min-width: 30%;">
							옵션 : ${vo.optionName }</p>
						</div> 
						<div class="product-price">${vo.price }원</div> 
						<div class="product-quantity">
							<input type="number" value="${vo.quantity }" min="1"> 
						</div>  
						<div class="product-removal">
							<button class="remove-product">Remove</button>
						</div>  
						<div class="product-line-price total_price" >${vo.sumPrice }</div>
					</div>
				</c:forEach>
 
				<div class="totals">   
					<div class="totals-item"> 
						<label>상품 총 금액</label> 
						<input type="text" class="totals-value" style="width: 104px;" 
						id="total_price_sum" value="error" readonly /> 
					</div>   
					<div class="totals-item">
						<label>배송비</label> 
						<input type="text" class="totals-value" style="width: 104px;" 
						id="shopping_fee" value="error" readonly />  
					</div> 
					<div class="totals-item totals-item-total">
						<label>Grand Total</label>
						<input type="text" class="totals-value" style="width: 104px;" 
						id="final_price" value="error" readonly />   
					</div>
				</div>

				<button class="checkout">주문하기</button>
				<br>
				<br>
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
		 
		// 상품 총 합
		var sum = 0;
		$('.total_price').each(function(){   
		    sum += parseFloat($(this).text());
		});   
		
	    $("#total_price_sum").val(sum); 
	    
	    if(sum>=50000){
		    $("#shopping_fee").val("0");
	    } 
	     
	    var finalPrice = parseFloat($("#total_price_sum").val())+parseFloat($("#shopping_fee").val());
	    
	    $("#final_price").val(finalPrice);  
	    
	});
	   
</script>  
</html>