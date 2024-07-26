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
import com.ecommerce.entity.Product;
@WebServlet("/addproduct")
public class AddProductControl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddProductControl() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAO dao = new DAO();
        HttpSession session = request.getSession();

        // Retrieve session attributes and parameters
        Integer userId = (Integer) session.getAttribute("accountID");
        Integer productId = (Integer) session.getAttribute("productID");
        String quantityStr = request.getParameter("quantity");

        // Validate and parse quantity
        Integer intQuantity = null;
        try {
            if (quantityStr != null && !quantityStr.isEmpty()) {
                intQuantity = Integer.parseInt(quantityStr);
            }
        } catch (NumberFormatException e) {
            // Handle invalid quantity format
            request.setAttribute("errorMessage", "Invalid quantity format");
            request.getRequestDispatcher("Login&Register.jsp").forward(request, response);
            return;
        }

        // Check for null values
        if (userId == null || productId == null || intQuantity == null) {
            request.setAttribute("errorMessage", "Missing required data");
            request.getRequestDispatcher("Login&Register.jsp").forward(request, response);
            return;
        }

        try {
            // Add to cart
            dao.addToCart(userId, productId, intQuantity);
            
            // Redirect to the cart page
            response.sendRedirect("cart");
        } catch (SQLException e) {
            // Log the error and notify the user
            e.printStackTrace(); // Consider using a logging framework
            request.setAttribute("errorMessage", "Database error occurred");
            request.getRequestDispatcher("Login&Register.jsp").forward(request, response);
        }
    }
}
