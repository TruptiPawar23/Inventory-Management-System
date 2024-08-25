package com.montran.resources;

import java.io.IOException;
import java.util.List;
import com.montran.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.montran.services.AcceptRejectDisplayDao;

/**
 * Servlet implementation class RequestForwardController
 */
@WebServlet("/RequestForward")
public class RequestForwardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestForwardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<ConsumptionRequest> Requests=AcceptRejectDisplayDao.display();
		
		request.setAttribute("pendingRequest",Requests);
		RequestDispatcher dispatch=request.getRequestDispatcher("AdminRequest.jsp");
		dispatch.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}