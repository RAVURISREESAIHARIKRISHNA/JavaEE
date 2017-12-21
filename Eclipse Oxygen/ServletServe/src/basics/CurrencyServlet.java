package basics;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/CurrencyServlet")
public class CurrencyServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String src = request.getParameter("amount");
		boolean exception = false;
		double amount = Double.parseDouble(src);

		PrintWriter pw = response.getWriter();

		pw.println("<html><head><title>Currency Conversion</title></head><body><h1>");
		pw.println(amount * 68);
		pw.println("</h1></body></html>");
	}

}
