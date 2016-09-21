package seo.dale.practice.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = { "/cookie/list" })
public class CookieListServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Cookie List</h1>");
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				out.println("<hr/>");
				out.println("<ul>");
				out.printf("<li>%s : %s</li>%n", "name", cookie.getName());
				out.printf("<li>%s : %s</li>%n", "value", cookie.getValue());
				out.printf("<li>%s : %s</li>%n", "domain", cookie.getDomain());
				out.printf("<li>%s : %s</li>%n", "path", cookie.getPath());
				out.printf("<li>%s : %s</li>%n", "maxAge", cookie.getMaxAge());
				out.println("</ul>");
			}

		}
	}

}
