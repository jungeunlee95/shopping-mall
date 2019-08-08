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
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- smart editor -->
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>

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
		
			<c:import url="/WEB-INF/views/includes/inbox-nav.jsp"> 
				<c:param name="active" value="add-product" />
			</c:import>
			
			<aside class="lg-side">
				<div class="inbox-head">
					<h3>상품 등록 페이지</h3>
				</div>
				<div class="inbox-body"> 
					<div class="mail-option">
						 
					</div>
					<!-- Section Form -->
					<section id="form">
						<div class="container pt-5 pb-5">
							<div class="row">
								<div class="col-md-12 text-center">
									<h3 class="text-uppercase">
										상품등록 페이지 <br> <span class="blue">-</span>
									</h3>
									<p>등록할 상품의 세부 정보를 입력해주세요</p>
									<div class="row">
										<div class="col-md-12">
											<form>
												<div class="form-row">
													<div class="form-group col-md-6">
														<h5 class="text-left">Dados cadastrais</h5>
														<input type="name" class="form-control" id="inputDado"
															placeholder="Seu nome">
													</div>
													<div class="form-group col-md-6">
														<h5 class="text-left">Dados de acesso</h5>
														<input type="email" class="form-control" id="inputDado"
															placeholder="Seu e-mail">
													</div>
													<div class="form-group col-md-3">
														<input type="cpf" class="form-control" id="inputDado"
															placeholder="Seu cpf">
													</div>
													<div class="form-group col-md-3">
														<input type="age" class="form-control" id="inputDado"
															placeholder="Sua idade">
													</div>
													<div class="form-group col-md-6">
														<input type="password" class="form-control" id="inputDado"
															placeholder="Senha">
													</div>
													<div class="form-group col-md-1">
														<input type="ddd" class="form-control" id="inputDado"
															placeholder="DDD">
													</div>
													<div class="form-group col-md-3">
														<input type="number" class="form-control" id="inputDado"
															placeholder="Seu telefone">
													</div>
													<div class="form-group col-md-2">
														<input type="cep" class="form-control" id="inputDado"
															placeholder="Seu cep">
													</div>
													<div class="form-group col-md-6">
														<input type="password" class="form-control" id="inputDado"
															placeholder="Confirme a senha">
													</div>
													<div class="form-group col-md-6">
														<input type="street" class="form-control" id="inputDado"
															placeholder="Nome da rua pelo cep">
													</div>
													<div class="form-group col-md-3">
														<input type="number" class="form-control" id="inputDado"
															placeholder="Seu telefone">
													</div>
													<div class="form-group col-md-3">
														<input type="number" class="form-control" id="inputDado"
															placeholder="Seu telefone">
													</div>
													<div class="com-md-6">
														<h5>Clique aqui para ler o termo de Uso</h5>
													</div>
													<div class="form-group col-md-3">
														<input type="number" class="form-control" id="inputDado"
															placeholder="Seu telefone">
													</div>
													<div class="form-group col-md-3">
														<input type="number" class="form-control" id="inputDado"
															placeholder="Seu telefone">
													</div>
												</div>
												<div class="form-group">
													<label for="inputAddress">Address</label> <input
														type="text" class="form-control" id="inputAddress"
														placeholder="1234 Main St">
												</div>
												<div class="form-group">
													<label for="inputAddress2">Address 2</label> <input
														type="text" class="form-control" id="inputAddress2"
														placeholder="Apartment, studio, or floor">
												</div>
												<div class="form-row">
													<div class="form-group col-md-6">
														> <label for="inputCity">City</label> <input type="text"
															class="form-control" id="inputCity">
													</div>
													<div class="form-group col-md-4">
														<label for="inputState">State</label> <select
															id="inputState" class="form-control">
															<option selected>Choose...</option>
															<option>...</option>
														</select>
													</div>
													<div class="form-group col-md-2">
														<label for="inputZip">Zip</label> <input type="text"
															class="form-control" id="inputZip">
													</div>
												</div>
												<div class="form-group">
													<div class="form-check">
														<input class="form-check-input" type="checkbox"
															id="gridCheck"> <label class="form-check-label"
															for="gridCheck"> Check me out </label>
													</div>
												</div>
												<div class="form-group">
													<textarea name="ir1" id="ir1" rows="10" cols="100"></textarea>
												</div>
												<button type="submit" class="btn btn-primary">상품 등록</button>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</section>
				</div>
			</aside>
		</div>
	</div>
	<!-- /.container -->

	<!-- Footer -->
	<c:import url='/WEB-INF/views/includes/footer.jsp' />
	<!-- /.Footer -->
<script type="text/javascript">
	var oEditors = [];
	nhn.husky.EZCreator.createInIFrame({
	 oAppRef: oEditors,
	 elPlaceHolder: "ir1",
	 sSkinURI: "${pageContext.request.contextPath}/assets/se2/SmartEditor2Skin.html",
	 fCreator: "createSEditor2"
	}); 
</script>
</body> 
</html>