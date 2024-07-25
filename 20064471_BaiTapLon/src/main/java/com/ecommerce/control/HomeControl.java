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

@WebServlet("/HomeControl")
public class HomeControl extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public HomeControl() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Gọi DAO để lấy danh sách sản phẩm
    	DAO dao=new DAO();
		List<Product> productList=dao.getAllProducts();
		List<Product> productListnew=dao.get4Productsnew();
		
		List<Category> categoryList=dao.getAllCategory();
        
     
        request.setAttribute("productListnew", productListnew);
        request.setAttribute("categoryList", categoryList);
        // Đặt danh sách sản phẩm vào request attribute
        request.setAttribute("productList", productList);
        
        // Chuyển tiếp (forward) request và response đến JSP để hiển thị danh sách sản phẩm
        request.getRequestDispatcher("homepage.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    }

   
}

