<%@page import="com.myclass.dto.UserDto"%>
<%@page import="com.myclass.constants.UrlConstants"%>
<%@page import="com.myclass.entity.Job"%>
<%@page import="com.myclass.entity.Status"%>
<%@page import="java.util.List"%>
<%@page import="com.myclass.entity.Task"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Task task = (Task) request.getAttribute("task");
List<UserDto> users = (List<UserDto>) request.getAttribute("users");
List<Status> statuses = (List<Status>) request.getAttribute("status");
List<Job> jobs = (List<Job>) request.getAttribute("jobs");
%>
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
						<h4 class="page-title">Sửa công việc</h4>
					</div>
				</div>
				<!-- /.row -->
				<!-- .row -->
				<div class="row">
					<div class="col-md-2 col-12"></div>
					<div class="col-md-8 col-xs-12">
						<div class="white-box">
							<form
								action="<%=request.getContextPath()%><%=UrlConstants.URL_TASK_EDIT%>"
								class="form-horizontal form-material">
								<input value=<%=task.getId()%> type="hidden" name="id"
									class="form-control form-control-line">
								<div class="form-group">
									<label class="col-md-12">Dự án</label>
									<div class="col-md-12">
										<select name="jobId" class="form-control form-control-line">
											<%
												for (Job job : jobs) {
												String selected = task.getJobId() == job.getId() ? "selected" : "";
											%>
											<option value=<%=job.getId()%> <%=selected%>>
												<%=job.getName()%>
											</option>
											<%
												}
											%>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-12">Tên công việc</label>
									<div class="col-md-12">
										<input value=<%=task.getName()%> type="text"
											placeholder="Tên công việc"
											class="form-control form-control-line">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-12">Người thực hiện</label>
									<div class="col-md-12">
										<select name="userId" class="form-control form-control-line">
											<%
												for (UserDto user : users) {
												String selected = task.getUserId() == user.getId() ? "selected" : "";
											%>
											<option value=<%=user.getId()%> <%=selected%>>
												<%=user.getFullName()%>
											</option>
											<%
												}
											%>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-12">Ngày bắt đầu</label>
									<div class="col-md-12">
										<input value=<%=task.getStartDate()%> type="text"
											placeholder="dd/MM/yyyy"
											class="form-control form-control-line">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-12">Ngày kết thúc</label>
									<div class="col-md-12">
										<input value=<%=task.getStartDate()%> type="text"
											placeholder="dd/MM/yyyy"
											class="form-control form-control-line">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-12">Status</label>
									<div class="col-md-12">
										<select name="statusId" class="form-control form-control-line">
											<%
												for (Status status : statuses) {
												String selected = task.getUserId() == status.getId() ? "selected" : "";
											%>
											<option value=<%=status.getId()%> <%=selected%>>
												<%=status.getName()%>
											</option>
											<%
												}
											%>
										</select>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-12">
										<button type="submit" class="btn btn-success">Lưu lại</button>
										<a href="<%=UrlConstants.URL_TASK%>" class="btn btn-primary">Quay
											lại</a>
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