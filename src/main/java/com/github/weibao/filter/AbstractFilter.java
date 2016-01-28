package com.github.weibao.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public abstract class AbstractFilter implements Filter {
	private static Logger logger= LoggerFactory.getLogger(AbstractFilter.class);

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		logger.info("------开始doFilter过滤--------");
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession(false);
		String menthod = request.getMethod();

		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());


/*		System.out.println("requestUri: " + requestUri);
		System.out.println("contextPath: " + contextPath);
		System.out.println("url: " + url);*/

		doFilter(request, response, chain, session, menthod, url);
		logger.info("------doFilter过滤结束--------");
	}

	/**
	 *
	 * @param request
	 *            request
	 * @param response
	 *            response
	 * @param session
	 *            session 可能为空
	 * @param menthod
	 *            menthod
	 * @param url
	 *            url
	 */
	public abstract void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain,
			HttpSession session, String menthod, String url)
			throws IOException, ServletException;

}
