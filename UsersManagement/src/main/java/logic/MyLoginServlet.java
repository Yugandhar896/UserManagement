package logic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyLoginServlet
 */
@WebServlet("/LoginServlet")
public class MyLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//response.getWriter().print("<h2>Welcome to Servlet</h2>");
		//response.getWriter().print(request.getParameter("email"));
		
		response.setContentType("text/html");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		HttpSession session= request.getSession();
		session.setAttribute("email",email);
		session.setAttribute("pass",pass);
		
		// check if email is admin@gmail.com and pass is Admin@123
		if (email.equals("admin@gmail.com")&&pass.equals("Admin@123")) {
			//response.getWriter().print("Admin login sucessfully");
			//create 
			RequestDispatcher rd = request.getRequestDispatcher("adminServlet");
			//
			rd.forward(request, response);
		} else if (UserDAO.validateUser(email,pass)) {
			response.getWriter().print("Login Sucess");
			RequestDispatcher rd = request.getRequestDispatcher("UserHome");
			rd.include(request, response);
		}
		else {
			response.getWriter().print("Login failed");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
		
		
	}
	

}
