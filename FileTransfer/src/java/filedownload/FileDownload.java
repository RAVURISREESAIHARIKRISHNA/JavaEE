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
    public void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException , IOException{
        File file = new File("C:\\Users\\HARI\\Desktop\\Eclipse Keyboard Shortcuts.pdf");
        res.setContentType("application/pdf");
        res.setHeader("Content-Disposition", "attachment; filename=Eclipse Keyboard Shortcuts.pdf");
        OutputStream out_stream = res.getOutputStream();
        FileInputStream file_in_stream = new FileInputStream(file);
        byte buffer[] = new byte[1024];
        int length;
        while((length = file_in_stream.read(buffer))>0){
            out_stream.write(buffer, 0, length);
        }
        file_in_stream.close();
        out_stream.flush();
    }
}
