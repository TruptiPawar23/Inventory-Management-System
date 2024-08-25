package com.montran.resources;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.montran.model.*;
import com.montran.services.CategoryDao;
/**
 * Servlet implementation class updateCategory
 */
@WebServlet("/updateCategory")
public class updateCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ctgid = Integer.parseInt(request.getParameter("category_id"));
		String catname=request.getParameter("category_name");
		Category ctg = new Category(ctgid, catname);
		CategoryDao.updateCategory(ctg);
		response.sendRedirect("viewCategories.jsp");
	}

}