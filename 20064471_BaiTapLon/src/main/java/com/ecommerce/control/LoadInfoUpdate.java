package com.ecommerce.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.dao.DAO;
import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;

/**
 * Servlet implementation class LoadInfoUpdate
 */
@WebServlet("/loadProduct")
public class LoadInfoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadInfoUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String pid=request.getParameter("pid");
		DAO dao=new DAO();
		
		List<Category> categoryList=dao.getAllCategory();
		Product p=dao.getProductsBYID(pid);
		request.setAttribute("detail", p);
		
		  request.setAttribute("categoryList", categoryList);
		
		request.getRequestDispatcher("Edit.jsp").forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
