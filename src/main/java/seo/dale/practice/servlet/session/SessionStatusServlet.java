package seo.dale.practice.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

@WebServlet(urlPatterns = { "/session/status" })
public class SessionStatusServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Session Status</h1>");

		HttpSession session = request.getSession(false);
		if (session == null) {
			out.println("<hr/>");
			out.println("<p>No session</p>");
			return;
		}

		out.println("<hr/>");
		out.println("<ul>");
		out.printf("<li>%s : %s</li>%n", "ID", session.getId());
		out.printf("<li>%s : %s</li>%n", "New", session.isNew());
		out.printf("<li>%s : %s</li>%n", "Max Inactive Interval", session.getMaxInactiveInterval());
		out.printf("<li>%s : %s</li>%n", "Creation Time", new Date(session.getCreationTime()));
		out.printf("<li>%s : %s</li>%n", "Last Accessed Time", new Date(session.getLastAccessedTime()));
		out.println("</ul>");

		Enumeration<String> enumeration = session.getAttributeNames();
		if (enumeration == null) {
			out.println("<hr/>");
			out.println("<p>No session attributes</p>");
			return;
		}

		out.println("<hr/>");
		out.println("<ul>");

		while (enumeration.hasMoreElements()) {
			String attributeName = enumeration.nextElement();
			out.printf("<li>%s : %s</li>%n", attributeName, session.getAttribute(attributeName));
		}

		out.println("</ul>");
	}

}
