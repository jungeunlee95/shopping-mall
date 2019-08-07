<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>  
<aside class="sm-side">
	<div class="user-head">
		<a class="inbox-avatar" href="javascript:;"> <img width="64" 
			height="60"
			src="https://avatars3.githubusercontent.com/u/45933377?s=460&v=4">
		</a>
		<div class="user-name">
			<h5>
				<a href="#">이정은 관리자님</a>
			</h5>
			<span><a href="#">leeap1004@gmail.com</a></span>
		</div>
		<a class="mail-dropdown pull-right" href="javascript:;"> <i
			class="fa fa-chevron-down"></i>
		</a>
	</div>
	<div class="inbox-body">
		<a href="#myModal" data-toggle="modal" title="Compose"
			class="btn btn-compose"> Compose </a>
		<!-- Modal -->
		<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
			tabindex="-1" id="myModal" class="modal fade" style="display: none;">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button aria-hidden="true" data-dismiss="modal" class="close"
							type="button">×</button>
						<h4 class="modal-title">Compose</h4>
					</div>
					<div class="modal-body">
						<form role="form" class="form-horizontal">
							<div class="form-group">
								<label class="col-lg-2 control-label">To</label>
								<div class="col-lg-10">
									<input type="text" placeholder="" id="inputEmail1"
										class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-2 control-label">Cc / Bcc</label>
								<div class="col-lg-10">
									<input type="text" placeholder="" id="cc" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-2 control-label">Subject</label>
								<div class="col-lg-10">
									<input type="text" placeholder="" id="inputPassword1"
										class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-2 control-label">Message</label>
								<div class="col-lg-10">
									<textarea rows="10" cols="30" class="form-control" id=""
										name=""></textarea>
								</div>
							</div>

							<div class="form-group">
								<div class="col-lg-offset-2 col-lg-10">
									<span class="btn green fileinput-button"> <i
										class="fa fa-plus fa fa-white"></i> <span>Attachment</span> <input
										type="file" name="files[]" multiple="">
									</span>
									<button class="btn btn-send" type="submit">Send</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
	</div>
	<ul class="inbox-nav inbox-divider">
		<li class="active"><a href="" class="a-disabled"><i
				class="fa fa-users"></i>회원</a></li>
		<li><a href="${pageContext.servletContext.contextPath }/admin/user/list">회원목록</a></li>
	</ul>

	<ul class="inbox-nav inbox-divider">
		<li class="active"><a href="" class="a-disabled"><i
				class="fa fa-inbox"></i>상품</a></li> 
		<li><a href="${pageContext.servletContext.contextPath }/admin/product/list">상품목록</a></li>
		<li><a href="${pageContext.servletContext.contextPath }/admin/product">상품등록</a></li>
		<li><a href="#">상품 옵션 등록</a></li>
		<li><a href="#">상품 수정</a></li>
		<li><a href="#">상품 삭제</a></li>
	</ul>
 
	<ul class="inbox-nav inbox-divider">
		<li class="active"><a href="" class="a-disabled"><i
				class="fa fa-shopping-cart"></i>장바구니</a></li>
		<li><a href="#">장바구니목록</a></li>
	</ul>

	<ul class="inbox-nav inbox-divider">
		<li class="active"><a href="" class="a-disabled"><i
				class="fa fa-list"></i>카테고리</a></li>
		<li><a href="#">카테고리 목록</a></li>
		<li><a href="#">카테고리 등록</a></li>
		<li><a href="#">카테고리 수정</a></li>
		<li><a href="#">카테고리 삭제</a></li>
	</ul>

	<ul class="inbox-nav inbox-divider">
		<li class="active"><a href="" class="a-disabled"><i
				class="fa fa-truck"></i>주문</a></li>
		<li><a href="active">주문 목록</a></li>
	</ul>


	<div class="inbox-body text-center">
		<div class="btn-group">
			<a class="btn mini btn-primary" href="javascript:;"> <i
				class="fa fa-plus"></i>
			</a>
		</div>
		<div class="btn-group">
			<a class="btn mini btn-success" href="javascript:;"> <i
				class="fa fa-phone"></i>
			</a>
		</div>
		<div class="btn-group">
			<a class="btn mini btn-info" href="javascript:;"> <i
				class="fa fa-cog"></i>
			</a>
		</div>
	</div>

</aside>
