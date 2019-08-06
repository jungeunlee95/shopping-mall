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
<script>

	function validform() {

		var a = document.forms["joinForm"]["id"].value;
		var b = document.forms["joinForm"]["password"].value;
		var c = document.forms["joinForm"]["name"].value;
		var d = document.forms["joinForm"]["password_question"].value;
		var e = document.forms["joinForm"]["password_answer"].value;
		var f = document.forms["joinForm"]["phone_number"].value;

		if (a == null || a == "") {
			alert("아이디를 입력해주세요.");
			return false;
		} else if (b == null || b == "") {
			alert("비밀번호를 입력해주세요.");
			return false;
		} else if (c == null || c == "") {
			alert("이름을 입력해주세요.");
			return false;
		} else if (d == null || d == "") {
			alert("비밀번호 질문을 선택해주세요.");
			return false;
		} else if (e == null || e == "") {
			alert("비밀번호 답변을 입력해주세요.");
			return false;
		} else if (f == null || f == "") {
			alert("전화번호를 입력해주세요.");
			return false;
		}

	}
</script>
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
					<div class="card-header text-center">회원가입</div>
					<div class="card-body">
						<form:form modelAttribute="userVo"
									id="join-form" 
									name="joinForm" 
									method="post" 
									onsubmit="return validform()" 
									action="${pageContext.servletContext.contextPath}/user/join">
							<div class="form-group row">
								<label for="id" class="col-md-4 col-form-label text-md-right">아이디</label>
								<div class="col-md-6">
									<form:input id="id" class="form-control" name="id" path="id" />
									<p style="font-weight: bold; color: red;text-align: left; padding: 0;">
										<form:errors path="id"/>
									</p> 
								</div>
							</div>

							<div class="form-group row">
								<label for="password"
									class="col-md-4 col-form-label text-md-right">비밀번호</label>
								<div class="col-md-6">
									<form:input type="password" id="password" class="form-control" name="password" path="password" />
									<p style="font-weight: bold; color: red;text-align: left; padding: 0;">
										<form:errors path="password"/> 
									</p>
								</div>
							</div>

							<div class="form-group row">
								<label for="name"
									class="col-md-4 col-form-label text-md-right">이름</label>
								<div class="col-md-6">
									<form:input type="text" id="name" class="form-control" name="name" path="name"/>
									<p style="font-weight: bold; color: red;text-align: left; padding: 0;">
										<form:errors path="name"/>
									</p>
								</div>
							</div>
							
							<div class="form-group row">
								<label for="gender"
									class="col-md-4 col-form-label text-md-right">성별</label>
								<div class="col-md-6">
									<fieldset>
										<label>여</label>
										<form:radiobutton path="gender" value="F"
											checked="checked" />
										<label>남</label>
										<form:radiobutton path="gender" value="M" />
									</fieldset>
									<p
										style="font-weight: bold; color: red; text-align: left; padding: 0;">
										<form:errors path="gender" />
									</p>
								</div>
							</div>

							<div class="form-group row">
								<label for="password_question"
									class="col-md-4 col-form-label text-md-right">비밀번호 질문</label>
								<div class="col-md-6">
									<select id="password_question" class="form-control" name="passwordQuestion" path="passwordQuestion">
									    <option value="">비밀번호 질문 선택</option>
									    <option value="1">가장 아끼는 보물 1호는?</option>
									    <option value="2">강아지 이름은?</option> 
									    <option value="3">가장 좋아하는 책은?</option> 
									</select> 
								</div>
							</div>

							<div class="form-group row">
								<label for="password_answer"
									class="col-md-4 col-form-label text-md-right">비밀번호 답변</label>
								<div class="col-md-6">
									<form:input type="text" id="password_answer" class="form-control" name="passwordAnswer" path="passwordAnswer" />
									<p style="font-weight: bold; color: red;text-align: left; padding: 0;">
										<form:errors path="passwordAnswer"/>
									</p>
								</div>
							</div>

							<div class="form-group row">
								<label for="phone_number"
									class="col-md-4 col-form-label text-md-right">전화번호</label>
								<div class="col-md-6">
									<form:input type="text" id="phone_number" class="form-control" name="phoneNumber" path="phoneNumber" />
									<p style="font-weight: bold; color: red;text-align: left; padding: 0;">
										<form:errors path="phoneNumber"/>
									</p>
								</div>
							</div>
 
							<div class="form-group row">
								<label for="birthDate" class="col-md-4 col-form-label text-md-right">생일</label>
								<div class="col-md-6">
									<input id="birthDate" class="form-control" name="birthDate"
									placeholder="YYYY-MM-DD"/>
								</div>  
							</div>
<%-- 							<div class="form-group row">
								<label for="birthDate" class="col-md-4 col-form-label text-md-right">생일</label>
								<div class="col-md-6">
									<form:input type="date" id="birthDate" class="form-control" name="birthDate" path="birthDate"/>
								</div>
							</div> --%>
							
							<div class="form-group row">
								<label for="email"
									class="col-md-4 col-form-label text-md-right">이메일</label> 
								<div class="col-md-6">
									<form:input type="text" id="email" class="form-control" name="email" path="email" />
									<p style="font-weight: bold; color: red;text-align: left; padding: 0;">
										<form:errors path="email"/>
									</p>
								</div>
							</div>

							<div class="col-md-6 offset-md-4">
								<button type="submit" class="btn btn-primary">Register
								</button>
							</div> 
					</form:form>
					</div>
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