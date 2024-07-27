package com.ecommerce.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.dao.DAO;
import com.ecommerce.entity.Account;

/**
 * Servlet implementation class EditControl
 */
@WebServlet("/edit")
public class EditControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String pid=request.getParameter("id");
		String pname=request.getParameter("name");
		String pimage=request.getParameter("image");
		String pprice=request.getParameter("price");
		String ptitle=request.getParameter("title");
		String pdescription=request.getParameter("description");
		String pcategory=request.getParameter("category");
	
		
		DAO dao= new DAO();
		dao.editProduct(pname, pimage, pprice, ptitle, pdescription, pcategory, pid);
		response.sendRedirect("manager");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
