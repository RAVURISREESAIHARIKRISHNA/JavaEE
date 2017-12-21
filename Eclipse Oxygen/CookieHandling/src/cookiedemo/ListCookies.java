package cookiedemo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import java.io.PrintWriter;

@WebServlet("/ListCookies")
public class ListCookies extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cooks[] = request.getCookies();
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String data = "<head>\r\n" + 
				"        <title>Cookie Demo</title>\r\n" + 
				"    \r\n" + 
				"    </head><body><h1>Cookies</h1><table><tr><th>Name</th><th>Value</th></tr>";
		for(Cookie cook : cooks) {
			data = data + "<tr><td>"+cook.getName()+"</td><td>"+cook.getValue()+"</td></tr>";
		}
		data = data + "</table></body>";
		pw.println(data);
	}
}
