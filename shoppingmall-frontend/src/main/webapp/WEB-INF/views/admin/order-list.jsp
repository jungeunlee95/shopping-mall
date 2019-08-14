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
					<h3>주문 목록</h3>
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
				<h3>회원 주문 목록</h3> <small style="color:red;"></small> 
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
							<c:set var='count' value='${fn:length(orderList) }' /> 
							<c:forEach items='${orderList }' var='vo' varStatus='status'>
							
								<tr class="unread">
									<td class="inbox-small-cells"><input type="checkbox"
										class="mail-checkbox"></td> 
									<td class="inbox-small-cells">[${count - status.index }]</td>
									<td class="view-message  dont-show">
										<a href="${pageContext.request.contextPath }/admin/order/detail/${vo.no}/${vo.userNo}">
											${vo.orderStringNo }
										</a> 
									</td> 
									<td class="view-message ">[${vo.userName }] 회원님이 
									<span style="color:red;">주문</span>하셨습니다.</td> 
									<td class="view-message  inbox-small-cells"> </td>
									<td class="view-message  text-right">${vo.regDate }</td> 
								</tr>
							 
							</c:forEach>    
							  
							
							
							
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