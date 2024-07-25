package com.ecommerce.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.dao.DAO;
import com.ecommerce.entity.Account;

/**
 * Servlet implementation class SignUpControl
 */
@WebServlet("/signup")
public class SignUpControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpControl() {
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
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String user= request.getParameter("user");
		String pass= request.getParameter("pass");
		String repass= request.getParameter("repass");
		if(!pass.equals(repass)) {
			System.out.println("xác thực mật khẩu sai");
			response.sendRedirect("Login&Register.jsp");
		}
		else {
			DAO dao=new DAO();
			Account a =dao.checkAcountExit(user);
			if(a==null) {
				//dc sign up
				dao.SignUp(user,pass);
				response.sendRedirect("HomeControl");
				
				
			}else {
				System.out.println("Chưa thêm được ");
				response.sendRedirect("Login&Register.jsp");
			}
			
			
		}
	}

}
