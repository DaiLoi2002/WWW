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
 * Servlet implementation class AddControlManager
 */
@WebServlet("/add")
public class AddControlManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddControlManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String pname=request.getParameter("name");
		String pimage=request.getParameter("image");
		String pprice=request.getParameter("price");
		String ptitle=request.getParameter("title");
		String pdescription=request.getParameter("description");
		String pcategory=request.getParameter("category");
		
		HttpSession session=request.getSession();
		Account a= (Account) session.getAttribute("acc");
		int sid=a.getId();
		
		DAO dao= new DAO();
		dao.InsertProduct(pname, pimage, pprice, ptitle, pdescription, pcategory, sid);
		response.sendRedirect("manager");
		
		
		
		
		doGet(request, response);
	}

}
