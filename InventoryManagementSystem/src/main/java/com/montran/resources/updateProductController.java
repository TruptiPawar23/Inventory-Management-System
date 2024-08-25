package com.montran.resources;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.montran.model.Category;
import com.montran.model.Product;
import com.montran.services.CategoryDao;
import com.montran.services.ProductDao;


/**
 * Servlet implementation class updateProductController
 */
@WebServlet("/update")
public class updateProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		String product_name = request.getParameter("product_name");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		double price = Double.parseDouble(request.getParameter("price"));
		Date man_date = null;
		Date exp_date = null;
		try {
			man_date = new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("man_date")) ;
			exp_date = new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("exp_date"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String category = request.getParameter("category");
		Category ctg = CategoryDao.getCategoryByName(category);
		
		Product prod = new Product(product_id, product_name, quantity, price, man_date, exp_date, ctg);
		ProductDao.updateProduct(prod);
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
