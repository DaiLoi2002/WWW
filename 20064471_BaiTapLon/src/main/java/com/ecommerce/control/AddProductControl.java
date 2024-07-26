package com.ecommerce.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.dao.DAO;
import com.ecommerce.entity.Product;

/**
 * Servlet implementation class AddProductControl
 */
@WebServlet("/addproduct")
public class AddProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductControl() {
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
		DAO dao=new DAO();
		HttpSession session = request.getSession();
//        int userId, int productId, int quantity
		Integer userId=(Integer) session.getAttribute("accountID");
		Integer productId=(Integer) session.getAttribute("productID");
		String quantity=request.getParameter("quantity");
		Integer intQuantity= Integer.parseInt(quantity);
		try {
			dao.addToCart(userId, productId, intQuantity);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 request.getRequestDispatcher("cart").forward(request, response);
	}

}
