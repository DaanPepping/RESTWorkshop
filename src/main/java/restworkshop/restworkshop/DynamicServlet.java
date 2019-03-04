package restworkshop.restworkshop;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class DynamicServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("username");
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("  <title>Dynamic Example</title>");
		out.println("  <body>");
		out.println("    <h2>Dynamic webapplication example</h2>");
		out.println("    <h2>Hello " + name + "!</h2>");
		out.println("  </body>");
		out.println("</html>");
	}
}