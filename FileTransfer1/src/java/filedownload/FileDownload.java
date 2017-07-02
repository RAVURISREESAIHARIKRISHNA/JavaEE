package filedownload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FileDownload", urlPatterns = {"/FileDownload"})
public class FileDownload extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        try {
            String fileName = req.getParameter("FileDownload");
            System.out.println("***************");
            System.out.println(fileName);
            System.out.println("***************");
            

            File file = new File(fileName);
            if(!file.exists()){
                PrintWriter p = res.getWriter();
                res.setContentType("text/html");
                p.println("<h1>Sorry!</h1>");
                p.println("<h3>Try Something with a Different Name(VALID)");
                p.println("<br/>");
                p.println("<p>" + "Mail <a href=\"mailto:harirsskrishna@gmail.com\">Admin</a>Describing your Problem" + "</p>");
                return;
            }

            res.setContentType("application/pdf");
            res.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            OutputStream out_stream = res.getOutputStream();
            FileInputStream file_in_stream = new FileInputStream(file);
            byte buffer[] = new byte[1024];
            int length;
            while ((length = file_in_stream.read(buffer)) > 0) {
                out_stream.write(buffer, 0, length);
            }
            file_in_stream.close();
            out_stream.flush();
        } catch (Exception e) {
            PrintWriter pw = null;
            try {
                pw = res.getWriter();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            res.setContentType("text/html");
            pw.println("<h1>Sorry!</h1>");
            pw.println("<h3>Try Something with a Different Name(VALID)");
            pw.println("<br/>");
            pw.println("<p>" + "Mail <a href=\"mailto:harirsskrishna@gmail.com\">Admin</a>Describing your Problem" + "</p>");
        }
    }
}
