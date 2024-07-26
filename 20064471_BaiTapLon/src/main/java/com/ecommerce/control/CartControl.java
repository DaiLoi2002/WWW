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
import com.ecommerce.entity.Cart;
import com.ecommerce.entity.CartDetail;

/**
 * Servlet implementation class CartControl
 */
@WebServlet("/cart")
public class CartControl extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartControl() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy session và accountID từ session
        HttpSession session = request.getSession();
        Integer accountID = (Integer) session.getAttribute("accountID");

        String userId = String.valueOf(accountID);
        DAO dao = new DAO();
        Cart cart = null;

        try {
            // Gọi phương thức DAO để lấy giỏ hàng
            cart = dao.getCartByUserId(userId);
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi, có thể chuyển hướng đến trang lỗi hoặc hiển thị thông báo lỗi
            request.setAttribute("errorMessage", "An error occurred while retrieving cart details.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }

        if (cart == null) {
            // Nếu không tìm thấy giỏ hàng, có thể chuyển hướng đến trang thông báo hoặc hiển thị thông báo
            request.setAttribute("message", "No cart found for user.");
            request.getRequestDispatcher("message.jsp").forward(request, response);
        } else {
            // Đưa đối tượng cart vào request để sử dụng trong JSP
            request.setAttribute("cart", cart);
            request.getRequestDispatcher("CartShop.jsp").forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
