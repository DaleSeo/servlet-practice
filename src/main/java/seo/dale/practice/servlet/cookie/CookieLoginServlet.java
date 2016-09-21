package seo.dale.practice.servlet.cookie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = { "/cookie/login" })
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String servletUsername = "Dale";
	private String servletPassword = "Seo";

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					String username = cookie.getValue();
					PrintWriter out= response.getWriter();
					out.println(username + ", You're already logged in.");
					return;
				}
			}
		}

		//get request parameters for username and password
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (servletUsername.equals(username) && servletPassword.equals(password)) {
			Cookie loginCookie = new Cookie("username", username);
			//setting cookie to expiry in 30 mins
			loginCookie.setMaxAge(30 * 60);
			response.addCookie(loginCookie);
			response.sendRedirect("/cookie/LoginSuccess.jsp");
		} else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cookie/LoginForm.html");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			dispatcher.include(request, response);
		}
	}

}