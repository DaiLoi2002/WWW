package com.ecommerce.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.dao.DAO;

/**
 * Servlet implementation class DeleteProductControl
 */
@WebServlet("/deleteServlet")
public class DeleteProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductControl() {
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
		doGet(request, response);
		DAO dao = new DAO();
		
		 String cartDetailIdParam = request.getParameter("productId");
		 
		 
		 if (cartDetailIdParam != null) {
			 	  try {
			 		 int cartDetailId = Integer.parseInt(cartDetailIdParam);
		                // Xử lý xóa sản phẩm từ giỏ hàng
		                dao.deleteCartDetail(cartDetailId);

		                // Chuyển hướng đến trang thành công
		                response.sendRedirect("cart"); // Hoặc trang nào đó bạn muốn chuyển hướng đến
		                
				} catch (Exception e) {
					// TODO: handle exception
					 e.printStackTrace();
		                response.sendRedirect("error.jsp");
				}
			 
			 
			 
	            
	        } else {
	            response.sendRedirect("error.jsp"); // Xử lý nếu không có cartDetailId
	        }
	    }

	}


