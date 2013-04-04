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



@WebServlet(name = "buscarPartida", urlPatterns = {"/buscarPartida"})
public class buscarPartida extends HttpServlet {
    public void init(){

    }
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
       if(getServletContext().getAttribute("start") == null){
            for(int t = 1; t <=5;t++){
                for(int i = 1; i<=3;i++){
                    for(int j = 1; j<=3;j++){
                        getServletContext().setAttribute("pos"+t+""+i+""+j,"0");
                        getServletContext().setAttribute("Jug"+t,"1");
                    }
                }
            }
            getServletContext().setAttribute("start", "1");
        }
        if(request.getParameter("nick")==""){
            request.setAttribute("errorn", "Has de introduïr un nom");
            request.getRequestDispatcher("/index.jsp").forward(request, response);        
        }
        
        else{
            if(getServletContext().getAttribute("cont")!=null){
                int i = Integer.parseInt(getServletContext().getAttribute("cont").toString());
                if(i==10){
                    request.setAttribute("errorp", "No taulers disponibles, intenta-ho mes tard");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
                else{
                    i++;
                    getServletContext().setAttribute("cont",i);
                    getServletContext().setAttribute("jugador"+i,request.getParameter("nick"));
                    request.getSession().setAttribute("nick",request.getParameter("nick"));
                    request.getSession().setAttribute("jugador",i);
                    request.getRequestDispatcher("/tauler.jsp").forward(request, response);
                }
            }
            else{
                int i = 1;
                getServletContext().setAttribute("cont",i);
                getServletContext().setAttribute("jugador"+i,request.getParameter("nick"));
                request.getSession().setAttribute("nick",request.getParameter("nick"));
                request.getSession().setAttribute("jugador",i);
                request.getRequestDispatcher("/tauler.jsp").forward(request, response);

            }
        }        
    }
    
}
