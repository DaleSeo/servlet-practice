package seo.dale.practice.servlet.session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = { "/session/login" })
public class SessionLoginServlet extends HttpServlet {

	private String servletUsername = "Dale";
	private String servletPassword = "Seo";

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<h1>Session Login</h1>");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (servletUsername.equals(username) && servletPassword.equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setMaxInactiveInterval(30 * 60); //setting session to expiry in 30 mins
			out.printf("<p>Hi, %s. Logged in successfully</p>%n", username);
		} else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/LoginForm.html");
			out.println("<font color=red>Either user name or password is wrong.</font>");
			dispatcher.include(request, response);
		}
	}

}