package com.ecommerce.control;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/hello") // Định nghĩa URL pattern cho servlet
public class LogoutControl extends HttpServlet {

    private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session =request.getSession();
		session.removeAttribute("acc");
		response.sendRedirect("HomeControl");

       
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response); // Mặc định, POST cũng gọi đến doGet()
    }
}

