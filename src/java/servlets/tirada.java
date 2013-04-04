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
@WebServlet(name = "tirada", urlPatterns = {"/tirada"})
public class tirada extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String jugl = request.getParameter("jugl").toString();
        String jug2 = request.getParameter("jug2").toString();
        if((request.getParameter("x") == "") || (request.getParameter("y") == "")){
            request.setAttribute("miss1", "Coordenades incorrectes.");
            request.getRequestDispatcher("/tauler.jsp").forward(request, response);
        }
        else if("null".equals(jug2)){
                request.setAttribute("miss1", "Espere el següent jugador per començar a jugar.");
                request.getRequestDispatcher("/tauler.jsp").forward(request, response);
        }
        else{
            String x = request.getParameter("y").toString();
            String y = request.getParameter("x").toString();
            String t = request.getParameter("numTauler").toString();
            int i = Integer.parseInt(getServletContext().getAttribute("Jug"+t).toString());
            int nJug = Integer.parseInt(request.getParameter("nJug").toString());
            if(getServletContext().getAttribute("guanyador"+t) != null){
                request.getRequestDispatcher("/tauler.jsp").forward(request, response);
            }
            else if(Integer.parseInt(getServletContext().getAttribute("pos"+t+""+x+""+y).toString())==0){
                if(i==nJug){
                    getServletContext().setAttribute("pos"+t+""+x+""+y,nJug);
                    getServletContext().setAttribute("JugTauler", t+""+i);
                    if(i==1)getServletContext().setAttribute("Jug"+t,"2");
                    else getServletContext().setAttribute("Jug"+t,"1");
                    if(comprovar(nJug, t, x, y)){
                        getServletContext().setAttribute("guanyador"+t,nJug);
                        request.setAttribute("miss1", "Has guanyat.");
                        request.getRequestDispatcher("/tauler.jsp").forward(request, response);
                    }
                    else{
                        request.setAttribute("miss1", "Tirada correcta.");
                        request.getRequestDispatcher("/tauler.jsp").forward(request, response);
                    }
                }
                else                
                    request.setAttribute("miss1", "Espera el seu torn");
                    request.getRequestDispatcher("/tauler.jsp").forward(request, response);{
                }
            }else{
                    request.setAttribute("miss1", "Casella plena.");
                    request.getRequestDispatcher("/tauler.jsp").forward(request, response);
            }

        }
        
    }

    private boolean comprovar(int nJug, String t, String x, String y) {
        boolean trobat = false;
        int cont = 0;
        //Comprovar Columna
        for(int i = 1; i<=3;i++){
                if(Integer.parseInt(getServletContext().getAttribute("pos"+t+""+x+""+i).toString())==nJug){
                    cont++;
                }
        }
        if(cont == 3){
            return true;
        }
        //Comprovar Fila
        cont = 0;
        for(int i = 1; i<=3;i++){
            if(Integer.parseInt(getServletContext().getAttribute("pos"+t+""+i+""+y).toString())==nJug){
                cont++;
            }
        }
        if(cont == 3){
            return true;
        }
        //Comprovar Diagos
        cont= 0;
        if("1".equals(x) || "3".equals(x)){
            for(int i = 1; i<=3;i++){
                if(Integer.parseInt(getServletContext().getAttribute("pos"+t+""+i+""+i).toString())==nJug){
                    cont++;
                }
            }
        }
        if("3".equals(y)||"1".equals(y)){
            if(cont != 3){
                cont = 0;
                if(Integer.parseInt(getServletContext().getAttribute("pos"+t+"13").toString())==nJug){
                    cont++;
                }
                if(Integer.parseInt(getServletContext().getAttribute("pos"+t+"22").toString())==nJug){
                    cont++;
                }
                if(Integer.parseInt(getServletContext().getAttribute("pos"+t+"31").toString())==nJug){
                    cont++;
                }
            }
        }
        if("2".equals(x) && "2".equals(y)){
            if(cont!=3){
                cont = 0;
                for(int i = 1; i<=3;i++){
                    if(Integer.parseInt(getServletContext().getAttribute("pos"+t+""+i+""+i).toString())==nJug){
                        cont++;
                    }
                }
                if(cont != 3){
                    cont = 0;
                    if(Integer.parseInt(getServletContext().getAttribute("pos"+t+"13").toString())==nJug){
                        cont++;
                    }
                    if(Integer.parseInt(getServletContext().getAttribute("pos"+t+"22").toString())==nJug){
                        cont++;
                    }
                    if(Integer.parseInt(getServletContext().getAttribute("pos"+t+"31").toString())==nJug){
                        cont++;
                    }
                }
            }
        }
        if(cont==3) return true;
        else return false;
    }

}
