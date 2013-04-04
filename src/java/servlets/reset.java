/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author trivium
 */
@WebServlet(name = "reset", urlPatterns = {"/reset"})
public class reset extends HttpServlet {
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int n = 0;
        if(null==getServletContext().getAttribute("cont"))
            request.getRequestDispatcher("/admin.jsp").forward(request, response);
        else
            n = Integer.parseInt(getServletContext().getAttribute("cont").toString());
        getServletContext().setAttribute("cont", null);
        for(int i = 1; i<=n;i++){
            getServletContext().setAttribute("jugador"+i, null);
        }
        getServletContext().setAttribute("start", null);
        request.getRequestDispatcher("/admin.jsp").forward(request, response);
    }

}
