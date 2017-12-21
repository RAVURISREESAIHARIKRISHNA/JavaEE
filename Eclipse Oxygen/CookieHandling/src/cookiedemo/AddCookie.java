package cookiedemo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import java.io.PrintWriter;


@WebServlet("/AddCookie")
public class AddCookie extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cookieName = request.getParameter("cookieName");
		String cookieValue = request.getParameter("cookieValue");
		String maxAgeInp = request.getParameter("cookieAge");
		int maxAge = Integer.parseInt(maxAgeInp);
		Cookie cook = new Cookie(cookieName,cookieValue);
		cook.setMaxAge(maxAge);
		response.addCookie(cook);
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println("<head>\r\n" + 
				"        <title>Cookie Demo</title>\r\n" + 
				"    \r\n" + 
				"    </head><body><h1>COOKIE SET !</h1></body>");
		
	}

}
