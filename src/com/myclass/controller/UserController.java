package com.myclass.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.myclass.constants.UrlConstants;
import com.myclass.dto.UserDto;
import com.myclass.entity.Role;
import com.myclass.entity.User;
import com.myclass.repository.RoleRepository;
import com.myclass.repository.UserRepository;

@WebServlet(name = "user", urlPatterns = { UrlConstants.URL_USER, UrlConstants.URL_USER_ADD, UrlConstants.URL_USER_EDIT,
		UrlConstants.URL_USER_DELETE })
public class UserController extends HttpServlet {

	/**
	 * created on 2/12/2020 by Nguyen Hoang Hai
	 */
	private RoleRepository roleRepository;
	private UserRepository userRepository;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		roleRepository = new RoleRepository();
		userRepository = new UserRepository();
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case UrlConstants.URL_USER:
			List<UserDto> users = userRepository.getAllUsers();
			req.setAttribute("users", users);
			req.getRequestDispatcher("WEB-INF/views/user/user-table.jsp").forward(req, resp);
			break;
		case UrlConstants.URL_USER_ADD:
			List<Role> roles = roleRepository.getAllRole();
			req.setAttribute("roles", roles);
			req.getRequestDispatcher("/WEB-INF/views/user/user-add.jsp").forward(req, resp);
			break;
		case UrlConstants.URL_USER_EDIT:
			int id = Integer.parseInt(req.getParameter("id"));
			User user = userRepository.findById(id);
			req.setAttribute("user", user);
			req.setAttribute("roles", roleRepository.getAllRole());
			req.getRequestDispatcher("/WEB-INF/views/user/user-edit.jsp").forward(req, resp);
			break;
		case UrlConstants.URL_USER_DELETE:
			int idDelete = Integer.parseInt(req.getParameter("id"));
			userRepository.deleteById(idDelete);
			resp.sendRedirect(req.getContextPath() + UrlConstants.URL_USER);
			break;
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
//		get servlet path
		String path = req.getServletPath();
//		get parameter
		String email = req.getParameter("email");
		String fullName = req.getParameter("fullname");
		String password = req.getParameter("password");
		String avatar = req.getParameter("avatar");
		int roleId = Integer.parseInt(req.getParameter("roleId"));
		switch (path) {
		case UrlConstants.URL_USER_ADD:
			String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
			User user = new User();
			user.setEmail(email);
			user.setFullName(fullName);
			user.setAvatar(avatar);
			user.setPassword(hashed);
			user.setRoleId(roleId);
			int result = userRepository.save(user);
			if (result != -1) {
				System.out.println("INSERT UNSUCCESSFULLY");
			}
			resp.sendRedirect(req.getContextPath() + UrlConstants.URL_USER);
			break;
		case UrlConstants.URL_USER_EDIT:
			int id = Integer.valueOf(req.getParameter("id"));
			User userEdit = userRepository.findById(id);
			userEdit.setEmail(email);
			userEdit.setFullName(fullName);
			userEdit.setAvatar(avatar);
			userEdit.setRoleId(roleId);
			// KIỂM TRA XEM NGƯỜI DÙNG NHẬP MẬT KHẨU MỚI KHÔNG
			if (password != null && !password.isEmpty()) {
				// MÃ HÓA MẬT KHẨU
				String hashed2 = BCrypt.hashpw(password, BCrypt.gensalt(12));
				// CẬP NHẬT THÔNG TIN USER (BAO GỒM CẢ KHẨU)
				userEdit.setPassword(hashed2);
			}
			int resultEdit = userRepository.update(userEdit);
			if (resultEdit != -1) {
				System.out.println("UPDATE SUCCESSFULLY");
			} else {
				System.out.println("UPDATE UNSUCCESSFULLY");
			}
			resp.sendRedirect(req.getContextPath() + UrlConstants.URL_USER);
			break;
		}
	}
}
