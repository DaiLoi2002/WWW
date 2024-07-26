package com.ecommerce.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.dao.DAO;
import com.ecommerce.entity.Cart;

/**
 * Servlet implementation class updateQuantityServlet
 */
@WebServlet("/updateQuantityServlet")
public class updateQuantityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateQuantityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        
   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				DAO dao=new DAO();
				response.getWriter().append("Served at: ").append(request.getContextPath());
				String cartDetailId = request.getParameter("cartDetailId");
		        String quantityStr = request.getParameter("quantity");
		        System.out.println("cartDetailId: " + cartDetailId);
		        System.out.println("quantity: " + quantityStr);
		        System.out.println("Servlet sửa quantity đã tồn tại");
		        
		       
		        try {
					dao.updateToTalprice(cartDetailId,quantityStr);
					 
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					  
				}
		       
	}

}
