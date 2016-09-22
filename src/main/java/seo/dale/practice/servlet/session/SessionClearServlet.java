package seo.dale.practice.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = { "/session/clear" })
public class SessionClearServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h1>Session Clear</h1>");


		HttpSession session = request.getSession(false);
		if (session == null) {
			out.println("<p>No session!</p>");
			return;
		}

		session.invalidate();
		out.println("<p>session cleared!</p>");
	}

}
