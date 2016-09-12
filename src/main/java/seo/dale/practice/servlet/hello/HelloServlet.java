package seo.dale.practice.servlet.hello;

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
 * @author Dale Seo
 */
@WebServlet(
	description = "User Servlet",
	urlPatterns = {"/hello.do"},
	initParams = {@WebInitParam(name="id",value="1"), @WebInitParam(name="name",value="pankaj")}
)
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String HTML_START="<html><body>";
	private static final String HTML_END="</body></html>";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Date date = new Date();
		out.println(HTML_START + "<h2>Hello Servlet!</h2><br/><h3>Date="+date +"</h3>"+HTML_END);
	}

}