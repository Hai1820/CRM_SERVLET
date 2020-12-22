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
import com.myclass.entity.Job;
import com.myclass.repository.JobRepository;

@WebServlet(name = "job", urlPatterns = { UrlConstants.URL_JOB, UrlConstants.URL_JOB_ADD, UrlConstants.URL_JOB_EDIT,
		UrlConstants.URL_JOB_DELETE })
public class JobController extends HttpServlet {

	/**
	 * created on 6/12/2020 by Nguyen Hoang Hai
	 */
	private static final long serialVersionUID = 1L;
	private JobRepository jobRepository;

	@Override
	public void init() throws ServletException {
		jobRepository = new JobRepository();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
//		created on 6/12/2020 by Nguyen Hoang Hai
//		get all list job
		case UrlConstants.URL_JOB:
			List<Job> jobs = jobRepository.getAllJob();
			req.setAttribute("jobs", jobs);
			req.getRequestDispatcher("/WEB-INF/views/groupwork/groupwork.jsp").forward(req, resp);
			break;
//			created on 6/12/2020 by Nguyen Hoang Hai
//			add new job
		case UrlConstants.URL_JOB_ADD:
			req.getRequestDispatcher("/WEB-INF/views/groupwork/groupwork-add.jsp").forward(req, resp);
			break;
//			created on 6/12/2020 by Nguyen Hoang Hai
//			edit job 
		case UrlConstants.URL_JOB_EDIT:
			int id = Integer.valueOf(req.getParameter("id"));
			Job job = jobRepository.findById(id);
			req.setAttribute("job", job);
			req.getRequestDispatcher("/WEB-INF/views/groupwork/groupwork-edit.jsp").forward(req, resp);
			break;
//			created on 6/12/2020
//			delete job
		case UrlConstants.URL_JOB_DELETE:
			int idDelete = Integer.parseInt(req.getParameter("id"));
			jobRepository.deleteById(idDelete);
			resp.sendRedirect(req.getContextPath() + UrlConstants.URL_JOB);
			break;
		}

	}

	/**
	 *created on 6/12/2020 by Nguyen Hoang Hai
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		get servlet path 
		String path = req.getServletPath();
//		get pameter
		String name = req.getParameter("name");
		String startDateFormat = req.getParameter("startDate");
		String endDateFormat = req.getParameter("endDate");
		Date startDate = TimeHelper.convertStringToSQLDate(startDateFormat);
		Date endDate = TimeHelper.convertStringToSQLDate(endDateFormat);

		switch (path) {
//		created on 6/12/2020 by Nguyen Hoang Hai
//		add new job
		case UrlConstants.URL_JOB_ADD:
			Job job = new Job();

			job.setName(name);
			job.setStartDate(startDate);
			job.setEndDate(endDate);
			System.out.println(job);
			int result = jobRepository.save(job);
			if (result == -1) {
				System.out.println("them khong thanh cong");
			}
			resp.sendRedirect(req.getContextPath() + UrlConstants.URL_JOB);
			break;
//			created on 6/12/2020
//			edit job
		case UrlConstants.URL_JOB_EDIT:
			int id = Integer.parseInt(req.getParameter("id"));
			Job jobEdit = jobRepository.findById(id);
			jobEdit.setName(name);
			jobEdit.setStartDate(startDate);
			jobEdit.setEndDate(endDate);
			jobRepository.updateJobById(jobEdit);
			resp.sendRedirect(req.getContextPath() + UrlConstants.URL_JOB);
			break;

		}
//		
//		cái này phải chịu khó tí r
//		:v chieu h a 
//		ZoneDateTime hình như mysql ko support
//		có thằng này vào là nhanh r con không phải chịu khó tí
	}
}
