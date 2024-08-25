package com.montran.resources;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.montran.model.ConsumptionRequest;
import com.montran.model.Product;

/**
 * Servlet implementation class AdminApproveReject
 */
@WebServlet("/ApproveReject")
public class AdminApproveReject extends HttpServlet {
	static SessionFactory factory = new Configuration().configure().buildSessionFactory();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminApproveReject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session=factory.openSession();
		
		
		int id=Integer.parseInt(request.getParameter("requestId"));
		String action=request.getParameter("action");
		Transaction tx=session.beginTransaction();
		ConsumptionRequest requestt=session.get(ConsumptionRequest.class,id);
		
		if(requestt!=null) {
			requestt.setStatus(action.equals("accept")?ConsumptionRequest.RequestStatus.APPROVED:ConsumptionRequest.RequestStatus.REJECTED);
			session.update(requestt);
			if(action.equals("accept")) {
				Product pd=session.get(Product.class,requestt.getItemid());
				if(pd!=null) {
					pd.setQuantity(pd.getQuantity()-1);
					session.update(pd);
				}
			}
		}
		tx.commit();
		response.sendRedirect("viewProduct.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}