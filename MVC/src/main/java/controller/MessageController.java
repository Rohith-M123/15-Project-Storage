package controller;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Message;

@WebServlet("/message")
public class MessageController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Create Model object
        Message message = new Message();

        // Add data to request scope
        request.setAttribute("msg", ((Message) message).getMessage());

        // Forward to the View (JSP)
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }
}
