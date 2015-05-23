package hu.neuron.java.warehouse.web.util;

import hu.neruon.java.warehouse.ejb.client.vo.UserVO;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
	
	private static final String ACTUAL_USER = "ACTUAL_USER";

	private SessionUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static void setActualUser(UserVO user, HttpServletRequest request){
		request.getSession().setAttribute(ACTUAL_USER, user);
	}
	
	public static UserVO getActualUser(HttpServletRequest request){
		return (UserVO) request.getSession().getAttribute(ACTUAL_USER);
	}
}
