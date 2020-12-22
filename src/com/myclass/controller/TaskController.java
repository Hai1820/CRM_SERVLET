package com.myclass.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.common.helper.TimeHelper;
import com.myclass.constants.UrlConstants;
import com.myclass.dto.TaskDto;
import com.myclass.entity.Task;
import com.myclass.repository.JobRepository;
import com.myclass.repository.TaskRepository;
import com.myclass.repository.UserRepository;

@WebServlet(name = "task", urlPatterns = { UrlConstants.URL_TASK, UrlConstants.URL_TASK_ADD, UrlConstants.URL_TASK_EDIT,
		UrlConstants.URL_TASK_DELETE })
public class TaskController extends HttpServlet {

	/**
	 * created on 4/12/2020 by Nguyen Hoang Hai
	 */
	private static final long serialVersionUID = 1L;
	private TaskRepository taskRepository;
	private UserRepository userRepository;
	private JobRepository jobRepository;

	@Override
	public void init() throws ServletException {
		taskRepository = new TaskRepository();
		userRepository = new UserRepository();
		jobRepository = new JobRepository();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
//		created on 4/12/2020 by Nguyen Hoang Hai
//		get all task
		case UrlConstants.URL_TASK:
			List<TaskDto> tasks = taskRepository.getALlTasks();
			req.setAttribute("tasks", tasks);
			req.getRequestDispatcher("/WEB-INF/views/task/task.jsp").forward(req, resp);
			break;
//			created on 4/12/2020 By Nguyen Hoang Hai
//		add new task 
		case UrlConstants.URL_TASK_ADD:
			req.setAttribute("users", userRepository.getAllUsers());
			req.setAttribute("jobs", jobRepository.getAllJob());
			req.setAttribute("status", taskRepository.getAllStatus());
			req.getRequestDispatcher("/WEB-INF/views/task/task-add.jsp").forward(req, resp);
			break;
//			created on 2/12/2022 by Nguyen Hoang Hai
//			edit task
		case UrlConstants.URL_TASK_EDIT:
			int id = Integer.parseInt(req.getParameter("id"));
			Task task = taskRepository.findById(id);
			req.setAttribute("task", task);
			req.setAttribute("users", userRepository.getAllUsers());
			req.setAttribute("jobs", jobRepository.getAllJob());
			req.setAttribute("status", taskRepository.getAllStatus());
			req.getRequestDispatcher("/WEB-INF/views/task/task-edit.jsp").forward(req, resp);
			break;
//			created on 2/12/2020 by Nguyen Hoang Hai
//			delete task
		case UrlConstants.URL_TASK_DELETE:
			int idDelete = Integer.parseInt(req.getParameter("id"));
			taskRepository.deleteById(idDelete);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		get servlet path 
		String path = req.getServletPath();
//		get parameter
		int jobId = Integer.parseInt(req.getParameter("jobId"));
		int userId = Integer.parseInt(req.getParameter("userId"));
		int statusId = Integer.parseInt(req.getParameter("statusId"));
		String name = req.getParameter("name");
		String startDateFormat = req.getParameter("startDate");
		String endDateFormat = req.getParameter("endDate");
		Date startDate = TimeHelper.convertStringToSQLDate(startDateFormat);
		Date endDate = TimeHelper.convertStringToSQLDate(endDateFormat);
//		***************
		switch (path) {
//		created on 4/12/2020 by Nguyen Hoang Hai
//		add new task
		case UrlConstants.URL_TASK_ADD:
			Task task = new Task();
			task.setName(name);
			task.setUserId(userId);
			task.setJobId(jobId);
			task.setStatusId(statusId);
			task.setEndDate(endDate);
			task.setStartDate(startDate);
			taskRepository.save(task);

			resp.sendRedirect(req.getContextPath() + UrlConstants.URL_TASK);
			break;
//			created on 4/12/2020 by Nguyen Hoang Hai
//			edit task
		case UrlConstants.URL_TASK_EDIT:
			int id = Integer.parseInt(req.getParameter("id"));
			Task taskEdit = taskRepository.findById(id);
			taskEdit.setName(name);
			taskEdit.setUserId(userId);
			taskEdit.setJobId(jobId);
			taskEdit.setStatusId(statusId);
			taskEdit.setStartDate(startDate);
			taskEdit.setEndDate(endDate);
			taskRepository.updateById(taskEdit);
			resp.sendRedirect(req.getContextPath() + UrlConstants.URL_TASK);
			break;
		}

	}
}
