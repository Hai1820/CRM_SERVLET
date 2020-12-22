<%@page import="com.myclass.entity.Status"%>
<%@page import="com.myclass.dto.UserDto"%>
<%@page import="com.myclass.entity.Job"%>
<%@page import="java.util.List"%>
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
						<h4 class="page-title">Thêm mới công việc</h4>
					</div>
				</div>
				<!-- /.row -->
				<!-- .row -->
				<div class="row">
					<div class="col-md-2 col-12"></div>
					<div class="col-md-8 col-xs-12">
						<div class="white-box">
							<form method="post"
								action="<%=request.getContextPath() + "/task/add"%>"
								class="form-horizontal form-material">
								<div class="form-group">
									<%
										List<Job> jobs = (List<Job>) request.getAttribute("jobs");
									%>
									<label class="col-md-12">Dự án</label>
									<div class="col-md-12">
										<select name="jobId" class="form-control form-control-line">
											<%
												for (Job job : jobs) {
											%>
											<option value="<%=job.getId()%>"><%=job.getName()%></option>
											<%
												}
											%>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-12">Tên công việc</label>
									<div class="col-md-12">
										<input name="name" type="text" placeholder="Tên công việc"
											class="form-control form-control-line">
									</div>
								</div>
								<div class="form-group">
									<%
										List<UserDto> users = (List<UserDto>) request.getAttribute("users");
									%>
									<label class="col-md-12">Người thực hiện</label>
									<div class="col-md-12">
										<select name="userId" class="form-control form-control-line">
											<%
												for (UserDto user : users) {
											%>
											<option value="<%=user.getId()%>"><%=user.getFullName()%></option>
											<%
												}
											%>
										</select>
									</div>
								</div>
								<div class="form-group">
									<%
										List<Status> statuses = (List<Status>) request.getAttribute("status");
									%>
									<label class="col-md-12">Status</label>
									<div class="col-md-12">
										<select name="statusId" class="form-control form-control-line">
											<%
												for (Status status : statuses) {
											%>
											<option value="<%=status.getId()%>"><%=status.getName()%></option>
											<%
												}
											%>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-12">Ngày bắt đầu</label>
									<div class="col-md-12">
										<input name="startDate" type="text" placeholder="dd/MM/yyyy"
											class="form-control form-control-line">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-12">Ngày kết thúc</label>
									<div class="col-md-12">
										<input name="endDate" type="text" placeholder="dd/MM/yyyy"
											class="form-control form-control-line">
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-12">
										<button type="submit" class="btn btn-success">Lưu lại</button>
										<a href="<%=request.getContextPath()%>/task"
											class="btn btn-primary">Quay lại</a>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="col-md-2 col-12"></div>
				</div>
				<!-- /.row -->
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