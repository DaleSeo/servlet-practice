package seo.dale.practice.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = { "/cookie/add" })
public class CookieAddServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String value = request.getParameter("value");
		String maxAge = request.getParameter("maxAge");

		Cookie cookie = new Cookie(name, value);
		if (maxAge != null) {
			cookie.setMaxAge(Integer.parseInt(maxAge));
		}
		response.addCookie(cookie);

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h1>Cookie Add</h1>");
		out.println("<p>cookie added!</p>");
	}

}
