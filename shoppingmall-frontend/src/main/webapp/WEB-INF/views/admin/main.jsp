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
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>  
<script> 

$(document).ready(function() {
	$('.a-disabled').click(function () {return false;});
}); 
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
					<h3>관리자 페이지</h3>
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
				<h3>최근 알림 리스트</h3> <small style="color:red;">(구현된 기능 X 임시데이터 담겨있음)</small>
				<hr>
					<div class="mail-option">
						<div class="chk-all">
							<input type="checkbox" class="mail-checkbox mail-group-checkbox">
							<div class="btn-group">
								<a data-toggle="dropdown" href="#" class="btn mini all"
									aria-expanded="false"> All <i class="fa fa-angle-down "></i>
								</a>
								<ul class="dropdown-menu">
									<li><a href="#"> None</a></li>
									<li><a href="#"> Read</a></li>
									<li><a href="#"> Unread</a></li>
								</ul>
							</div>
						</div>

						<div class="btn-group">
							<a data-original-title="Refresh" data-placement="top"
								data-toggle="dropdown" href="#" class="btn mini tooltips"> <i
								class=" fa fa-refresh"></i>
							</a>
						</div>
						<div class="btn-group hidden-phone">
							<a data-toggle="dropdown" href="#" class="btn mini blue"
								aria-expanded="false"> More <i class="fa fa-angle-down "></i>
							</a>
							<ul class="dropdown-menu">
								<li><a href="#"><i class="fa fa-pencil"></i> Mark as
										Read</a></li>
								<li><a href="#"><i class="fa fa-ban"></i> Spam</a></li>
								<li class="divider"></li>
								<li><a href="#"><i class="fa fa-trash-o"></i> Delete</a></li>
							</ul>
						</div>
						<div class="btn-group">
							<a data-toggle="dropdown" href="#" class="btn mini blue">
								Move to <i class="fa fa-angle-down "></i>
							</a>
							<ul class="dropdown-menu">
								<li><a href="#"><i class="fa fa-pencil"></i> Mark as
										Read</a></li>
								<li><a href="#"><i class="fa fa-ban"></i> Spam</a></li>
								<li class="divider"></li>
								<li><a href="#"><i class="fa fa-trash-o"></i> Delete</a></li>
							</ul>
						</div>

						<ul class="unstyled inbox-pagination">
							<li><a class="np-btn" href="#"><i
									class="fa fa-angle-left  pagination-left"></i></a></li>
							<li class="page-item active"><a class="page-link" href="#">1</a></li>
							<li class="page-item"><a class="page-link" href="#">2</a></li>
							<li class="page-item"><a class="page-link" href="#">3</a></li>
							<li><a class="np-btn" href="#"><i
									class="fa fa-angle-right pagination-right"></i></a></li> 
						</ul>
					</div>
					<table class="table table-inbox table-hover">
						<tbody>
							<tr class="unread">
								<td class="inbox-small-cells"><input type="checkbox"
									class="mail-checkbox"></td>
								<td class="inbox-small-cells"><i class="fa fa-star"></i></td>
								<td class="view-message  dont-show">장바구니</td>
								<td class="view-message ">OO회원님이 장바구니에 담으셨습니다.</td> 
								<td class="view-message  inbox-small-cells"> </td>
								<td class="view-message  text-right">9:27 AM</td> 
							</tr>
							<tr class="unread">
								<td class="inbox-small-cells"><input type="checkbox"
									class="mail-checkbox"></td>
								<td class="inbox-small-cells"><i class="fa fa-star"></i></td>
								<td class="view-message dont-show">주문</td>
								<td class="view-message">OO회원님이 주문을 하셨습니다.</td>
								<td class="view-message inbox-small-cells"></td>
								<td class="view-message text-right">March 15</td>
							</tr>
							<tr class="">
								<td class="inbox-small-cells"><input type="checkbox"
									class="mail-checkbox"></td>
								<td class="inbox-small-cells"><i class="fa fa-star"></i></td>
								<td class="view-message dont-show">Q&A</td>
								<td class="view-message">OO회원님이 OO문의 글을 남기셨습니다.</td> 
								<td class="view-message inbox-small-cells"></td>
								<td class="view-message text-right">March 15</td> 
							</tr>
							<tr class="">
								<td class="inbox-small-cells"><input type="checkbox"
									class="mail-checkbox"></td>
								<td class="inbox-small-cells"><i class="fa fa-star"></i></td>
								<td class="view-message dont-show">재고</td> 
								<td class="view-message">OO상품 재고가 부족합니다.</td> 
								<td class="view-message inbox-small-cells"></td>
								<td class="view-message text-right">April 01</td>
							</tr>
							<tr class="">
								<td class="inbox-small-cells"><input type="checkbox"
									class="mail-checkbox"></td>
								<td class="inbox-small-cells"><i
									class="fa fa-star inbox-started"></i></td>
								<td class="view-message dont-show">환불&교환<span
									class="label label-danger pull-right" style="color:red;">환불</span></td>
								<td class="view-message">OO회원님이 요청하셨습니다.</td>
								<td class="view-message inbox-small-cells"> 
									<small>처리상태 :
									<img alt="" style="width: 22px;height: 22px;" 
										src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Yes_Check_Circle.svg/1024px-Yes_Check_Circle.svg.png"> 
									</small>
								</td>
								<td class="view-message text-right">May 23</td> 
							</tr>
							<tr class="">
								<td class="inbox-small-cells"><input type="checkbox"
									class="mail-checkbox"></td> 
								<td class="inbox-small-cells"><i
									class="fa fa-star inbox-started"></i></td>
								<td class="view-message dont-show">환불&교환<span
									class="label label-danger pull-right" style="color:red;">교환</span></td>
								<td class="view-message">OO회원님이 요청하셨습니다.</td>
								<td class="view-message inbox-small-cells">
									<small>처리상태 :
										<img alt="" style="width: 22px;height: 22px;" 
											src="data:image/png;base64,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"> 
									</small>
								</td>
								<td class="view-message text-right">May 23</td> 
							</tr>
							<tr class="">
								<td class="inbox-small-cells"><input type="checkbox"
									class="mail-checkbox"></td>
								<td class="inbox-small-cells"><i class="fa fa-star"></i></td>
								<td class="view-message dont-show">주문</td>
								<td class="view-message">OO회원님이 주문을 하셨습니다.</td>
								<td class="view-message inbox-small-cells"></td>
								<td class="view-message text-right">March 13</td>
							</tr>
							<tr class="">
								<td class="inbox-small-cells"><input type="checkbox"
									class="mail-checkbox"></td>
								<td class="inbox-small-cells"><i class="fa fa-star"></i></td>
								<td class="view-message dont-show">장바구니</td>
								<td class="view-message">OO회원님이 장바구니에 담으셨습니다.</td>
								<td class="view-message inbox-small-cells"></td>
								<td class="view-message text-right">March 13</td>
							</tr>
							<tr class="">
								<td class="inbox-small-cells"><input type="checkbox"
									class="mail-checkbox"></td>
								<td class="inbox-small-cells"><i class="fa fa-star"></i></td>
								<td class="view-message dont-show">Q&A</td>
								<td class="view-message">OO회원님이 OO문의 글을 남기셨습니다.</td> 
								<td class="view-message inbox-small-cells"></td>
								<td class="view-message text-right">March 15</td> 
							</tr>
							<tr class="">
								<td class="inbox-small-cells"><input type="checkbox"
									class="mail-checkbox"></td> 
								<td class="inbox-small-cells"><i
									class="fa fa-star inbox-started"></i></td>
								<td class="view-message dont-show">환불&교환<span
									class="label label-danger pull-right" style="color:red;">교환</span></td>
								<td class="view-message">OO회원님이 요청하셨습니다.</td>
								<td class="view-message inbox-small-cells">
									<small>처리상태 :
										<img alt="" style="width: 22px;height: 22px;" 
											src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Yes_Check_Circle.svg/1024px-Yes_Check_Circle.svg.png"> 
									</small>
								</td>
								<td class="view-message text-right">May 23</td> 
							</tr>
							<tr class="">
								<td class="inbox-small-cells"><input type="checkbox"
									class="mail-checkbox"></td> 
								<td class="inbox-small-cells"><i
									class="fa fa-star inbox-started"></i></td>
								<td class="view-message dont-show">환불&교환<span
									class="label label-danger pull-right" style="color:red;">교환</span></td>
								<td class="view-message">OO회원님이 요청하셨습니다.</td>
								<td class="view-message inbox-small-cells">
									<small>처리상태 :
										<img alt="" style="width: 22px;height: 22px;" 
											src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Yes_Check_Circle.svg/1024px-Yes_Check_Circle.svg.png"> 
									</small>
								</td>
								<td class="view-message text-right">May 23</td> 
							</tr>
							<tr class="">
								<td class="inbox-small-cells"><input type="checkbox"
									class="mail-checkbox"></td>
								<td class="inbox-small-cells"><i class="fa fa-star"></i></td>
								<td class="view-message dont-show">재고</td> 
								<td class="view-message">OO상품 재고가 부족합니다.</td> 
								<td class="view-message inbox-small-cells"></td>
								<td class="view-message text-right">April 01</td>
							</tr>
							<tr class="">
								<td class="inbox-small-cells"><input type="checkbox"
									class="mail-checkbox"></td>
								<td class="inbox-small-cells"><i
									class="fa fa-star inbox-started"></i></td>
								<td class="view-message dont-show">환불&교환<span
									class="label label-danger pull-right" style="color:red;">환불</span></td>
								<td class="view-message">OO회원님이 요청하셨습니다.</td>
								<td class="view-message inbox-small-cells"> 
									<small>처리상태 :
									<img alt="" style="width: 22px;height: 22px;" 
										src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Yes_Check_Circle.svg/1024px-Yes_Check_Circle.svg.png"> 
									</small>
								</td>
								<td class="view-message text-right">May 23</td>  
							</tr> 
							<tr class=""> 
								<td class="inbox-small-cells"><input type="checkbox"
									class="mail-checkbox"></td>
								<td class="inbox-small-cells"><i class="fa fa-star"></i></td>
								<td class="view-message dont-show">주문</td>
								<td class="view-message">OO회원님이 주문을 하셨습니다.</td>
								<td class="view-message inbox-small-cells"></td>
								<td class="view-message text-right">March 13</td>
							</tr>
							<tr class="">
								<td class="inbox-small-cells"><input type="checkbox"
									class="mail-checkbox"></td>
								<td class="inbox-small-cells"><i class="fa fa-star"></i></td>
								<td class="view-message dont-show">장바구니</td>
								<td class="view-message">OO회원님이 장바구니에 담으셨습니다.</td>
								<td class="view-message inbox-small-cells"></td>
								<td class="view-message text-right">March 13</td>
							</tr>
							<tr class="">
								<td class="inbox-small-cells"><input type="checkbox"
									class="mail-checkbox"></td>
								<td class="inbox-small-cells"><i class="fa fa-star"></i></td>
								<td class="view-message dont-show">Q&A</td>
								<td class="view-message">OO회원님이 OO문의 글을 남기셨습니다.</td> 
								<td class="view-message inbox-small-cells"></td>
								<td class="view-message text-right">March 15</td> 
							</tr> 
							<tr class="">
								<td class="inbox-small-cells"><input type="checkbox"
									class="mail-checkbox"></td>
								<td class="inbox-small-cells"><i class="fa fa-star"></i></td>
								<td class="view-message dont-show">재고</td> 
								<td class="view-message">OO상품 재고가 부족합니다.</td> 
								<td class="view-message inbox-small-cells"></td>
								<td class="view-message text-right">April 01</td>
							</tr>
							<tr class="">
								<td class="inbox-small-cells"><input type="checkbox"
									class="mail-checkbox"></td>
								<td class="inbox-small-cells"><i
									class="fa fa-star inbox-started"></i></td>
								<td class="view-message dont-show">환불&교환<span
									class="label label-danger pull-right" style="color:red;">환불</span></td>
								<td class="view-message">OO회원님이 요청하셨습니다.</td>
								<td class="view-message inbox-small-cells"> 
									<small>처리상태 :
									<img alt="" style="width: 22px;height: 22px;" 
										src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Yes_Check_Circle.svg/1024px-Yes_Check_Circle.svg.png"> 
									</small>
								</td>
								<td class="view-message text-right">May 23</td> 
							</tr>
							<tr class="">
								<td class="inbox-small-cells"><input type="checkbox"
									class="mail-checkbox"></td>
								<td class="inbox-small-cells"><i class="fa fa-star"></i></td>
								<td class="view-message dont-show">주문</td>
								<td class="view-message">OO회원님이 주문을 하셨습니다.</td>
								<td class="view-message inbox-small-cells"></td>
								<td class="view-message text-right">March 13</td> 
							</tr>
							<tr class="">
								<td class="inbox-small-cells"><input type="checkbox"
									class="mail-checkbox"></td>
								<td class="inbox-small-cells"><i class="fa fa-star"></i></td>
								<td class="view-message dont-show">장바구니</td>
								<td class="view-message">OO회원님이 장바구니에 담으셨습니다.</td>
								<td class="view-message inbox-small-cells"></td>
								<td class="view-message text-right">March 13</td>
							</tr>
							
						</tbody>
					</table>  
				</div>
				<ul class="unstyled inbox-pagination">
					<li><a class="np-btn" href="#"><i
							class="fa fa-angle-left  pagination-left"></i></a></li>
					<li class="page-item active"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li><a class="np-btn" href="#"><i
							class="fa fa-angle-right pagination-right"></i></a></li>
				</ul>
			</aside>
		</div>
	</div>
	<!-- /.container -->

	<!-- Footer -->
	<c:import url='/WEB-INF/views/includes/footer.jsp' />
	<!-- /.Footer -->
</body>
</html>