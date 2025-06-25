package com.kh.common.interceptor;

import java.lang.reflect.Method;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
	private static final String USER_INFO = "userInfo";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("[PRE_HANDLE]");

		String requestURI = request.getRequestURI();
		log.info("requestURI : " + requestURI);
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method methodObj = handlerMethod.getMethod();
		log.info("Bean: " + handlerMethod.getBean());
		log.info("Method: " + methodObj);
		HttpSession session = request.getSession();
		if (session.getAttribute(USER_INFO) != null) {
			session.removeAttribute(USER_INFO);
			log.info("Session Delete");
		}
		return true;
	}

	/*
	 * @Override public void postHandle(HttpServletRequest request,
	 * HttpServletResponse response, Object handler, ModelAndView modelAndView)
	 * throws Exception { log.info("[POST_HANDLE]");
	 * 
	 * String requestURL = request.getRequestURI(); log.info("requestURL : " +
	 * requestURL);
	 * 
	 * HandlerMethod method = (HandlerMethod) handler; Method methodObj =
	 * method.getMethod(); log.info("Bean:" + method.getBean()); log.info("Method:"
	 * + methodObj); HttpSession session = request.getSession(); ModelMap modelMap =
	 * modelAndView.getModelMap(); Object member = modelMap.get("user"); if (member
	 * != null) { log.info("member != null"); session.setAttribute(USER_INFO,
	 * member); response.sendRedirect("/success"); } }
	 * 
	 * @Override public void afterCompletion(HttpServletRequest request,
	 * HttpServletResponse response, Object handler, Exception ex) throws Exception
	 * { log.info("[AFTER_COMPLETION]");
	 * HandlerInterceptor.super.afterCompletion(request, response, handler, ex); }
	 */

}
