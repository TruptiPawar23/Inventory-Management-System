package com.montran.resources;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.montran.model.*;
import com.montran.model.ConsumptionRequest.RequestStatus;
import com.montran.services.ConsumeRequest;
import com.montran.services.ProductDao;

/**
 * Servlet implementation class ConsumeController
 */
@WebServlet("/Consume")
public class ConsumeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConsumeController() {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id2 = request.getParameter("id");
		int id = Integer.parseInt(id2);

		Product pd = ProductDao.getProductByID(id);
		String name = pd.getProduct_name();
		int quantity = pd.getQuantity();

		ConsumptionRequest request1 = new ConsumptionRequest();
		request1.setItemid(id);
		request1.setStatus(ConsumptionRequest.RequestStatus.PENDING);
		request1.setName(name);
		request1.setQuantity(quantity);

		ConsumeRequest.save(request1);

		RequestDispatcher req = request.getRequestDispatcher("userView.jsp");
		req.include(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}