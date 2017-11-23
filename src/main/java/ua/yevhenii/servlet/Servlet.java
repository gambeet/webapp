package ua.yevhenii.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.yevhenii.logger.LoggerU;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Servlet extends HttpServlet {

    private static Logger LOGGER = LoggerFactory.getLogger(Servlet.class);
    private List<String> list = new ArrayList<String>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = request.getParameter("param1");
        list.add(s);
        request.setAttribute("list", list);
        LoggerU.writeToLog(LOGGER, "Added new item \"" + s + "\"");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
