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
<!-- include libraries(jQuery, bootstrap) -->
<link href="${pageContext.servletContext.contextPath }/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>  
 
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath }/assets/css/admin-main.css" rel="stylesheet" type="text/css">
<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>
<link href="/your-path-to-fontawesome/css/all.css" rel="stylesheet">

<!-- include summernote css/js -->  
<link href="${pageContext.request.contextPath }/assets/summernote/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js" defer></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/summernote/summernote.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/summernote/summernote.min.js"></script>
 <!-- summer note korean language pack -->
<script src="${pageContext.request.contextPath }/assets/summernote/lang/summernote-ko-KR.js"></script> 
<script>

	var optionIndex = 0; 
	
	$(document).ready(function() {
		// 썸머 노트 에디터
		$('#my-summernote').summernote({
			height : 600,
			minHeight : null,
			maxHeight : null,
			placeholder : '상품 상세 정보를 입력해주세요',
			callbacks : {
				onImageUpload : function(files, editor, welEditable) {
					for (var i = files.length - 1; i >= 0; i--) {
						sendFile(files[i], this);
					}
				}
			},
			popover : {
				image : [],
				link : [],
				air : []
			},
			tooltip : false
		});
		$('.dropdown-toggle').dropdown();
		
		// 네비게이션 선택 해제
		$('.a-disabled').click(function () {return false;});

	    // 옵션 여부  
	    $("input:radio[name=isOption]").click(function(){
	        if($("input[name=isOption]:checked").val() == "true"){
	        	$('#option-detail').css("display", "block");
	 
	        }else if($("input[name=isOption]:checked").val() == "false"){
	        	$('#option-detail').css("display", "none");
	        }
	    });
	     
		// 옵션 추가 
	    $("#add-option").click(function() { 
	        $('#option_add').append(
	        		'<div style="border: 1px solid #ced4da; width: 100%;">'
	        		+'<input type="text" class="form-control" id="optionList" name="optionNameList['+ optionIndex +'].productOptionName" placeholder="옵션이름">'
	        		+'<input type="text" class="form-control" id="optionList" name="optionNameList['+ optionIndex +'].additionalAmount" placeholder="추가금액">'
					+'<input type="text" class="form-control" id="optionList" name="optionNameList['+ optionIndex +'].stock" placeholder="재고">'
					+'<div class="custom-control custom-radio">'
					+'<input type="radio" name="optionNameList['+ optionIndex +'].useStock" id="useStock'+ optionIndex +'1" class="custom-control-input" value="true">'
					+'<label class="custom-control-label" for="useStock'+ optionIndex +'1">재고사용</label> </div>' 
					+'<div class="custom-control custom-radio">' 
					+'<input type="radio" name="optionNameList['+ optionIndex +'].useStock" id="useStock'+ optionIndex +'2" class="custom-control-input" value="false">' 
					+'<label class="custom-control-label" for="useStock'+ optionIndex +'2">재고사용안함</label> </div>' 
					+'</div>' 
					+'<a type="button" class="minus-option">'	 
					+'<img style="width: 30px; height: 30px;" src="data:image/jpeg;base64,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"> </a>'
					+'<br>'
	        		); 
	        optionIndex = optionIndex+1; 
	    });
		 
		// 옵션 삭제 
	    $(".minus-option").click(function() {
	        alert("삭제");   
	    }); 
	    
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
		 
			<c:import url="/WEB-INF/views/includes/inbox-nav.jsp"> 
				<c:param name="active" value="add-product" />
			</c:import>
			
			<aside class="lg-side">
				<div class="inbox-head">
					<h3>상품 등록 페이지</h3>
				</div>
				<div class="inbox-body">   
					<!-- Section Form --> 
					<section id="form">
						<div class="container pt-5 pb-5">
							<div class="row">
								<div class="col-md-12 text-center">
									<h3 class="text-uppercase">
										상품등록 페이지
									</h3>
									<p>등록할 상품의 세부 정보를 입력해주세요</p>
									<div class="row">
										<div class="col-md-12">
											<form action="${pageContext.servletContext.contextPath}/admin/product/add" method="post"
											enctype="multipart/form-data"> 
												<div class="form-row">
													<div class="form-group col-md-6">
														<h5 class="text-left">상품이름</h5>
														<input type="text" class="form-control" id="name" name="name" placeholder="name"> 
														<br>
														
														<h5 class="text-left">가격</h5>
														<input type="text" class="form-control" id="price" name="price" placeholder="price"> 
														<br>
														
														<h5 class="text-left">배송비</h5>
														<input type="text" class="form-control" id="shippingFee" name="shippingFee" placeholder="shippingFee"> 
														<br>
														
														<h5 class="text-left">진열여부</h5>
														<div class="form-control" style="min-height: 18%;">     
															<div class="custom-control custom-radio">
																<input type="radio" name="isShow" id="isShow-radio-1" class="custom-control-input" value="true"> 
																<label class="custom-control-label" for="isShow-radio-1">사용</label> 
															</div>  	 
															<div class="custom-control custom-radio">	
																<input type="radio" name="isShow" id="isShow-radio-2" class="custom-control-input" value="false"> 
																<label class="custom-control-label" for="isShow-radio-2">사용안함</label>
															</div>  
														</div>     
														<br>
													</div> 
													<div class="form-group col-md-6"> 
														<h5 class="text-left">대표 이미지 등록</h5> 
														<input type='file' id="mainImg" name="mainImg" />   
														<img class="form-control" id="image_section" 
														src="http://cdn8.bigcommerce.com/s-auu4kfi2d9/stencil/cc75d450-b2b3-0135-7293-525400dfdca6/e/933395a0-cb1b-0135-a812-525400970412/icons/icon-no-image.svg" 
														style="height: 300px;">    
													</div> 
													<hr>    
													<div class="com-md-6">   
														<h5>카테고리 선택</h5>  
													</div>  
													<div style="border: 1px solid #ced4da; width: 100%;">     
														<c:forEach items='${categoryLowList }' var='vo' varStatus='status'>
															<c:choose>
																<c:when test="${vo.depth == 1 }"> 
																	<br> ${vo.name }
																</c:when>
																<c:otherwise>
																	<input type="checkbox" name="categoryList" value="${vo.no }">${vo.name }
																</c:otherwise> 
															</c:choose>
														</c:forEach>
														<br>
													</div> 
													 
													<br> 
													<div class="com-md-6">   
														<h5>옵션여부</h5> 
													</div> 
													<div style="border: 1px solid #ced4da; width: 100%;"> 
														<div class="custom-control custom-radio">
															<input type="radio" name="isOption" id="isOption-radio-1" class="custom-control-input"
															value="true"> 
															<label class="custom-control-label" for="isOption-radio-1">사용</label>
														</div> 
														<div class="custom-control custom-radio"> 
															<input type="radio" name="isOption" id="isOption-radio-2" class="custom-control-input"
															value="false"> 
															<label class="custom-control-label" for="isOption-radio-2">사용안함</label>
														</div> 
													</div>   
													<br>  
												</div> 
												
												<hr>  
												<div id="option-detail" style="display:none;">
													<div class="form-group">
														<div class="form-check"> 
															옵션 상세 설정 
														</div> 
													</div>   
													<div class="form-group" id="option_add"> 
														  
													</div> 
													<a type="button" id="add-option"> 
														<img style="width: 30px; height: 30px;" src="data:image/jpeg;base64,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">
													</a>
													<hr>     
												</div>
												
												<hr> 
												<div class="form-group">
													<div class="form-check"> 
														상품 상세 정보 
													</div> 
												</div> 
												<div class="form-group"> 
													 <textarea id="my-summernote" name="contents" >
													 </textarea>
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
</body> 
<!-- summernote -->
<script type="text/javascript">
    function sendFile(file, el) {
      var form_data = new FormData();
      form_data.append('shopImg', file);
      $.ajax({
    	dataType: "json",  
        data: form_data,
        type: "post",
        url: '${pageContext.request.contextPath}/admin/api/insertImg', 		
        //cache: false,
        contentType: false,
        enctype: 'multipart/form-data',
        processData: false,
        success: function(response) { 
        	//alert("성공 : " + response.data); 
          $(el).summernote('editor.insertImage', '${pageContext.request.contextPath}/assets'+response.data);

          $('#imageBoard > ul').append('<li><img src="${pageContext.request.contextPath}/assets'+response.data+'" width="480" height="auto"/></li>');
        }, 
        error:function(a, b, c){ 
        	console.log(a);
        	console.log(b);
        	console.log(c);
        }
      });
    }
    
	function readURL(input) {
		 
		if (input.files && input.files[0]) {
			var reader = new FileReader();
	 
			reader.onload = function(e) { 
				$('#image_section').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	
	$("#mainImg").change(function() {
		readURL(this);
	});
</script>
</html>