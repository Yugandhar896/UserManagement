package logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowAllUsers
 */
@WebServlet("/ShowAllUsers")
public class ShowAllUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session= request.getSession();
		
		String email=(String)session.getAttribute("email");
		out.print("<h2>Welcome,"+email+"</h2>");
		out.print("<table border = 1><tr><td>ID</td><td>Name</td><td>Username</td><td>Password</td><td>Delete User</td></tr>");
        List<User> users = UserDAO.getAllUsersDetails();

        for (User user : users) {
            out.print("<tr>");
            out.print("<td>" + user.getUserId() + "</td>");
            out.print("<td>" +user.getName()+"</td>");
            out.print("<td>" + user.getUserName() + "</td>");
            out.print("<td>" + user.getPassword() + "</td>");
            out.print("<td><a href=DeleteServlet?id=" + user.getUserId() +">Delete</a></td>");
            out.print("</tr>");
        }
        out.print("</table>");
	}

}
