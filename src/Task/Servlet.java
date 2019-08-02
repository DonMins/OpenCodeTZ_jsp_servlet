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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Servlet extends HttpServlet {
    String listNumbers = "";
    boolean isGuessed = false;
    Task task = new Task(genNumber());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        performTask(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        performTask(req, resp);
    }

    protected void performTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String inputNumber = req.getParameter("inputNumber").trim();

        resp.setContentType("text/plain; charset=UTF-8");
        OutputStream outStream = resp.getOutputStream();


        String content = result(inputNumber);
        saveDateInFile(content+ "\n");
        listNumbers = listNumbers + content + "\n";

        outStream.write(listNumbers.getBytes("UTF-8"));
        outStream.flush();
        outStream.close();


    }

    private String result(String str) {
        String number = task.getNumber();
        System.out.println(number);

        ArrayList<Character> numberSymbol = new ArrayList<>();
        ArrayList<Character> strSymbol = new ArrayList<>();
        ArrayList<Character> l3 = new ArrayList<Character>();
        l3 = strSymbol;

        int bull = 0;
        int cow = 0;
        for (int i = 0; i < 4; ++i) {
            numberSymbol.add(number.charAt(i));
            strSymbol.add(str.charAt(i));
            if (number.charAt(i) == str.charAt(i)) {
                bull++;
            }
        }
        l3.retainAll(numberSymbol);
        cow = l3.size() - bull;
        if (bull == 4) {
            task = new Task(genNumber());
            return str + " - " + bull + "Б" + cow + "K (число угадано) \n---------------------------";
        }
        return str + " - " + bull + "Б" + cow + "K";
    }

    String genNumber() {

        final int MAX_NUMBER = 10;
        Integer[] randomNumbers = new Integer[MAX_NUMBER];
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = i;
        }
        Collections.shuffle(Arrays.asList(randomNumbers));
        return String.valueOf(randomNumbers[0]) + randomNumbers[1] + randomNumbers[2] + randomNumbers[3];
    }

    public void saveDateInFile(String str) {
        try (FileWriter writer = new FileWriter("C:\\history.txt", true)) {
            writer.write(str);
            writer.flush();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}
