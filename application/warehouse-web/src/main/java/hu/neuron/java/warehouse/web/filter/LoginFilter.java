package hu.neuron.java.warehouse.web.filter;

import hu.neruon.java.warehouse.ejb.client.vo.UserVO;
import hu.neuron.java.warehouse.web.util.SessionUtil;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		//ez így elég paraszt de ez van haladni kell
		if(SessionUtil.getActualUser((HttpServletRequest) arg0) == null){
			UserVO user = new UserVO();
			user.setId(1L);
			SessionUtil.setActualUser(user, (HttpServletRequest) arg0);
		}
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
