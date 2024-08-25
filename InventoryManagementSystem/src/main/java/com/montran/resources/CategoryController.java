package com.montran.resources;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.montran.model.*;
import com.montran.services.*;

/**
 * Servlet implementation class CatergoryController
 */
@WebServlet("/addCategory")
@MultipartConfig
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private CategoryDao c;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() {
		c = new CategoryDao();
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String catid=request.getParameter("category_id");
		String catname=request.getParameter("category_name");
		Part img=request.getPart("img");
		String fileName = img.getSubmittedFileName();
		String path = "D:/Inventory Management System/InventoryManagementSystem/images/"+fileName;
		try {
			FileOutputStream fout = new FileOutputStream(path);
			InputStream in = img.getInputStream();
			byte[] data = new byte[in.available()];
			in.read(data);
			fout.write(data);
			fout.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		Category ctg = new Category();
		int id=Integer.parseInt(catid);
		ctg.setCategory_id(id);
		ctg.setCategory_name(catname);
		ctg.setImgFileName(fileName);
		c.saveCategory(ctg);
		response.sendRedirect("addCategories.jsp");
		}
	}