<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" type="image/png" sizes="16x16"
	href="<%=request.getContextPath()%>/static/plugins/images/favicon.png">
<title>Pixel Admin</title>
<!-- Bootstrap Core CSS -->
<link
	href="<%=request.getContextPath()%>/static/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Menu CSS -->
<link
	href="<%=request.getContextPath()%>/static/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css"
	rel="stylesheet">
<!-- animation CSS -->
<link href="<%=request.getContextPath()%>/static/css/animate.css"
	rel="stylesheet">
<!-- Custom CSS -->
<link href="<%=request.getContextPath()%>/static/css/style.css"
	rel="stylesheet">
<!-- color CSS -->
<link
	href="<%=request.getContextPath()%>/static/css/colors/blue-dark.css"
	id="theme" rel="stylesheet">
</head>
<body>
	<!-- Preloader -->
	<jsp:include page="../layout/preloader.jsp"></jsp:include>
	<div id="wrapper">
		<!-- Navigation -->
		<jsp:include page="../layout/navigation.jsp"></jsp:include>
		<!-- Left navbar-header end -->
		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row bg-title">
					<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
						<h4 class="page-title">Chi tiết thành viên</h4>
					</div>
				</div>
				<!-- /.row -->
				<!-- .row -->
				<div class="row">
					<div class="col-md-4 col-xs-12">
						<div class="white-box">
							<div class="user-bg">
								<img width="100%" alt="user" src="plugins/images/large/img1.jpg">
								<div class="overlay-box">
									<div class="user-content">
										<a href="javascript:void(0)"><img
											src="<%=request.getContextPath()%>/static/plugins/images/users/genu.jpg"
											class="thumb-lg img-circle" alt="img"></a>
										<h4 class="text-white">Nguyễn Văn Tèo</h4>
										<h5 class="text-white">info.teo@gmail.com</h5>
									</div>
								</div>
							</div>

						</div>
					</div>
					<div class="col-md-8 col-xs-12">
						<!-- BEGIN THỐNG KÊ -->
						<div class="row">
							<!--col -->
							<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
								<div class="white-box">
									<div class="col-in row">
										<div class="col-xs-12">
											<h3 class="counter text-right m-t-15 text-danger">20%</h3>
										</div>
										<div class="col-xs-12">
											<i data-icon="E" class="linea-icon linea-basic"></i>
											<h5 class="text-muted vb text-center">CHƯA BẮT ĐẦU</h5>
										</div>
										<div class="col-md-12 col-sm-12 col-xs-12">
											<div class="progress">
												<div class="progress-bar progress-bar-danger"
													role="progressbar" aria-valuenow="40" aria-valuemin="0"
													aria-valuemax="100" style="width: 20%"></div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- /.col -->
							<!--col -->
							<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
								<div class="white-box">
									<div class="col-in row">
										<div class="col-xs-12">
											<h3 class="counter text-right m-t-15 text-megna">50%</h3>
										</div>
										<div class="col-xs-12">
											<i class="linea-icon linea-basic" data-icon="&#xe01b;"></i>
											<h5 class="text-muted vb text-center">ĐANG THỰC HIỆN</h5>
										</div>
										<div class="col-md-12 col-sm-12 col-xs-12">
											<div class="progress">
												<div class="progress-bar progress-bar-megna"
													role="progressbar" aria-valuenow="40" aria-valuemin="0"
													aria-valuemax="100" style="width: 50%"></div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- /.col -->
							<!--col -->
							<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
								<div class="white-box">
									<div class="col-in row">
										<div class="col-xs-12">
											<h3 class="counter text-right m-t-15 text-primary">30%</h3>
										</div>
										<div class="col-xs-12">
											<i class="linea-icon linea-basic" data-icon="&#xe00b;"></i>
											<h5 class="text-muted vb text-center">HOÀN THÀNH</h5>
										</div>
										<div class="col-md-12 col-sm-12 col-xs-12">
											<div class="progress">
												<div class="progress-bar progress-bar-primary"
													role="progressbar" aria-valuenow="40" aria-valuemin="0"
													aria-valuemax="100" style="width: 30%"></div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- /.col -->
						</div>
						<!-- END THỐNG KÊ -->

					</div>
				</div>
				<br />
				<!-- /.row -->
				<!-- BEGIN DANH SÁCH CÔNG VIỆC -->
				<h4>DANH SÁCH CÔNG VIỆC</h4>
				<div class="row">
					<div class="col-sm-12">
						<div class="white-box">
							<div class="table-responsive">
								<table class="table" id="example">
									<thead>
										<tr>
											<th>STT</th>
											<th>Tên Công Việc</th>
											<th>Dự Án</th>
											<th>Ngày Bắt Đầu</th>
											<th>Ngày Kết Thúc</th>
											<th>Trạng Thái</th>
											<th>Hành Động</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1</td>
											<td>Phân tích dự án</td>
											<td>Dự án CRM</td>
											<td>22/05/2019</td>
											<td>30/05/2019</td>
											<td>Đã hoàn thành</td>
											<td><a href="profile-edit.html"
												class="btn btn-sm btn-primary">Cập nhật</a></td>
										</tr>
										<tr>
											<td>1</td>
											<td>Thiết kế database</td>
											<td>Dự án CRM</td>
											<td>22/05/2019</td>
											<td>30/05/2019</td>
											<td>Đang thực hiện</td>
											<td><a href="profile-edit.html"
												class="btn btn-sm btn-primary">Cập nhật</a></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<!-- END DANH SÁCH CÔNG VIỆC -->
			</div>
			<!-- /.container-fluid -->
			<footer class="footer text-center"> 2018 &copy; myclass.com
			</footer>
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->
	<!-- jQuery -->
	<script
		src="<%=request.getContextPath()%>/static/plugins/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script
		src="<%=request.getContextPath()%>/static/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- Menu Plugin JavaScript -->
	<script
		src="<%=request.getContextPath()%>/static/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
	<!--slimscroll JavaScript -->
	<script
		src="<%=request.getContextPath()%>/static/js/jquery.slimscroll.js"></script>
	<!--Wave Effects -->
	<script src="<%=request.getContextPath()%>/static/js/waves.js"></script>
	<!-- Custom Theme JavaScript -->
	<script src="<%=request.getContextPath()%>/static/js/custom.min.js"></script>

</body>
</html>