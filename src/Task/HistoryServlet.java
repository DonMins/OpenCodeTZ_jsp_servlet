package Task;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        performTask(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        performTask(req, resp);
    }

    protected void performTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clear = req.getParameter("clear").trim();
        if (clear.equals("yes")){
            try (FileWriter writer = new FileWriter("C:\\history.txt", false)) {
                writer.write("");
                writer.flush();
            }catch (IOException ex) {
                ex.getMessage();
            }
        }
            resp.setContentType("text/plain; charset=UTF-8");
            OutputStream outStream = resp.getOutputStream();
            String content = "";
            try {
                FileInputStream fstream = new FileInputStream("C:/history.txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    content = content + strLine + "\n";
                }

            } catch (IOException e) {
                e.getMessage();
            }
            outStream.write(content.getBytes("UTF-8"));
            outStream.flush();
            outStream.close();

    }

}