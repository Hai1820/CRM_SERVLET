<%@page import="com.myclass.dto.TaskDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="description" content="" />
<meta name="author" content="" />
<link rel="icon" type="image/png" sizes="16x16"
	href="<%=request.getContextPath()%>/static/plugins/images/favicon.png" />
<title>Pixel Admin</title>
<!-- Bootstrap Core CSS -->
<link
	href="<%=request.getContextPath()%>/static/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<!-- Menu CSS -->
<link
	href="<%=request.getContextPath()%>/static/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" />
<!-- animation CSS -->
<link href="<%=request.getContextPath()%>/static/css/animate.css"
	rel="stylesheet" />
<!-- Custom CSS -->
<link href="<%=request.getContextPath()%>/static/css/style.css"
	rel="stylesheet" />
<!-- color CSS -->
<link
	href="<%=request.getContextPath()%>/static/css/colors/blue-dark.css"
	id="theme" rel="stylesheet" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/css/custom.css" />
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
						<h4 class="page-title">Danh sách công việc</h4>
					</div>
					<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
						<a href="<%=request.getContextPath()%>/task/add"
							class="btn btn-sm btn-success">Thêm mới</a>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /row -->
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
											<th>Người Thực Hiện</th>
											<th>Ngày Bắt Đầu</th>
											<th>Ngày Kết Thúc</th>
											<th>Trạng Thái</th>
											<th>Hành Động</th>
										</tr>
									</thead>
									<tbody>
										<%
											List<TaskDto> tasks = (List<TaskDto>) request.getAttribute("tasks");
										%>
										<%
											for (TaskDto task : tasks) {
										%>
										<tr>
											<td><%=task.getId()%></td>
											<td><%=task.getName()%></td>
											<td><%=task.getNameJob()%></td>
											<td><%=task.getNameUser()%></td>
											<td><%=task.getStartDate()%></td>
											<td><%=task.getEndDate()%></td>
											<td><%=task.getNameStatus()%></td>
											<td><a
												href="<%=request.getContextPath()%>/task/edit?id=<%=task.getId()%>"
												class="btn btn-sm btn-primary">Sửa</a> <a
												href="<%=request.getContextPath()%>/task/delete?id=<%=task.getId()%>"
												class="btn btn-sm btn-danger">Xóa</a> <a href="#"
												class="btn btn-sm btn-info">Xem</a></td>
										</tr>
										<%
											}
										%>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
			<footer class="footer text-center">2018 &copy; myclass.com</footer>
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
	<script
		src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	<!--Wave Effects -->
	<script src="js/waves.js"></script>
	<!-- Custom Theme JavaScript -->
	<script src="<%=request.getContextPath()%>/static/js/custom.min.js"></script>
	<script>
		$(document).ready(function() {
			$("#example").DataTable();
		});
	</script>
</body>
</html>