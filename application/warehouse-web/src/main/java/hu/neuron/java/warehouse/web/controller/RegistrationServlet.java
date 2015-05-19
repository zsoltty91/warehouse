package hu.neuron.java.warehouse.web.controller;

import hu.neruon.java.warehouse.ejb.client.service.DeviceServiceFacadeBeanLocal;
import hu.neruon.java.warehouse.ejb.client.vo.DeviceBasedataVO;
import hu.neruon.java.warehouse.ejb.client.vo.PropertyVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * This servlet handles the message box.
 */
@WebServlet(name = "/servlet", urlPatterns = "/servlet")
@EJB(name = "hu.neuron.warehouse.ejb.DeviceServiceFacadeBeanLocal", beanInterface = DeviceServiceFacadeBeanLocal.class)
public class RegistrationServlet extends HttpServlet {
	@EJB
	DeviceServiceFacadeBeanLocal deviceService;

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(RegistrationServlet.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		try {
			List<DeviceBasedataVO> s = deviceService.createDevices(new ArrayList<DeviceBasedataVO>());
			response.getWriter().write("hello");

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
}
