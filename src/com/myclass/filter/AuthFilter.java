package com.myclass.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myclass.constants.SessionContants;
import com.myclass.constants.UrlConstants;

@WebFilter(urlPatterns = { "/*" })
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String action = req.getServletPath();
		if (action.equals(UrlConstants.URL_LOGIN)) {
			chain.doFilter(request, response);
			return;
		}

		HttpSession session = req.getSession();

		if (session.getAttribute(SessionContants.USER_LOGIN) == null) {
			resp.sendRedirect(req.getContextPath() + UrlConstants.URL_LOGIN);
			return;
		}
		chain.doFilter(request, response);
	}

}
