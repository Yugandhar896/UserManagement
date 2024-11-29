package logic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/adminServlet")
public class adminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		String email=request.getParameter("email");
		out.print("<h2>Welcome,"+email+"</h2>");
		out.print("<div style='text-align:center;'>");
		out.print("<H1>Admin Home</H1>");
		out.print("<a href='ShowAllUsers'>Show All Users Details</a><br><br>");
		out.print("<a href='GetUserByIdServlet'>Show User Details By ID</a></div>");
		out.print("</div>");
	}

}
