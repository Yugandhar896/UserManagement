package logic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetUserByIdServlet
 */
@WebServlet("/GetUserByIdServlet")
public class GetUserByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		response.setContentType("text/html");
		out.print("<strong><em>Welcome,"+email+"</em></strong><br>");
		 out.print("<form action='UserDetailsServlet'>");
		 out.print("<b>ID :</b><input type='text' name='id' ><br>");
		 out.print("</form>");
	}

}
