package seo.dale.practice.servlet.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet Tutorial - Servlet Example
 */
@WebServlet(
	description = "Login Servlet",
	urlPatterns = { "/LoginServlet" },
	initParams = {
		@WebInitParam(name = "username", value = "Dale"),
		@WebInitParam(name = "password", value = "Seo")
	}
)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get request parameters for userID and password
		String paramUsername = request.getParameter("user");
		String paramPassword = request.getParameter("pwd");

		//get servlet config init params
		String servletUsername = getServletConfig().getInitParameter("username");
		String servletPassword = getServletConfig().getInitParameter("password");

		//logging example
		log("paramUsername="+paramUsername+"::paramPassword="+paramPassword);

		if (servletUsername.equals(paramUsername) && servletPassword.equals(paramPassword)) {
			response.sendRedirect("/view/login/LoginSuccess.jsp");
		} else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/login/login.html");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			dispatcher.include(request, response);
		}
	}

}