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

		var a = document.forms["my-form"]["id"].value;
		var b = document.forms["my-form"]["password"].value;
		var c = document.forms["my-form"]["name"].value;
		var d = document.forms["my-form"]["password_question"].value;
		var e = document.forms["my-form"]["password_answer"].value;
		var f = document.forms["my-form"]["phone_number"].value;

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
		} else if (f == null || e == "") {
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
						<form name="my-form" onsubmit="return validform()" action="" method="">
							<div class="form-group row">
								<label for="id"
									class="col-md-4 col-form-label text-md-right">아이디</label>
								<div class="col-md-6">
									<input type="text" id="id" class="form-control"
										name="id">
								</div>
							</div>

							<div class="form-group row">
								<label for="password"
									class="col-md-4 col-form-label text-md-right">비밀번호</label>
								<div class="col-md-6">
									<input type="text" id="password" class="form-control"
										name="password">
								</div>
							</div>

							<div class="form-group row">
								<label for="name"
									class="col-md-4 col-form-label text-md-right">이름</label>
								<div class="col-md-6">
									<input type="text" id="name" class="form-control"
										name="name">
								</div>
							</div>

							<div class="form-group row">
								<label for="password_question"
									class="col-md-4 col-form-label text-md-right">비밀번호 질문</label>
								<div class="col-md-6">
									<select id="password_question" class="form-control" name="password_question">
									    <option value="">비밀번호 질문 선택</option>
									    <option value="2">가장 아끼는 물건은?</option>
									    <option value="3">강아지 이름은?</option>
									    <option value="4">가장 좋아하는 책은?</option>
									</select> 
								</div>
							</div>

							<div class="form-group row">
								<label for="password_answer"
									class="col-md-4 col-form-label text-md-right">비밀번호 답변</label>
								<div class="col-md-6">
									<input type="text" id="password_answer" class="form-control" name="password_answer">
								</div>
							</div>

							<div class="form-group row">
								<label for="phone_number"
									class="col-md-4 col-form-label text-md-right">전화번호</label>
								<div class="col-md-6">
									<input type="text" id="phone_number" class="form-control"
										name="phone_number">
								</div>
							</div>

							<div class="form-group row">
								<label for="birth_date"
									class="col-md-4 col-form-label text-md-right">생일</label>
								<div class="col-md-6">
									<input type="date" id="birth_date" class="form-control"
										name="birth_date">
								</div>
							</div>
							
							<div class="form-group row">
								<label for="email"
									class="col-md-4 col-form-label text-md-right">이메일</label>
								<div class="col-md-6">
									<input type="text" id="email" class="form-control"
										name="email">
								</div>
							</div>

							<div class="col-md-6 offset-md-4">
								<button type="submit" class="btn btn-primary">Register
								</button>
							</div>
					</form>
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