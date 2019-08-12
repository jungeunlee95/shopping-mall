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
	href="${pageContext.servletContext.contextPath }/assets/css/shop-order.css" 
	rel="stylesheet">   
<!------ Include the above in your HEAD tag ----------> 
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
</head>
<sec:authorize access="isAuthenticated()"> 
	<sec:authentication property="principal.no" var="userNo"/>
</sec:authorize> 
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

				<!-- Nav pills -->
				<ul class="nav nav-pills justify-content-center nav-justified"
					role="tablist" style="padding-left: 30px;"> 
					<li class="nav-item"><a
						class="nav-link active btn btn-primary" data-toggle="pill"
						href="#organizer-details">주문 정보 입력</a></li>
					<li class="nav-item"><a class="nav-link btn btn-primary"
						data-toggle="pill" href="#event-details">결제</a></li>
					<li class="nav-item"><a class="nav-link btn btn-primary"
						data-toggle="pill" href="#confirm-details">주문완료</a></li>
				</ul>
				<div class="connected-line"></div>
				<br> 
				 
				<h4 class="order-title">주문 상품 목록</h4>   
				<div class="column-labels"> 
					<label class="product-image">Image</label> 
					<label class="product-details">상품</label> 
					<label class="product-price">가격</label> 
					<label class="product-quantity">수량</label>  
					<label class="product-removal">배송비</label>   
					<label class="product-line-price">합계 금액</label> 
				</div> 
				<c:forEach items='${cartList }' var='vo' varStatus='status'> 
					<div class="product">
						<div class="product-image">
						<a href="${pageContext.servletContext.contextPath }/product/${vo.productNo }">
							<img src="${pageContext.servletContext.contextPath }/assets/${vo.mainImg }">
						</a>
						</div>
						<div class="product-details">
							<div class="product-title">
								<a href="${pageContext.servletContext.contextPath }/product/${vo.productNo }">
									${vo.productName } 
								</a>
							</div>
							<p class="product-description" style="min-width: 30%;">
							옵션 : ${vo.optionName }</p>
						</div> 
						<div class="product-price">${vo.price }원</div>   
						<div class="product-quantity">${vo.quantity }</div>  
						<div class="product-removal">${vo.shippingFee }</div>  
						<div class="product-line-price total_price" >${vo.sumPrice }</div>
					</div> 
				</c:forEach>  
				<small class="modify-des">상품의 옵션 및 수량 변경은 상품상세 또는 장바구니에서 가능합니다.</small>
				<br><br><hr>   
				
				<div class="container-fluid">
					<div class="row"> 
						<div class="col-sm-12">
							<div class="pos-rel">  
								<!-- Tab panes -->
								<div class="tab-content">
									<div id="organizer-details" class="container tab-pane active">
										<form class="seminor-login-form">
										 
											<!-- 주문자 정보 입력 -->  
											<h4>주문자 정보 입력</h4>
											<table class="table" style="width:100%;"> 
											  <thead>  
											    <tr> 
											    </tr> 
											  </thead>
											  <tbody>
											    <tr>
											      <th scope="row">주문자 이름</th> 
											      <td><input type="text" class="form-control" required autocomplete="off"> </td> 
											    </tr> 
											    <tr>
											      <th scope="row">주소</th>
											      <td> 
											      	<input type="text" id="postcode" class="mini form-control" placeholder="우편번호" readonly="readonly">
										        
											        <input type="button" onclick="execDaumPostcode()" value="우편번호 찾기" class="d_btn" readonly="readonly"><br>
											        
											        <input type="text" id="roadAddress" class="std form-control" placeholder="도로명주소" readonly="readonly" > 
											       
											        <input type="text" id="jibunAddress" class="std form-control" placeholder="지번주소" readonly="readonly">
											        
											        <span id="guide" style="color:#999;display:none"></span> 
											        
											        <input type="text" id="extraAddress" class="form-control" placeholder="참고항목" readonly="readonly">
											       
											        <input type="text" id="detailAddress" class="form-control" placeholder="상세주소"> 
											      </td> 
											    </tr> 
											    <tr>
											      <th scope="row">전화</th>
											      <td> 
													<select id="txtMobile1">
														<option value="">::선택::</option>
														<option value="011">011</option>
														<option value="016">016</option>
														<option value="017">017</option>
														<option value="019">019</option>
														<option value="010">010</option>
													</select> -
													<input type="text" id="txtMobile2" size="4" onkeypress="onlyNumber();" /> -  
													<input type="text" id="txtMobile3" size="4" /> 
												  </td>   
											    </tr> 
											    <tr> 
											      <th scope="row">이메일</th> 
											      <td>
											      	<input type="text" class="form-control" required autocomplete="off"> 
											      	<small class="modify-des">- 이메일을 통해 주문처리과정을 보내드립니다.</small> <br> 
													<small class="modify-des">- 이메일 주소란에는 반드시 수신가능한 이메일주소를 입력해 주세요</small> 
											      </td>  
											      
											    </tr>    
											  </tbody>
											</table> 
											<hr> 
											<!-- 배송 정보 입력 -->
											<h4>배송 정보 입력</h4>
											<table class="table" style="width:100%;"> 
											  <thead>  
											    <tr> 
											    </tr> 
											  </thead>
											  <tbody> 
											    <tr>
											      <th scope="row">주문자 이름</th> 
											      <td><input type="text" class="form-control" required autocomplete="off"> </td> 
											    </tr> 
											    <tr>
											      <th scope="row">주소</th>
											      <td> 
											      	<input type="text" id="postcode" class="mini form-control" placeholder="우편번호" readonly="readonly">
										        
											        <input type="button" onclick="execDaumPostcode()" value="우편번호 찾기" class="d_btn" readonly="readonly"><br>
											        
											        <input type="text" id="roadAddress" class="std form-control" placeholder="도로명주소" readonly="readonly" > 
											       
											        <input type="text" id="jibunAddress" class="std form-control" placeholder="지번주소" readonly="readonly">
											        
											        <span id="guide" style="color:#999;display:none"></span> 
											        
											        <input type="text" id="extraAddress" class="form-control" placeholder="참고항목" readonly="readonly">
											       
											        <input type="text" id="detailAddress" class="form-control" placeholder="상세주소"> 
											      </td> 
											    </tr> 
											    <tr>
											      <th scope="row">전화</th>
											      <td> 
													<select id="txtMobile1">
														<option value="">::선택::</option>
														<option value="011">011</option>
														<option value="016">016</option>
														<option value="017">017</option>
														<option value="019">019</option>
														<option value="010">010</option>
													</select> -
													<input type="text" id="txtMobile2" size="4" onkeypress="onlyNumber();" /> -  
													<input type="text" id="txtMobile3" size="4" /> 
												  </td>   
											    </tr> 
											    <tr> 
											      <th scope="row">배송메세지</th> 
											      <td>
											      	<textarea class="form-control" required autocomplete="off" placeholder="배송메세지를 입력해주세요." id="shipping_message"></textarea>  
											      </td>     
											    </tr>    
											  </tbody>
											</table> 
											
											<br><br> 
											<div class="form-group">
												<label class="container-checkbox"> 약관 동의 1 <input
													type="checkbox" checked="checked" required> <span 
													class="checkmark-box"></span>
												</label>
												<textarea rows="" cols="" readonly="readonly" style="width:100%;">약관내용</textarea> 
											</div>
											<div class="form-group">
												<label class="container-checkbox"> 약관 동의 2 <input type="checkbox"
													checked="checked" required> <span
													class="checkmark-box"></span> 
												</label>
												<textarea rows="" cols="" readonly="readonly" style="width:100%;">약관내용</textarea> 
											</div>
											<br><br><br> 
											<div class="totals">
												<div class="totals-item">
													<label>상품 총 금액</label> <input type="text"
														class="totals-value" style="width: 104px;"
														id="total_price_sum" value="0" readonly /> 
												</div>
												<div class="totals-item">
													<label>배송비 <br> <small style="color: red;">50,000원
															이상 무료배송 !</small>
													</label> <input type="text" class="totals-value"
														style="width: 104px;" id="shopping_fee"
														value="${cartList[0].shippingFee }" readonly />
												</div>
												<div class="totals-item totals-item-total"> 
													<label>총 결제 금액</label> <input type="text"
														class="totals-value" style="width: 104px;"
														id="final_price" value="0" readonly />
												</div>
											</div>  


											<div class="btn-check-log">
												<button type="submit" class="btn-check-login">결제하기</button>
											</div>
										</form>
									</div>
									<div id="confirm-details" class="container tab-pane fade">
										<br>
										<h3>Menu 2</h3>
										<p>Sed ut perspiciatis unde omnis iste natus error sit
											voluptatem accusantium doloremque laudantium, totam rem 
											aperiam.</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

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
	     
	    var sFee = $("#shopping_fee").val();
	    if($("#shopping_fee").val()==''){
	    	sFee = 0;  
	    	$("#shopping_fee").val("0");  
	    }  
	    var finalPrice =  parseFloat(sum)+ parseFloat(sFee);
	    
	    $("#final_price").val(finalPrice);  
	    
	    // 상품 삭제
	    $('.remove-product').click(function(){
	    	if(!confirm("정말 삭제하시겠습니까?")){ 
	    		return;
	    	}
	    	var cartNo = $(this).attr("cart-no"); 
	    	
			if(cartNo == ''){
				return; 
			} 
			 
			
			$.ajax({
				url : "${pageContext.servletContext.contextPath }/nonuser/api/cart/" + cartNo,
				type : "delete",
				dataType : "json",
				data : "",
				success: function(response){
					console.log(response.data); 
					if(response.data ==true){ 
						alert("삭제되었습니다.");   
						window.location.reload();  
					}else{
						alert("오류가 발생했습니다. 다시 시도해주세요");  												
					}
				}, 
				error : function(xhr, error){ 
					console.error("error : " + error);
				}
			}); 
		});
	    
	    
	}); 
	
	// 전화번호 Valid
	// 1. 숫자만 입력받게 하는 방법
	function onlyNumber() {
		if ((event.keyCode < 48)
				|| (event.keyCode > 57))
			event.returnValue = false;
	}

	function CheckForm() {
		if (document
				.getElementById("txtMobile1").value == "") {
			window
					.alert("휴대폰 번호를 선택하시오.");
			return false;
		}
		if (document
				.getElementById("txtMobile2").value.length != 4) {
			window
					.alert("가운데 번호는 4자리로 입력하세요");
		}
	} 
														
														
	/* 다음 주소 api */
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 추가 정보 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                } 

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("roadAddress").value = roadAddr;
                document.getElementById("jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            } 
        }).open();
    }
</script>   
</html>