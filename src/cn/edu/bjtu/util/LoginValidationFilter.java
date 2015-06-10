package cn.edu.bjtu.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginValidationFilter
 */
@WebFilter("/LoginValidationFilter")
/**   
 * 用于检测用户是否登陆的过滤器，如果未登录，则重定向到指的登录页面    
 * 配置参数   
 * checkSessionKey 需检查的在 Session 中保存的关键字    
 * redirectURL 如果用户未登录，则重定向到指定的页面，URL不包括 ContextPath    
 * notCheckURLList 不做检查的URL列表，以分号分开，并且 URL 中不包括 ContextPath   
 */
public class LoginValidationFilter implements Filter {

	protected FilterConfig filterConfig = null;
	private String redirectURL = null;
	private List notCheckURLList = new ArrayList();
	private String sessionKey = null;

	/**
	 * Default constructor.
	 */
	public LoginValidationFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		notCheckURLList.clear();
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		/*
		 * if(req.getSession().getAttribute("username").equals("") ||
		 * req.getSession().getAttribute("userId").equals("")) {
		 * res.sendRedirect("loginForm");//跳转到登录页面 } else // pass the request
		 * along the filter chain chain.doFilter(request, response);
		 */
		/*HttpSession session = req.getSession();
		if (sessionKey == null) {
			chain.doFilter(req, res);
			return;
		}*/
		/*if ((!checkRequestURIIntNotFilterList(req))
				&& session.getAttribute(sessionKey) == null) {
			res.sendRedirect(redirectURL);
			return;
		}*/
		/*if(req.getSession().getAttribute("username").equals("") || 
				req.getSession().getAttribute("userId").equals(""))
		{
			res.sendRedirect("loginForm");
			return;
		}*/
		if(req.getSession().getAttribute("username")==null || req.getSession().getAttribute("userId")==null)
		{
			res.sendRedirect("loginForm");
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		filterConfig = fConfig;
		redirectURL = filterConfig.getInitParameter("redirectURL");
		sessionKey = filterConfig.getInitParameter("checkSessionKey");

		String notCheckURLListStr = filterConfig
				.getInitParameter("notCheckURLList");

		if (notCheckURLListStr != null) {
			StringTokenizer st = new StringTokenizer(notCheckURLListStr, ";");
			notCheckURLList.clear();
			while (st.hasMoreTokens()) {
				notCheckURLList.add(st.nextToken());
			}
		}
	}

	private boolean checkRequestURIIntNotFilterList(HttpServletRequest request) {
		/*String uri = request.getServletPath()
				+ (request.getPathInfo() == null ? "" : request.getPathInfo());*/
		String uri=request.getPathInfo()+"";
		return notCheckURLList.contains(uri);
	}

}
