package seo.dale.practice.servlet.context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Servlet Tutorial - Servlet Example
 */
@WebServlet(
		description = "Context Servlet",
		urlPatterns = { "/ContextServlet" },
		initParams = {
				@WebInitParam(name = "username", value = "Dale"),
				@WebInitParam(name = "password", value = "Seo")
		}
)
public class ContextServlet extends HttpServlet {

	private static final String HTML_START="<html><body>";
	private static final String HTML_END="</body></html>";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dbURL = getServletContext().getInitParameter("dbURL");
		String dbUser = getServletContext().getInitParameter("dbUser");
		String dbUserPwd = getServletContext().getInitParameter("dbUserPwd");

		PrintWriter out = response.getWriter();
		Date date = new Date();
		out.println(HTML_START + "<dl>");
		out.println("<dt>dbURL</dt><dd>" + dbURL + "</dd>");
		out.println("<dt>dbUser</dt><dd>" + dbUser + "</dd>");
		out.println("<dt>dbUserPwd</dt><dd>" + dbUserPwd + "</dd>");
		out.println("</dl>"+HTML_END);
	}

}
